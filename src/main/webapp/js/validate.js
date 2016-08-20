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
	},
	isAccountNumber : {
		validator : function(value,param){
			return /[A-Za-z0-9]{1,15}$/.test(value);
		}
	},
	isPassword : {
		validator : function(value,param){
			return /[A-Za-z0-9!.]{6,20}$/.test(value);
		}
	},
	iseMail : {
		validator : function(value,param){
			return /[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(.[a-zA-Z0-9_-]+)+$/.test(value);
		}
	}
});