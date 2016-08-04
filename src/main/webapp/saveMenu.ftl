<@content>
	<div class="easyui-panel" title="添加菜单" style="background-color:#F5F5F5;width:400px;padding:30px 60px">
		<form action="addMenu.do" method="post">
			<div style="margin-bottom:20px">
				<div>菜单名称:</div>
				<input class="easyui-textbox" name="menuName" style="width:100%;height:32px">
			</div>
			<div style="margin-bottom:20px">
				<div>父菜单:</div>
				<select class="easyui-combobox" name="parentId" style="width:100%;height:32px;">
					<#list parentMenu as item>
						<option value="${item.menuId}">${item.menuName}</option>
					</#list>
				</select>
			</div>
			<div style="margin-bottom:20px">
				<div>菜单路径:</div>
				<input class="easyui-textbox" name="menuUrl" style="width:100%;height:32px">
			</div>
			<div style="margin-bottom:20px">
				<div>菜单顺序(大号在后):</div>
				<input class="easyui-textbox" name="orderNo" style="width:100%;height:32px">
			</div>
			<div style="margin-bottom:20px">
				<div>菜单权限:</div>
				<input class="easyui-textbox" name="permition" style="width:100%;height:32px">
			</div>
			<div>
				<input type="submit" value="确认添加" >
			</div>
		</form>
	</div>
</@content>