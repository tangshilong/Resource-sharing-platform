package com.smates.dbc2.mapper;

import java.util.List;

import com.smates.dbc2.po.Resource;
import com.smates.dbc2.vo.CostumGame;
import com.smates.dbc2.vo.CostumResource;

public interface ResourceDao {
	
	/**
	 * 查找某一类资源
	 * @return
	 */
	public List<Resource> getResourceByType(CostumResource costumResource); 
	
	/**
	 * 符合条件的某一类资源记录个数
	 * @param costumResource
	 * @return
	 */
	public int countSum(CostumResource costumResource);
	
	/**
	 * 统计用户上传的资源数量
	 * @param costumResource
	 * @return
	 */
	public int countMyResource(CostumResource costumResource);
	
	/**
	 * 查找某个用户的资源
	 * @param accountNum 当前登录用户用户名
	 * @return
	 */
	public List<Resource> getMyResource(CostumResource costumResource);
	
	/**
	 * 删除某个资源
	 * @param id 资源id
	 */
	public void deleteResource(String id);

	/**
	 * 获取符合条件的game资源
	 * @param costumGame
	 * @return
	 */
	public List<Resource> getGameResource(CostumGame costumGame);

	/**
	 * 统计符合条件游戏资源个数
	 * @param costumGame
	 * @return
	 */
	public int countGame(CostumGame costumGame);

	/**
	 * 根据资源id查找允许使用的账户
	 * @param id
	 * @return
	 */
	public String getPermitAccountNumById(String id);

	/**
	 * 根据资源id查找账号密码内容
	 * @param id
	 * @return
	 */
	public String getContentById(String id);

	/**
	 * 根据accountnumber获取id
	 * 
	 * @param accountNumber
	 * @return
	 */
	public int getIdByAccountNum(String accountNumber);
	
	/**
	 * 用户上传资源
	 * @param resource
	 */
	public void addResource(Resource resource);
	
}
