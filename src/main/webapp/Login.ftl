<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>登录</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
	<div class="container">
		<section id="content">
			<form action="login.do" method="post">
				<h1>516资源共享平台</h1>
				<#if callback?has_content><div class="callback">账号或密码错误</div></#if>
				<div>
					<input type="text" placeholder="用户名" required=""
						id="username" name="accountNumber" />
				</div>
				<div>
					<input type="password" placeholder="密码" required=""
						id="password" name="userpwd" />
				</div>
				<div>
					<input type="submit" value="登录"/> 
					<input type="reset"/>
				</div>
			</form>
			<!-- form -->
		</section>
		<!-- content -->
	</div>
	<!-- container -->
	
	<script type="text/javascript" src="bootstrap/jquery.js"></script>
</body>
</html>