$(document).ready(function() {
//		var Qiniu_UploadUrl = "http://up.qiniu.com";
//		var progressbar = $("#progressbar"),
//			progressLabel = $(".progress-label");
//		progressbar.progressbar({
//			value: false,
//			change: function() {
//				progressLabel.text(progressbar.progressbar("value") + "%");
//			},
//			complete: function() {
//				progressLabel.text("Complete!");
//			}
//		});
		//  $("#submit").click(function() {
		//      //普通上传
		//      var Qiniu_upload = function(f, token, key) {
		//          var xhr = new XMLHttpRequest();
		//          xhr.open('POST', Qiniu_UploadUrl, true);
		//          var formData, startDate;
		//          formData = new FormData();
		//          if (key !== null && key !== undefined) formData.append('key', key);
		//          formData.append('token', token);
		//          formData.append('file', f);
		//          var taking;
		//          xhr.upload.addEventListener("progress", function(evt) {
		//              if (evt.lengthComputable) {
		//                  var nowDate = new Date().getTime();
		//                  taking = nowDate - startDate;
		//                  var x = (evt.loaded) / 1024;
		//                  var y = taking / 1000;
		//                  var uploadSpeed = (x / y);
		//                  var formatSpeed;
		//                  if (uploadSpeed > 1024) {
		//                      formatSpeed = (uploadSpeed / 1024).toFixed(2) + "Mb\/s";
		//                  } else {
		//                      formatSpeed = uploadSpeed.toFixed(2) + "Kb\/s";
		//                  }
		//                  var percentComplete = Math.round(evt.loaded * 100 / evt.total);
		//                  progressbar.progressbar("value", percentComplete);
		//                  // console && console.log(percentComplete, ",", formatSpeed);
		//              }
		//          }, false);
		//
		//          xhr.onreadystatechange = function(response) {
		//              if (xhr.readyState == 4 && xhr.status == 200 && xhr.responseText != "") {
		//                  var blkRet = JSON.parse(xhr.responseText);
		//                  console && console.log(blkRet);
		//                  $("#dialog").html(xhr.responseText).dialog();
		//              } else if (xhr.status != 200 && xhr.responseText) {
		//
		//              }
		//          };
		//          startDate = new Date().getTime();
		//          $("#progressbar").show();
		//          xhr.send(formData);
		//      };
		//      var token = $("#token").val();
		//      if ($("#file")[0].files.length > 0 && token != "") {
		//          Qiniu_upload($("#file")[0].files[0], token, $("#key").val());
		//      } else {
		//          console && console.log("form input error");
		//      }
		//  })
	})
	// 按条件进行查找
$(function() {
	$("#search_btn").click(function() {
		$('#dg').datagrid('load', {
			name: $('#name').val(),
			type: $('#type').combobox("getValue")
		});
	})
})

// 记录的删除和修改操作
$(function() {
	var pager = $('#dg').datagrid().datagrid('getPager'); // get the pager of
	// datagrid
	pager.pagination({
		buttons: [{
			iconCls: 'icon-search',
			handler: function() {
				$('#dg').datagrid('load', {
					name: $('#name').val(),
					type: $('#type').combobox("getValue")
				});
			}
		}, {
			iconCls: 'icon-remove',
			handler: function() {
				var row = $('#dg').datagrid('getSelected');
				if(row) {
					$.messager.confirm("操作提示", "您确定要删除这条记录吗？", function(data) {
						if(data) {
							$.post('deleteResource.do', {
								id: row.id
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
			iconCls: 'icon-edit',
			handler: function() {
				var row = $('#dg').datagrid('getSelected');
				if(row) {
					updateResource(row.id);
				} else {
					$.messager.alert('提示', "请选中要修改的行", 'info');
				}
			}
		}, {
			iconCls: 'icon-load',
			handler: function() {
				alert('load');
			}
		}]
	});
})

// 提交表单
$('#addResource').form({
	url: 'addResource.do',
	onSubmit: function() {
		var chestr = $('#userlist').combobox('getValues');
		document.getElementById("permitAccountNumber").value = chestr;
		var Qiniu_UploadUrl = "http://up.qiniu.com";
		var progressbar = $("#progressbar"),
			progressLabel = $(".progress-label");
		progressbar.progressbar({
			value: false,
			change: function() {
				progressLabel.text(progressbar.progressbar("value") + "%");
			},
			complete: function() {
				progressLabel.text("Complete!");
			}
		});
		//普通上传
		var Qiniu_upload = function(f, token, key) {
			var xhr = new XMLHttpRequest();
			xhr.open('POST', Qiniu_UploadUrl, true);
			var formData, startDate;
			formData = new FormData();
			if(key !== null && key !== undefined) formData.append('key', key);
			formData.append('token', token);
			formData.append('file', f);
			var taking;
			xhr.upload.addEventListener("progress", function(evt) {
				if(evt.lengthComputable) {
					var nowDate = new Date().getTime();
					taking = nowDate - startDate;
					var x = (evt.loaded) / 1024;
					var y = taking / 1000;
					var uploadSpeed = (x / y);
					var formatSpeed;
					if(uploadSpeed > 1024) {
						formatSpeed = (uploadSpeed / 1024).toFixed(2) + "Mb\/s";
					} else {
						formatSpeed = uploadSpeed.toFixed(2) + "Kb\/s";
					}
					var percentComplete = Math.round(evt.loaded * 100 / evt.total);
					progressbar.progressbar("value", percentComplete);
					// console && console.log(percentComplete, ",", formatSpeed);
				}
			}, false);

			xhr.onreadystatechange = function(response) {
				if(xhr.readyState == 4 && xhr.status == 200 && xhr.responseText != "") {
					var blkRet = JSON.parse(xhr.responseText);
					console && console.log(blkRet);
					$("#dialog").html(xhr.responseText).dialog();
				} else if(xhr.status != 200 && xhr.responseText) {

				}
			};
			startDate = new Date().getTime();
			$("#progressbar").show();
			xhr.send(formData);
		};
		var token = $("#token").val();
		console && console.log(token);
		if($("#file")[0].files.length > 0 && token != "") {
			console && console.log($("#file")[0].files.length);
			Qiniu_upload($("#file")[0].files[0], token, $("#key").val());
		} else {
			console && console.log("form input error");
			return false;
		}

		return true;
	},
	success: function(data) {
		var obj = eval("(" + data + ")");
		$.messager.alert('success', obj.content);
		updateTab("资源新增");
		document.getElementById("id").value = "";
	}
});

function updateResource(id) {
	$('#myr_tab').tabs('select', "资源新增");
	updateTab("编辑资源");
	$('#addResource').form('load', 'admin/getResourceById.do?id=' + id);

}

//改变tab
function updateTab(tabName) {
	var tab = $('#myr_tab').tabs('getTab', 1); // 取得第2个tab
	$('#myr_tab').tabs('update', {
		tab: tab,
		options: {
			title: tabName
		}
	});
}