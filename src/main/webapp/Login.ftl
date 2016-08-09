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
				<h1>智慧家庭数据库管理</h1>
				<div>
					<input type="text" placeholder="用户名" required=""
						id="accountNumber" name="accountNumber" />
				</div>
				<div>
					<input type="password" placeholder="密码" required=""
						id="password" name="userpwd" />
				</div>
				<div>
					<input type="submit" value="登录"/> 
				</div>
			</form>
			<!-- form -->
		</section>
		<!-- content -->
	</div>
	<!-- container -->
	
	<script type="text/javascript" src="js/jquery.js"></script>
</body>
</html>