<#macro html title="" >
<!DOCTYPE html>
<html lang="zh-CN">
  	<head>
	    <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <title>${title}</title>
	    <!-- Bootstrap -->
	    <link href="${rc.getContextPath()}/css/bootstrap.min.css" rel="stylesheet"> 
	    <link href="${rc.getContextPath()}/css/web.css" rel="stylesheet">  
	    <!--[if lt IE 9] -->
	    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
  	</head>
  	<body>
	    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	    <script src="${rc.getContextPath()}/js/bootstrap.min.js"></script>
	    <#nested>
	</body>
</html>
</#macro>

<#macro loginReply reply="1">
	<#if reply==1>
	
	<#elseif reply==0>
		<div class="alert alert-danger" role="alert">
		  <a href="#" class="alert-link">密码错误</a>
		</div>
	<#elseif reply==-1>
		<div class="alert alert-danger" role="alert">
		  <a href="#" class="alert-link">账号错误</a>
		</div>
	</#if>
</#macro>






