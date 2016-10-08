$(function() {
			$('#search_btn').click(function() {
				$('#dg').datagrid('load', {
					name : $('#name').val(),
					describe : $('#describe').val()
				});
			})
		})