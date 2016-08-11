/**
 * Menu.html
 */
$('#ff').form({
	url : 'admin/addMenu.do',
	onSubmit : function() {
		return $(this).form('validate');
	},
	success : function(data) {
		$.messager.alert('Info', data.content, 'info');
	}
});

$(function() {
	$("#search_btn").click(function() {
		$('#dg').datagrid('load', {
			menuName : $('#menuName').val(),
			permiton : $('#permition').val()
		});
	})
})

$(function() {
	var pager = $('#dg').datagrid().datagrid('getPager'); // get the pager of
															// datagrid
	pager.pagination({
		buttons : [ {
			iconCls : 'icon-search',
			handler : function() {
				alert('search');
			}
		}, {
			iconCls : 'icon-remove',
			handler : function() {
				var row = $('#dg').datagrid('getSelected');
				if (row) {
					$.messager.confirm("操作提示", "您确定要删除这条记录吗？", function (data) {
			            if (data) {
			            	$.get('admin/deleteMenu.do', {
								menuId : row.menuId
							}, function(data) {
								$.messager.alert('提示', data.content, 'info');
								$(".pagination-load").trigger("click");
							})
			            }
			            else {
			                
			            }
			        });
				}else{
					$.messager.alert('提示', "请选中要删除删除的行" , 'info');
				}

			}
		}, {
			iconCls : 'icon-edit',
			handler : function() {
				alert('edit');
			}
		}, {
			iconCls : 'icon-load',
			handler : function() {
				alert('load');
			}
		} ]
	});
})

$(document).ready(function() {
   $("#parentId").val("0");
});
