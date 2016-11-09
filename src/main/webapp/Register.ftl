<!DOCTYPE html>
<html lang="en">

	<head>
		<meta charset="utf-8">
		<title>注册</title>
		<link rel="stylesheet" type="text/css" href="css/style.css" />
	</head>

	<body>
		<div class="container">
			<section id="content">
				<form action="register.do" method="post" enctype="multipart/form-data">
					<h1>516资源共享平台</h1>
					<#if callback?has_content>
						<div class="callback">${callback}</div>
					</#if>
					<div>
						<input type="text" placeholder="AccountNumber" required="" id="accountNumber" name="accountNumber" />
					</div>
					<div>
						<input type="text" placeholder="Nickname" required="" id="nickname" name="nickname" />
					</div>
					<div>
						<input type="password" placeholder="Password" required="" id="password" name="password" />
					</div>
					<div>
						<input type="password" placeholder="Password" required="" id="repwd" name="repwd" />
					</div>
					<div>
						<input type="text" placeholder="E-mail" required="" id="eMail" name="email" />
					</div>
					<div class="image">
						<div class="image-word">选择头像</div>
						<input type="file" class="image-choose" name="image" style="width: 200px; height: 32px; margin-top: 10px;">
					</div>
					<div>
						<input type="submit" value="注册" />
					</div>
					<div>
						<a href="login.do"><input type="button" value="登录" /></a>
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