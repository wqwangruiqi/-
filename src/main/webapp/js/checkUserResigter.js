 
 
 
//输入用户姓名失去焦点事件(检查输入用户信息) 
function checkUserName(obj){
	flagUserName=false;
	if($(obj).val()==null || $(obj).val()=='' || $(obj).val().length<2 || $(obj).val().length>20){
		$("#labelbox_username").removeClass('err_label');
		$("#labelbox_username").addClass('err_label');
		$("#error_span_username").html("输入用户姓名格式错误!");
		$("#username_error").show();
	}else{
		$.ajax({
			type: "POST",
			url: ctx+"/management/camsuser/cams-user-register!checkUserName.action",
			data: {
				"userInfo.userName": $(obj).val()
			},
			dataType: "json",
			success: function(json){
				if(json.ISUSED=="Name_NOT"){//用户名存在
					$("#labelbox_username").removeClass('err_label');
					$("#labelbox_username").addClass('err_label');
					$("#error_span_username").html("用户姓名已经存在!");
					$("#username_error").show();
				 }else if(json.ISUSED=="Name_OK"){
					 $("#username_error").hide();
					$("#labelbox_username").removeClass('err_label');
					flagUserName=true;
				 }else if(json.ISUSED=="ERROR"){
					$("#labelbox_username").removeClass('err_label');
					$("#labelbox_username").addClass('err_label');
					$("#error_span_username").html("查询数据错误请稍后再试!");
					$("#username_error").show();
				 }
			}
		});
	}
}


//输入用户邮箱失去焦点事件(检查输入用户邮箱信息) 
function checkUserEmail(obj){
	flagUserEmail=false;
	if($(obj).val()==null || $(obj).val()==''){
		$("#labelbox_useremail").removeClass('err_label');
		$("#labelbox_useremail").addClass('err_label');
		$("#error_span_useremail").html("用户邮箱不能为空!");
		$("#useremail_error").show();
	}else if(!$(obj).val().match(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/)){
		$("#labelbox_useremail").removeClass('err_label');
		$("#labelbox_useremail").addClass('err_label');
		$("#error_span_useremail").html("用户邮箱格式不正确!");
		$("#useremail_error").show();
	}else{
		$.ajax({
			type: "POST",
			url: ctx+"/management/camsuser/cams-user-register!checkUserEmail.action",
			data: {
				"userInfo.userEmail": $(obj).val()
			},
			dataType: "json",
			success: function(json){
				if(json.ISUSED=="Email_NOT"){//邮箱存在
					$("#labelbox_useremail").removeClass('err_label');
					$("#labelbox_useremail").addClass('err_label');
					$("#error_span_useremail").html("用户邮箱已经存在!");
					$("#useremail_error").show();
				 }else if(json.ISUSED=="Email_OK"){
					$("#useremail_error").hide();
					$("#labelbox_useremail").removeClass('err_label');
					flagUserEmail=true;
				 }else if(json.ISUSED=="ERROR"){
					$("#labelbox_useremail").removeClass('err_label');
					$("#labelbox_useremail").addClass('err_label');
					$("#error_span_useremail").html("查询数据错误请稍后再试!");
					$("#useremail_error").show();
				 }
			}
		});
	}
}




//检查输入用户电话号码格式
function checkUserPhone(obj){
	flagUserPhone=false;
	var reg=reg = /^1[34578]\d{9}$/;
	  if(reg.test($(obj).val())){
		  $.ajax({
				type: "POST",
				url: ctx+"/management/camsuser/cams-user-register!checkUserPhone.action",
				data: {
					"userInfo.userPhone": $(obj).val()
				},
				dataType: "json",
				success: function(json){
					 if(json.ISUSED=="Phone_OK"){
							$("#userPhone_error").hide();
							$("#labelbox_userPhone").removeClass('err_label');
							flagUserPhone=true;
					}else{
						$("#labelbox_userPhone").removeClass('err_label');
						$("#labelbox_userPhone").addClass('err_label');
						if(json.ISUSED=="Phone_NOT"){
							$("#error_span_userPhone").html("电话号码已经存在!");
						}else if(json.ISUSED=="ERROR"){
							$("#error_span_userPhone").html("查询数据错误请稍后再试!");
						}
						$("#userPhone_error").show();
					}
				}
			});
	  }else {
	  		$("#labelbox_userPhone").removeClass('err_label');
			$("#labelbox_userPhone").addClass('err_label');
			$("#error_span_userPhone").html("电话号码格式输入错误!");
			$("#userPhone_error").show();
	  }
}




//输入用户真实姓名失去焦点事件(检查输入用户真实姓名信息)
function checkUserRealName(obj){
	flagUserRealName=false;
	if($(obj).val()==null || $(obj).val()=='' || $(obj).val().length<2 || $(obj).val().length>20){
		$("#labelbox_userRealName").removeClass('err_label');
		$("#labelbox_userRealName").addClass('err_label');
		$("#userRealName_error").show();
	}else{
		$("#userRealName_error").hide();
		$("#labelbox_userRealName").removeClass('err_label');
		flagUserRealName=true;
	}
   	
}






//输入用户密码失去焦点事件(检查输入用户密码信息) 
function checkUserPwd(obj){
	flagUserPwd=false;
	if($(obj).val()==null || $(obj).val()=='' || $(obj).val().length<4 || $(obj).val().length>20){
		$("#labelbox_userpwd").removeClass('err_label');
		$("#labelbox_userpwd").addClass('err_label');
		$("#userpwd_error").show();
	}else{
		$("#userpwd_error").hide();
		$("#labelbox_userpwd").removeClass('err_label');
		flagUserPwd=true;
	}
	//再次确认两次输入密码是否正确
	if($("#userpasswordagain").val()!=null&&$("#userpasswordagain").val()!=''){
		checkUserPwdagain($("#userpasswordagain"));
	}
	
}

//再次输入用户密码失去焦点事件(检查输入用户确认密码信息) 
function checkUserPwdagain(obj){
	flagUserPwdAgain=false;
	if($(obj).val()==null || $(obj).val()=='' || $(obj).val().length<4 || $(obj).val().length>20){
		$("#labelbox_userpwdagain").removeClass('err_label');
		$("#labelbox_userpwdagain").addClass('err_label');
		$("#error_span_userpwdagain").html("输入用户密码长度错误!");
		$("#userpwdagain_error").show();
	}else if($(obj).val()!=$("#userpassword").val()){
		$("#labelbox_userpwdagain").removeClass('err_label');
		$("#labelbox_userpwdagain").addClass('err_label');
		$("#error_span_userpwdagain").html("两次输入密码不相同!");
		$("#userpwdagain_error").show();
	}else{
		$("#userpwdagain_error").hide();
		$("#labelbox_userpwdagain").removeClass('err_label');
		flagUserPwdAgain=true;
	}
}




//检查输入用户办公电话号码格式
function checkUserTel(obj){
	flagUserTel=false;
	var reg1=/^((0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$/;
    var reg2=/^(\d{7,8})(-(\d{3,}))?$/;
    if(reg1.test($(obj).val())||reg2.test($(obj).val())){
    	$("#userTel_error").hide();
		$("#labelbox_userTel").removeClass('err_label');
    	flagUserTel=true;
    }else {
    	$("#labelbox_userTel").removeClass('err_label');
		$("#labelbox_userTel").addClass('err_label');
		$("#error_span_userTel").html("办公电话格式输入错误!");
		$("#userTel_error").show();
    }
}





//检查输入用户IP地址格式
function checkUserIpAddr(obj){
	flagUserIpAddr=false;
	//var reg = /^((1?\d?\d|(2([0-4]\d|5[0-5])))\.){3}(1?\d?\d|(2([0-4]\d|5[0-5])))$/ ; 
	 var reg = /^((10)\.(32)\.(25[0-5]|2[0-4]\d|[0-1]\d{2}|[1-9]?\d)\.(25[0-5]|2[0-4]\d|[0-1]\d{2}|[1-9]?\d))$/ ;  
    if(reg.test($(obj).val())){
    	$("#ipAddr_error").hide();
		$("#labelbox_ipAddr").removeClass('err_label');
		flagUserIpAddr=true;
    }else {
    	$("#labelbox_ipAddr").removeClass('err_label');
		$("#labelbox_ipAddr").addClass('err_label');
		$("#error_span_ipAddr").html("IP地址格式输入错误!");
		$("#ipAddr_error").show();
    }
}



//检测用户输入的房间号码
function checkUserRoomNumber(obj){
	flagUserRoomNumber=false;
	if($(obj).val()==null || $(obj).val()=='' || $(obj).val().length<1 || $(obj).val().length>20){
		$("#labelbox_userRoomNumber").removeClass('err_label');
		$("#labelbox_userRoomNumber").addClass('err_label');
		$("#error_span_userRoomNumber").html("输入用户房间号码长度错误!");
		$("#userRoomNumber_error").show();
	}else{
		$("#userRoomNumber_error").hide();
		$("#labelbox_userRoomNumber").removeClass('err_label');
		flagUserRoomNumber=true;
	}
}
//检测用户输入的课题名称 任务来源
function checkUserTaskSource(obj){
	flagUserTaskSource=false;
	if($(obj).val()==null || $(obj).val()=='' || $(obj).val().length<1 || $(obj).val().length>500){
		$("#labelbox_userTaskSource").removeClass('err_label');
		$("#labelbox_userTaskSource").addClass('err_label');
		$("#error_span_userTaskSource").html("输入任务来源(课题名称)长度错误!");
		$("#userTaskSource_error").show();
	}else{
		$("#userTaskSource_error").hide();
		$("#labelbox_userTaskSource").removeClass('err_label');
		flagUserTaskSource=true;
	}
}

//检测用户输入的工作内容
function checkUserWorkDesc(obj){
	flagUserWorkDesc=false;
	if($(obj).val()==null || $(obj).val()=='' || $(obj).val().length<1 || $(obj).val().length>500){
		$("#labelbox_userWorkDesc").removeClass('err_label');
		$("#labelbox_userWorkDesc").addClass('err_label');
		$("#error_span_userWorkDesc").html("输入任务来源(课题名称)长度错误!");
		$("#userWorkDesc_error").show();
	}else{
		$("#userWorkDesc_error").hide();
		$("#labelbox_userWorkDesc").removeClass('err_label');
		flagUserWorkDesc=true;
	}
}

function checkTime(){
	flagUserTime=false;
	if(($("#useDataTimeBegin").val()==null||$("#useDataTimeBegin").val()=='')||($("#useDataTimeEnd").val()==null||$("#useDataTimeEnd").val()=='')){
		$("#userTime_error").show();
	}else{
		flagUserTime=true;
		$("#userTime_error").hide();
	}
}


function check_id(obj){
	var value=$(obj).val();
    var arrExp = [7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2];//加权因子  
    var arrValid = [1, 0, "X", 9, 8, 7, 6, 5, 4, 3, 2];//校验码  
    if(/^\d{17}\d|x$/i.test(value)){   
        var sum = 0, idx;  
        for(var i = 0; i < value.length - 1; i++){  
            // 对前17位数字与权值乘积求和  
            sum += parseInt(value.substr(i, 1), 10) * arrExp[i];  
        }  
        // 计算模（固定算法）  
        idx = sum % 11;  
        // 检验第18为是否与校验码相等  
        return arrValid[idx] == value.substr(17, 1).toUpperCase();  
    }else{  
        return false;  
    }  
}


function checkUserIdCard(obj){
	flagUserIdCard=false;
	if(check_id(obj)){
		$("#userIdCard_error").hide();
		$("#labelbox_userIdCard").removeClass('err_label');
		flagUserIdCard=true;
	}else{
		$("#labelbox_userIdCard").removeClass('err_label');
		$("#labelbox_userIdCard").addClass('err_label');
		$("#error_span_userIdCard").html("输入身份证格式验证未通过请重新输入!");
		$("#userIdCard_error").show();
	}
}

//输入工作证编号失去焦点事件(检查输入工作证编号信息)
function checkUserWorkingCard(obj){
	flagUserWorkingCard=false;
	if($(obj).val()==null || $(obj).val()=='' || $(obj).val().length<2 || $(obj).val().length>50){
		$("#labelbox_workingCard").removeClass('err_label');
		$("#labelbox_workingCard").addClass('err_label');
		$("#error_span_workingCard").html("输入工作证编号长度错误!");
		$("#workingCard_error").show();
	}else{
		$("#workingCard_error").hide();
		$("#labelbox_workingCard").removeClass('err_label');
		flagUserWorkingCard=true;
	}
}






//输入合作专家失去焦点事件(检查输入专家姓名信息)
function checkExpertName(obj){
	flagExpertName=false;
	if($(obj).val()==null || $(obj).val()=='' || $(obj).val().length<2 || $(obj).val().length>20){
		$("#labelbox_expertName").removeClass('err_label');
		$("#labelbox_expertName").addClass('err_label');
		$("#error_span_expertName").html("输入合作专家姓名长度错误!");
		$("#expertName_error").show();
	}else{
		$("#expertName_error").hide();
		$("#labelbox_expertName").removeClass('err_label');
		flagExpertName=true;
	}
   	
}


//输入合作合作项目名字失去焦点事件(检查输入合作项目名字信息)
function checkProjectName(obj){
	flagProjectName=false;
	if($(obj).val()==null || $(obj).val()=='' || $(obj).val().length<2 || $(obj).val().length>50){
		$("#labelbox_projectName").removeClass('err_label');
		$("#labelbox_projectName").addClass('err_label');
		$("#error_span_projectName").html("输入合作项目名长度错误!");
		$("#projectName_error").show();
	}else{
		$("#projectName_error").hide();
		$("#labelbox_projectName").removeClass('err_label');
		flagProjectName=true;
	}
}


 


//输入合作合作项简介失去焦点事件(检查输入合作项目简介信息)
function checkProjectDesc(obj){
	flagProjectDesc=false;
	if($(obj).val()==null || $(obj).val()=='' || $(obj).val().length<2 || $(obj).val().length>500){
		$("#labelbox_projectDesc").removeClass('err_label');
		$("#labelbox_projectDesc").addClass('err_label');
		$("#error_span_projectDesc").html("输入合作项目简介信息长度错误!");
		$("#projectDesc_error").show();
	}else{
		$("#projectDesc_error").hide();
		$("#labelbox_projectDesc").removeClass('err_label');
		flagProjectDesc=true;
	}
}



//输入合作单位失去焦点事件(检查输入合作单位信息)
function checkCooperative(obj){
	flagCooperative=false;
	if($(obj).val()==null || $(obj).val()=='' || $(obj).val().length<2 || $(obj).val().length>50){
		$("#labelbox_cooperative").removeClass('err_label');
		$("#labelbox_cooperative").addClass('err_label');
		$("#error_span_cooperative").html("输入合作单位长度错误!");
		$("#cooperative_error").show();
	}else{
		$("#cooperative_error").hide();
		$("#labelbox_cooperative").removeClass('err_label');
		flagCooperative=true;
	}
}

//输入合作项目编号失去焦点事件(检查输入合作项目编号信息)
function checkProjectNumber(obj){
	flagProjectNumber=false;
	if($(obj).val()==null || $(obj).val()=='' || $(obj).val().length<2 || $(obj).val().length>50){
		$("#labelbox_projectNumber").removeClass('err_label');
		$("#labelbox_projectNumber").addClass('err_label');
		$("#error_span_projectNumber").html("输入合作项目编号长度错误!");
		$("#projectNumber_error").show();
	}else{
		$("#projectNumber_error").hide();
		$("#labelbox_projectNumber").removeClass('err_label');
		flagProjectNumber=true;
	}
}


//输入合作项目资助单位失去焦点事件(检查输入合作项目资助单位信息)
function checkCooperativePartner(obj){
	flagCooperativePartner=false;
	if($(obj).val()==null || $(obj).val()=='' || $(obj).val().length<2 || $(obj).val().length>50){
		$("#labelbox_cooperativePartner").removeClass('err_label');
		$("#labelbox_cooperativePartner").addClass('err_label');
		$("#error_span_cooperativePartner").html("输入合作项目资助单位长度错误!");
		$("#cooperativePartner_error").show();
	}else{
		$("#cooperativePartner_error").hide();
		$("#labelbox_cooperativePartner").removeClass('err_label');
		flagCooperativePartner=true;
	}
}
 



var flagUserName=false;
var flagUserRealName=false;
var flagUserEmail=false;
var flagUserPwd=false;
var flagUserPwdAgain=false;
var flagUserPhone=false;
var flagUserTaskSource=false;
var flagUserWorkDesc=false;
var flagUserTime=false;

var flagUserIdCard=false;
var flagUserWorkingCard=false;

var flagExpertName=false;
var flagProjectName=false;
var flagProjectDesc=false;
var flagCooperative=false;
var flagProjectNumber=false;
var flagCooperativePartner=false;



function checkFormAll(){
	if(flagUserName==false){
		checkUserName($("input[name='userInfo.userName']"));
		if(flagUserName==false)return false;
	}
	if(flagUserRealName==false){
		checkUserRealName($("input[name='userInfo.userNameRealy']"))
		if(flagUserRealName==false)return false;
	}
	if(flagUserEmail==false){
		checkUserEmail($("input[name='userInfo.userEmail']"))
		if(flagUserEmail==false)return false;
	}
	if(flagUserPhone==false){
		checkUserPhone($("input[name='userInfo.userPhone']"))
		if(flagUserPhone==false)return false;
	}
	  
	if(flagUserTaskSource==false){
		checkUserTaskSource($("input[name='userInfo.userTaskSource']"))
		if(flagUserTaskSource==false)return false;
	}
	if(flagUserWorkDesc==false){
		checkUserWorkDesc($("input[name='userInfo.userWorkDesc']"))
		if(flagUserWorkDesc==false)return false;
	}
	if(flagUserTime==false){
		checkTime();
		if(flagUserTime==false)return false;
	}
	if(flagUserPwd==false){
		checkUserPwd($("#userpassword"));
		if(flagUserPwd==false)return false;
	}
	if(flagUserPwdAgain==false){
		checkUserPwdagain($("#userpasswordagain"));
		if(flagUserPwdAgain==false)return false;
	}
	
	if($("input[name='userInfo.userCountry']:checked").val()==1){//国内
		if(flagUserIdCard==false){
			checkUserIdCard($("input[name='userInfo.userIdCard']"))
			if(flagUserIdCard==false)return false;
		}
		if(flagUserWorkingCard==false){
			checkUserWorkingCard($("input[name='userInfo.workingCard']"))
			if(flagUserWorkingCard==false)return false;
		}
	}else if($("input[name='userInfo.userCountry']:checked").val()==2){//国外
		if(flagExpertName==false){
			checkExpertName($("input[name='userInfo.expertName']"))
			if(flagExpertName==false)return false;
		}
		if(flagCooperative==false){
			checkCooperative($("input[name='userInfo.cooperative']"))
			if(flagCooperative==false)return false;
		}
		if(flagProjectName==false){
			checkProjectName($("input[name='userInfo.projectName']"))
			if(flagProjectName==false)return false;
		}	
		if(flagProjectNumber==false){
			checkProjectNumber($("input[name='userInfo.projectNumber']"))
			if(flagProjectNumber==false)return false;
		}
		if(flagProjectDesc==false){
			checkProjectDesc($("input[name='userInfo.projectDesc']"))
			if(flagProjectDesc==false)return false;
		}
		if(flagCooperativePartner==false){
			checkCooperativePartner($("input[name='userInfo.cooperativePartner']"))
			if(flagCooperativePartner==false)return false;
		}
	}
	return true;
}




//注册提交
function submitform(){
	if(checkFormAll()){
		//开始注册用户信息
		$("#load-zz").show();
		$.ajax({
			url : ctx+"/management/camsuser/cams-user-register!register.action",
			type : 'post',
			data : $("#registerForm").serialize(),
			success : function(json) {
				$("#load-zz").hide();
				if(json.ISSAVEOK=="OK"){
					$.messager.alert("操作提示", "个人申请表保存成功,请等待管理员审核!", "info", function () {  
						window.location.href=ctx;
						//window.location.href=ctx+"/management/camsuser/cams-user-info!exportWord.action?userInfo.id="+json.USERINFOID;
						//window.open(ctx+"/management/camsuser/cams-user-info!exportWord.action?userInfo.id="+json.USERINFOID);
			        });
				 }else if(json.ISSAVEOK=="ERROR"){
					 $.messager.alert("温馨提示", "用户注册失败!");
					  
				 }
			}
		});
	}
}


//监测任务来源等填写的数据长度
function onCheckMaxLength(obj){
	if($(obj).val().length>500){
		$(obj).val($(obj).val().substring(0,500));
	}
}
//在用户类型选择时候用户点击其他按钮后面的输入框 选中其他按钮
function checkedOhter(userRadioid){
	$("#"+userRadioid).click();
}
//在用户类型选择时候用户在其他按钮后面输入框输入信息 赋值给其他按钮对应的radio
function exchangeUserTypeVal(userRadioid,obj){
	$("#"+userRadioid).val($(obj).val());
}

//最下面两个checkbox都选中才能提交注册
function testIsSubmit(){
	var  ch_1=$("#is_qr").prop('checked');
	var  ch_2=$("#is_ty").prop('checked');
	if(ch_1&&ch_2){
		$("#input_bc").css('background-color','#3BB4F2');
		$("#input_bc").css('cursor','pointer');
		$('#input_bc').bind('click', subCheck);//为div绑定 函数
	}else{
		$("#input_bc").css('background-color','#CDCDCD');
		$("#input_bc").css('cursor','auto');
		$('#input_bc').unbind('click', subCheck);//取消 函数
	}
}

function subCheck(){  
	if(checkFormAll()){
		var msg = "以下为你的注册信息，请再次核对，提交后您将不能更改信息<br/>"
			+"<br/>登录账户："+$("input[name='userInfo.userName']").val()
			+"<br/>真实姓名："+$("input[name='userInfo.userNameRealy']").val()
			+"<br/>用户邮箱："+$("input[name='userInfo.userEmail']").val()
			+"<br/>电话号码："+$("input[name='userInfo.userPhone']").val()
			+"<br/>用户类型："+$("input[name='userInfo.userType']:checked").val()
			+"<br/>账户性质："+$("input[name='userInfo.userNatureAccount']:checked").val()
			+"<br/>使用期限："+$("#useDataTimeBegin").val()+" 至 "+$("#useDataTimeEnd").val()
			+"<br/>任务来源："+$("input[name='userInfo.userTaskSource']").val()
			+"<br/>工作内容："+$("input[name='userInfo.userWorkDesc']").val();
		if($("input[name='userInfo.userCountry']:checked").val()==1){//国内
			msg+="<br/>用户所属国家性质：国内用户";
			msg+="<br/>身份证号码："+$("input[name='userInfo.userIdCard']").val();
			msg+="<br/>工作证号码："+$("input[name='userInfo.workingCard']").val();
		}else if($("input[name='userInfo.userCountry']:checked").val()==2){//国外
			msg+="<br/>用户所属国家性质：国外用户";
			msg+="<br/>国内合作单位："+$("input[name='userInfo.cooperative']").val();
			msg+="<br/>国内合作专家姓名："+$("input[name='userInfo.expertName']").val();
			msg+="<br/>国内合作项目名称："+$("input[name='userInfo.projectName']").val();
			msg+="<br/>国内合作项目编号："+$("input[name='userInfo.projectNumber']").val();
			msg+="<br/>国内合作项目简介："+$("input[name='userInfo.projectDesc']").val();
			msg+="<br/>国内合作项目资助方："+$("input[name='userInfo.cooperativePartner']").val();
		}
		zdconfirm("温馨提示", msg, submitform());  
	}
}












(function($) {
    
    $.alerts = {       
        alert: function(title, message, callback) {
            if( title == null ) title = 'Alert';
            $.alerts._show(title, message, null, 'alert', function(result) {
                if( callback ) callback(result);
            });
        },
         
        confirm: function(title, message, callback) {
            if( title == null ) title = 'Confirm';
            $.alerts._show(title, message, null, 'confirm', function(result) {
                if( callback ) callback(result);
            });
        },
             
        
        _show: function(title, msg, value, type, callback) {
          
                    var _html = "";
 
                    _html += '<div id="mb_box"></div><div id="mb_con"><span id="mb_tit">' + title + '</span>';
                    _html += '<div id="mb_msg">' + msg + '</div><div id="mb_btnbox">';
                      if (type == "alert") {
                      _html += '<input id="mb_btn_ok" type="button" value="确定" />';
                    }
                    if (type == "confirm") {
                      _html += '<input id="mb_btn_ok" type="button" value="继续提交" />';
                      _html += '<input id="mb_btn_no" type="button" value="返回修改" />';
                    }
                    _html += '</div></div>';
                 
                    //必须先将_html添加到body，再设置Css样式
                    $("body").append(_html); GenerateCss();
         
            switch( type ) {
                case 'alert':
        
                    $("#mb_btn_ok").click( function() {
                        $.alerts._hide();
                        callback(true);
                    });
                    $("#mb_btn_ok").focus().keypress( function(e) {
                        if( e.keyCode == 13 || e.keyCode == 27 ) $("#mb_btn_ok").trigger('click');
                    });
                break;
                case 'confirm':
                   
                    $("#mb_btn_ok").click( function() {
                        $.alerts._hide();
                        if( callback ) callback(true);
                    });
                    $("#mb_btn_no").click( function() {
                        $.alerts._hide();
                        if( callback ) callback(false);
                    });
                    $("#mb_btn_no").focus();
                    $("#mb_btn_ok, #mb_btn_no").keypress( function(e) {
                        if( e.keyCode == 13 ) $("#mb_btn_ok").trigger('click');
                        if( e.keyCode == 27 ) $("#mb_btn_no").trigger('click');
                    });
                break;
              
               
            }
        },
        _hide: function() {
             $("#mb_box,#mb_con").remove();
        }
    }
    // Shortuct functions
    zdalert = function(title, message, callback) {
        $.alerts.alert(title, message, callback);
    }
     
    zdconfirm = function(title, message, callback) {
        $.alerts.confirm(title, message, callback);
    };
         
 
    
    
      //生成Css
  var GenerateCss = function () {
 
    $("#mb_box").css({ width: '100%', height: '100%', zIndex: '99999', position: 'fixed',
      filter: 'Alpha(opacity=60)', backgroundColor: 'black', top: '0', left: '0', opacity: '0.6'
    });
 
    $("#mb_con").css({ zIndex: '999999', width: '30%', position: 'fixed',
      backgroundColor: 'White', borderRadius: '5px'
    });
    $("#mb_tit").css({ display: 'block', fontSize: '14px', color: '#317eac', padding: '10px 15px',
      backgroundColor: '#ffffff', borderRadius: '5px 5px 0 0',
      borderBottom: '1px solid #E5E5E5', fontWeight: 'bold'
    });
 
    $("#mb_msg").css({ padding: '20px', lineHeight: '20px',
      borderBottom: '1px solid #DDD', fontSize: '13px'
    });
 
    $("#mb_ico").css({ display: 'block', position: 'absolute', right: '10px', top: '9px',
      border: '1px solid Gray', width: '18px', height: '18px', textAlign: 'center',
      lineHeight: '16px', cursor: 'pointer', borderRadius: '4px', fontFamily: '微软雅黑'
    });
 
    $("#mb_btnbox").css({ margin: '15px 0 10px 0', textAlign: 'center' });
    $("#mb_btn_ok,#mb_btn_no").css({ width: '85px', height: '30px', color: 'white', border: 'none' });
    $("#mb_btn_ok").css({ backgroundColor: '#168bbb' });
    $("#mb_btn_no").css({ backgroundColor: 'gray', marginLeft: '20px' });
 
 
    //右上角关闭按钮hover样式
    $("#mb_ico").hover(function () {
      $(this).css({ backgroundColor: 'Red', color: 'White' });
    }, function () {
      $(this).css({ backgroundColor: '#DDD', color: 'black' });
    });
 
    var _widht = document.documentElement.clientWidth; //屏幕宽
    var _height = document.documentElement.clientHeight; //屏幕高
 
    var boxWidth = $("#mb_con").width();
    var boxHeight = $("#mb_con").height();
 
    //让提示框居中
    $("#mb_con").css({ top: (_height - boxHeight) / 2 + "px", left: (_widht - boxWidth) / 2 + "px" });
  }
 

})(jQuery);