$.extend($.fn.validatebox.defaults.rules, {
    //移动手机号码验证
    mobile: {//value值为文本框中的值
        validator: function (value) {
            var reg = /^1[3-8]\d{9}$/;
            return reg.test(value);
        },
        message: '输入手机号码格式不准确'
    },
    emailwq: {//value值为文本框中的值
        validator: function (value) {
            var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
            return reg.test(value);
        },
        message: '输入邮箱格式不准确'
    },
    checkIp : {// 验证IP地址  
        validator : function(value) {  
            var reg = /^((1?\d?\d|(2([0-4]\d|5[0-5])))\.){3}(1?\d?\d|(2([0-4]\d|5[0-5])))$/ ;  
            return reg.test(value);  
        },  
        message : 'IP地址格式不正确(?.?.?.?)'
    },
    mobileAndPhone : {
    	 validator: function(value){
		    var reg1=/^((0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$/;
		    var reg2=/^(\d{7,8})(-(\d{3,}))?$/;
		    if(reg1.test(value)){
		    	return reg1.test(value);
		    }else if(reg2.test(value)){
		    	return reg2.test(value);
		    }
    	},
		message: '输入办公电话格式不正确'
    },
    chackfdsfds:{
    	 validator: function(value){
    		 if(value.length>=500){
    			return false;
    		}else{
    			return true;
    		}
     	},
 		message: '最多只能输入500个字符'
    }
});