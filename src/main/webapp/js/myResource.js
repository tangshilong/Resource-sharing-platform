// 按条件进行查找
$(function() {
	$("#search_btn").click(function() {
		$('#dg').datagrid('load', {
			name : $('#name').val(),
			type : $('#type').val()
		});
	})
})

// 记录的删除和修改操作
$(function() {
	var pager = $('#dg').datagrid().datagrid('getPager'); // get the pager of
	// datagrid
	pager.pagination({
		buttons : [ {
			iconCls : 'icon-search',
			handler : function() {
				$('#dg').datagrid('load', {
					name : $('#name').val(),
					type : $('#type').val()
				});
			}
		}, {
			iconCls : 'icon-remove',
			handler : function() {
				var row = $('#dg').datagrid('getSelected');
				if (row) {
					$.messager.confirm("操作提示", "您确定要删除这条记录吗？", function(data) {
						if (data) {
							$.post('deleteResource.do', {
								id : row.id
							}, function(data) {
								$.messager.alert('提示', data.content, 'info');
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
					updateMenu(row.menuId);
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
