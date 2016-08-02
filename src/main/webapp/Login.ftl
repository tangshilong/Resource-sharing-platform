<@html title="白江伟">	
	<@form id="login-logindiv" action="submit.do">
		<@loginReply reply="${reply}" />
	  	<@inputdiv name="userid" placeholder="请输入账号" value="账号" />
	  	<@inputdiv name="userpwd" placeholder="请输入密码" value="密码" type="password" />
        <@loginBtn />
        <@signupBtn />	    
	</@form>	
</@html>




