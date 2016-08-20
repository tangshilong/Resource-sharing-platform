//user.html
$(function() {
	var pager = $('#dg').datagrid().datagrid('getPager'); // get the pager of
	// datagrid
	pager.pagination({
		buttons : [ {
			iconCls : 'icon-search',
			handler : function() {
				$('#dg').datagrid('load', {
					accountNumber : $('#accountNumber').val(),
					nickName : $('#nickName').val(),
				});
			}
		}, {
			iconCls : 'icon-remove',
			handler : function() {
				var row = $('#dg').datagrid('getSelected');
				if (row) {
					$.messager.confirm("操作提示", "您确定要删除这条记录吗？", function(data) {
						if (data) {
							$.get('deleteUser.do',{
								accountNumber:row.accountNumber
							},function(data){
//								var obj = eval ("(" + data + ")");
								$.messager.alert('提示',data.content,'info');
								$(".pagination-load").trigger("click");
							})
						} else {

						}
					});
				} else {
					$.messager.alert('提示', "请选中要删除的行", 'info');
				}

			}
		}, {
			iconCls : 'icon-edit',
			handler : function() {
				var row = $('#dg').datagrid('getSelected');
				if (row) {
					updateUser(row.id);
				} else {
					$.messager.alert('提示', "请选中要修改的行", 'info');
				}
			}
		}, {
			iconCls : 'icon-load',
			handler : function() {
				alert('load');
			}
		} ]
	});
})

$('#addUser').form({
	url : 'saveUser.do',
	onSubmit : function() {
		//密码验证
		var pwd = $('#password').val();
		var testpwd = $('#testPwd').val();
		if(pwd!=testpwd){
			$.messager.alert('error','两次输入密码不一致');
			return false;
		}
		return $(this).form('validate');
	},
	success : function(data) {
		var obj = eval ("(" + data + ")");
			$.messager.alert('success',obj.content);
	}
});

function updateUser(id) {
	$('#user_tab').tabs('select', "用户新增");
	updateUserTab("编辑用户");
	$('#addUser').form('load', 'saveUser.do?id=' + id);
}

//改变tab
function updateUserTab(tabName) {
	var tab = $('#user_tab').tabs('getTab', 1); // 取得第2个tab
	$('#user_tab').tabs('update', {
		tab : tab,
		options : {
			title : tabName
		}
	});
}

//查找用户
$(function() {
	$("#search_btn_user").click(function() {
		$('#dg').datagrid('load', {
			accountNumber : $('#accountNumber').val(),
			nickName : $('#nickName').val()
		});
	})
})
