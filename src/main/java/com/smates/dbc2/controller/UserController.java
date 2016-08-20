package com.smates.dbc2.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smates.dbc2.po.User;
import com.smates.dbc2.utils.ShiroUtils;
import com.smates.dbc2.utils.ValidaterUtil;
import com.smates.dbc2.vo.BaseMsg;
import com.smates.dbc2.vo.DataGrideRow;

/**
 * 用户相关的请求
 * @author tangShilong
 * @param <user>
 *
 */
@Controller
public class UserController<user> extends BaseController{
	private static Logger logger = Logger.getLogger(UserController.class);
	
	/**
	 * 返回登录界面
	 * @return
	 */
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login(){
		return "Login.ftl";
	}
	
	/**
	 * TODO 处理登录请求
	 * @param userid 用户登录的accountNumber
	 * @param userpwd 用户登录的明文密码
	 * @return
	 */
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String submit(String accountNumber,String userpwd){
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(accountNumber, userpwd);
		try{
			subject.login(token);
		}catch(AuthenticationException ae){
			logger.info("密码错误");
			return "Login.ftl";
		}
		logger.info("登录成功");
		return "redirect:home.do";
	}
	
	/**
	 * TODO 登出
	 * @return
	 */
	@RequestMapping("logout")
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "Login.ftl";
    }
	
	/**
	 * TODO 登录成功后,显示主界面,根据用户不同的权限,显示不同的菜单
	 * @param modelMap
	 * @return
	 * TODO tangShilong 未完成
	 */
	@RequestMapping("home")
	public String home(ModelMap modelMap){
		modelMap.addAttribute("menulist", menuService.getMenuByRoles());
		modelMap.addAttribute("userName", userService.getUserByAccountNumber(userService.getCurrentUserId()).getNickName());
		return "Home.ftl";
	}
	
//	@RequestMapping("test")
//	public String test(ModelMap modelMap){
//		return "Home.ftl";
//	}

	/**
	 * TODO 创建用户
	 * @param accountNumber
	 * @param nickName
	 * @param password
	 * @param eMail
	 * @return 创建是否成功
	 * TODO tangShilong 未完成
	 */
	@RequestMapping(value = "saveUser",method=RequestMethod.POST)
	@ResponseBody
	public BaseMsg createUser(Integer id,String accountNumber,String nickName,String password,
	    String eMail,Integer role, String enable){
		if(!ValidaterUtil.checkAccountNumber(accountNumber)){
			logger.info("账号格式错误");
			return new BaseMsg(false, "wrong accountNumber");
		}
		if(!ValidaterUtil.checkPassWord(password)){
			logger.info("密码格式错误");
			return new BaseMsg(false, "password wrong");
		}
		if(eMail!=null){
			if(!ValidaterUtil.checkEMail(eMail)){
				logger.info("邮箱格式不正确");
				return new BaseMsg(false, "wrong e-mail");
			}
		}
		User user2 = new User();
		user2.setAccountNumber(accountNumber);
		user2.setNickName(nickName);
		user2.setPassword(ShiroUtils.passwdMD5(password));
		user2.seteMail(eMail);
		user2.setRole(role);
		user2.setEnable(enable);
		logger.info(user2.toString());
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String time=formatter.format(date);
		user2.setCreateDate(time);
  
		if(id==null){
			logger.info("add user");
			User user = userService.getUserByAccountNumber(accountNumber);
			if(user!=null){
				logger.info("账号已存在，注册失败");
				return new BaseMsg(false, "accountNumber already exist");
			}
			userService.createUser(user2);
			logger.info("用户创建成功");
			return new BaseMsg(true, "操作成功");
		}else {
			user2.setId(id);
			userService.updateUser(user2);
			return new BaseMsg(true, "用户修改成功");
		}
	}
	
	/**
	 * TODO 获取指定页数所有用户信息,返回用户总数
	 * @return
	 * TODO tangshilong 未完成					
	 */
	@RequestMapping(value = "getAllUser",method = RequestMethod.GET)
	@ResponseBody
	public DataGrideRow<User> getAllUser(Integer page, Integer rows,String accountNumber,String nickName){
		logger.info("根据页数行数获取用户信息");
		List<User>	list = userService.getAllUser(page, rows,accountNumber,nickName);
		int total = userService.getUserCount();
		return new DataGrideRow<User>(total,list);
	}
	
	/**
	 * 根据accountNumber删除用户
	 * @param accountNumber
	 * @return
	 */
	@RequestMapping(value = "deleteUser",method = RequestMethod.GET)
	@ResponseBody
	public BaseMsg deleteUser (String accountNumber){
		logger.info("开始删除user");
		userService.deleteUser(accountNumber);
		logger.info("user删除成功");
		return new BaseMsg(true, "删除成功");
	}
	
	
	/**
	 * 根据accountNumber查找用户
	 * @param accountNumber
	 * @return
	 */
	@RequestMapping(value = "getUserByAccountNumber",method = RequestMethod.GET)
	@ResponseBody
	public User getUserByAccountNumber(String accountNumber){
		return userService.getUserByAccountNumber(accountNumber);
	}
	
	
	
	
	
	
	
	
}