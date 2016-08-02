<#macro form id="" method="post" action="">
	<div id=${id}>
		<form class="form-horizontal" method="${method}" action="${action}">
		 	<#nested>
		</form>
	</div>
</#macro>

<#macro inputdiv name="" placeholder="" value="" type="text">
  <div class="form-group">
    <label for="${name}" class="col-sm-2 control-label">${value}</label>
    <div class="col-sm-10">
      <input id="${name}" type="${type}" name="${name}" class="form-control" placeholder="${placeholder}">
    </div>
  </div>
 </#macro>
 
 <#macro loginBtn>
 	<input id="login-submit" type="submit" class="btn btn-primary" value="登录">
 </#macro>
 
  <#macro signupBtn>
 	<input id="login-signup" type="button" class="btn btn-primary" value="注册" >
 </#macro>