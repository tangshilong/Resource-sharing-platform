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
						<#if accountNumber?has_content>
						<input type="text" value=${accountNumber} id="accountNumber" name="accountNumber" />
						<#else>
						<input type="text" placeholder="请输入账号(1-15位大小写字母和数字的组合)" id="accountNumber" name="accountNumber" />
						</#if>
					</div>
					<div>
						<#if nickname?has_content>
						<input type="text" value=${nickname} id="nickname" name="nickname" />
						<#else>
						<input type="text" placeholder="请输入昵称" required="" id="nickname" name="nickname" />
						</#if>
					</div>
					<div>
						<#if password?has_content>
						<input type="password" value=${password} id="password" name="password" />
						<#else>
						<input type="password" placeholder="请输入密码（6-40位大小写字母,数字和“.!”的组合）" id="password" name="password" />
						</#if>
					</div>
					<div>
						<#if repwd?has_content>
						<input type="password" value=${repwd} id="repwd" name="repwd" />
						<#else>
						<input type="password" placeholder="请再次输入" id="repwd" name="repwd" />
						</#if>
					</div>
					<div>
						<#if email?has_content>
						<input type="text" value=${email} id="email" name="email" />
						<#else>
						<input type="text" placeholder="请输入邮箱" id="email" name="email" />
						</#if>
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
	</body>
</html>