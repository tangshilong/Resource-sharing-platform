$.extend($.fn.validatebox.defaults.rules, {
	isNumber : {
		validator : function(value, param) {

			return /^-?\d+\.?\d*$/.test(value);

		},
		message : '请输入正确的数字!'
	},
	istelNumber : {
		validator : function(value, param) {

			return /^0?1[3|4|5|8|7|9][0-9]\d{8}$/.test(value);

		},
		message : '请输入正确的电话号码数字!'
	}

});