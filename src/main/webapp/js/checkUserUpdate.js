 
 
 
//输入用户姓名失去焦点事件(检查输入用户信息) 
function checkUserName(obj){
	flagUserName=false;
	if($(obj).val()==null || $(obj).val()=='' || $(obj).val().length<2 || $(obj).val().length>20){
		$("#userInfoUserName_ERROR").html("输入用户姓名格式错误!");
	}else if($(obj).val()==userInfoUserName){
		$("#userInfoUserName_ERROR").html("");
		flagUserName=true;
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
					$("#userInfoUserName_ERROR").html("用户姓名已经存在!");
				 }else if(json.ISUSED=="Name_OK"){
					 $("#userInfoUserName_ERROR").html("");
					flagUserName=true;
				 }else if(json.ISUSED=="ERROR"){
					$("#userInfoUserName_ERROR").html("查询数据错误请稍后再试!");
				 }
			}
		});
	}
}




//输入用户真实姓名失去焦点事件(检查输入用户真实姓名信息)
function checkUserRealName(obj){
	flagUserRealName=false;
	if($(obj).val()==null || $(obj).val()=='' || $(obj).val().length<2 || $(obj).val().length>20){
		$("#userInfoUserNameRealy_ERROR").html("用户真实姓名长度为2--20位!");
	}else{
		$("#userInfoUserNameRealy_ERROR").html("");
		flagUserRealName=true;
	}
}


//输入用户邮箱失去焦点事件(检查输入用户邮箱信息) 
function checkUserEmail(obj){
	flagUserEmail=false;
	if($(obj).val()==null || $(obj).val()==''){
		$("#userInfoUserEmail_ERROR").html("用户邮箱不能为空!");
	}else if(!$(obj).val().match(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/)){
		$("#userInfoUserEmail_ERROR").html("用户邮箱格式不正确!");
	}else if($(obj).val()==userInfoUserEmail){
		$("#userInfoUserEmail_ERROR").html('');
		flagUserEmail=true;
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
					$("#userInfoUserEmail_ERROR").html("用户邮箱已经存在!");
				 }else if(json.ISUSED=="Email_OK"){
					$("#userInfoUserEmail_ERROR").html('');
					flagUserEmail=true;
				 }else if(json.ISUSED=="ERROR"){
					$("#userInfoUserEmail_ERROR").html("查询数据错误请稍后再试!");
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
		  if($(obj).val()==userInfoUserPhone){
			  $("#userInfoUserPhone_ERROR").html("");
				flagUserPhone=true;
		  }else{
			  $.ajax({
					type: "POST",
					url: ctx+"/management/camsuser/cams-user-register!checkUserPhone.action",
					data: {
						"userInfo.userPhone": $(obj).val()
					},
					dataType: "json",
					success: function(json){
						 if(json.ISUSED=="Phone_OK"){
							 $("#userInfoUserPhone_ERROR").html("");
								flagUserPhone=true;
						}else{
							if(json.ISUSED=="Phone_NOT"){
								$("#userInfoUserPhone_ERROR").html("电话号码已经存在!");
							}else if(json.ISUSED=="ERROR"){
								$("#userInfoUserPhone_ERROR").html("查询数据错误请稍后再试!");
							}
							$("#userPhone_error").show();
						}
					}
				});
		  }
	  }else {
			$("#userInfoUserPhone_ERROR").html("电话号码格式输入错误!");
	  }
}




//在用户类型选择时候用户在其他按钮后面输入框输入信息 赋值给其他按钮对应的radio
function exchangeUserTypeVal(userRadioid,obj){
	$("#"+userRadioid).val($(obj).val());
}




function checkTimeBegin(){
	if(($("#useDataTimeBegin").val()==null||$("#useDataTimeBegin").val()=='')){
		$("#useDataTimeBegin_ERROR").html("开始使用时间不能为空");
		flagUserTime=false;
	}
	var stringBegin=$("#useDataTimeBegin").val().replace(/(^\s+|\s+$)/g,'').split("-");
	var dateBegin=new Date(parseInt(stringBegin[0]),parseInt(stringBegin[1]),parseInt(stringBegin[2]));
	var longdateBegin=dateBegin.getTime();
	var stringEnd=$("#useDataTimeEnd").val().replace(/(^\s+|\s+$)/g,'').split("-");
	var dateEnd=new Date(parseInt(stringEnd[0]),parseInt(stringEnd[1]),parseInt(stringEnd[2]));
	var longdateEnd=dateEnd.getTime();
	if(longdateBegin>=longdateEnd){
		$("#useDataTimeBegin_ERROR").html("开始使用时间大于等于结束使用时间");
		flagUserTime=false;
	}else{
		$("#useDataTimeBegin_ERROR").html("");
		$("#useDataTimeEnd_ERROR").html("");
		flagUserTime=true;
	}
	
}

function checkTimeEnd(){
	flagUserTime=false;
	if($("#useDataTimeEnd").val()==null||$("#useDataTimeEnd").val()==''){
		$("#useDataTimeEnd_ERROR").html("结束使用时间不能为空");
		flagUserTime=false;
	}
	var stringBegin=$("#useDataTimeBegin").val().replace(/(^\s+|\s+$)/g,'').split("-");
	var dateBegin=new Date(parseInt(stringBegin[0]),parseInt(stringBegin[1]),parseInt(stringBegin[2]));
	var longdateBegin=dateBegin.getTime();
	var stringEnd=$("#useDataTimeEnd").val().replace(/(^\s+|\s+$)/g,'').split("-");
	var dateEnd=new Date(parseInt(stringEnd[0]),parseInt(stringEnd[1]),parseInt(stringEnd[2]));
	var longdateEnd=dateEnd.getTime();
	if(longdateBegin>=longdateEnd){
		$("#useDataTimeEnd_ERROR").html("结束使用时间小于等于开始使用时间");
		flagUserTime=false;
	}else{
		$("#useDataTimeEnd_ERROR").html("");
		$("#useDataTimeBegin_ERROR").html("");
		flagUserTime=true;
	}
}

 
 
//检测用户输入的课题名称 任务来源
function checkUserTaskSource(obj){
	flagUserTaskSource=false;
	if($(obj).val()==null || $(obj).val()=='' || $(obj).val().length<1 || $(obj).val().length>500){
		$("#userInfoUserTaskSource_ERROR").html("输入任务来源(课题名称)长度错误!");
	}else{
		$("#userInfoUserTaskSource_ERROR").html("");
		flagUserTaskSource=true;
	}
}

//检测用户输入的工作内容
function checkUserWorkDesc(obj){
	flagUserWorkDesc=false;
	if($(obj).val()==null || $(obj).val()=='' || $(obj).val().length<1 || $(obj).val().length>500){
		$("#userInfoUserWorkDesc_ERROR").html("输入任务来源(课题名称)长度错误!");
	}else{
		$("#userInfoUserWorkDesc_ERROR").html("");
		flagUserWorkDesc=true;
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
		$("#userInfoUserIdCard_ERROR").html("");
		flagUserIdCard=true;
	}else{
		$("#userInfoUserIdCard_ERROR").html("输入身份证格式验证未通过请重新输入!");
	}
}

//输入工作证编号失去焦点事件(检查输入工作证编号信息)
function checkUserWorkingCard(obj){
	flagUserWorkingCard=false;
	if($(obj).val()==null || $(obj).val()=='' || $(obj).val().length<2 || $(obj).val().length>50){
		$("#userInfoWorkingCard_ERROR").html("输入工作证编号长度错误!");
	}else{
		$("#userInfoWorkingCard_ERROR").html("");
		flagUserWorkingCard=true;
	}
}






//输入合作专家失去焦点事件(检查输入专家姓名信息)
function checkExpertName(obj){
	flagExpertName=false;
	if($(obj).val()==null || $(obj).val()=='' || $(obj).val().length<2 || $(obj).val().length>20){
		$("#userInfoExpertName_ERROR").html("输入合作专家姓名长度错误!");
	}else{
		$("#userInfoExpertName_ERROR").html("");
		flagExpertName=true;
	}
}


//输入合作单位失去焦点事件(检查输入合作单位信息)
function checkCooperative(obj){
	flagCooperative=false;
	if($(obj).val()==null || $(obj).val()=='' || $(obj).val().length<2 || $(obj).val().length>50){
		$("#userInfoCooperative_ERROR").html("输入合作单位长度错误!");
	}else{
		$("#userInfoCooperative_ERROR").html("");
		flagCooperative=true;
	}
}




//输入合作合作项目名字失去焦点事件(检查输入合作项目名字信息)
function checkProjectName(obj){
	flagProjectName=false;
	if($(obj).val()==null || $(obj).val()=='' || $(obj).val().length<2 || $(obj).val().length>50){
		$("#userInfoProjectName_ERROR").html("输入合作项目名长度错误!");
	}else{
		$("#userInfoProjectName_ERROR").html("");
		flagProjectName=true;
	}
}

//输入合作项目编号失去焦点事件(检查输入合作项目编号信息)
function checkProjectNumber(obj){
	flagProjectNumber=false;
	if($(obj).val()==null || $(obj).val()=='' || $(obj).val().length<2 || $(obj).val().length>50){
		$("#userInfoProjectNumber_ERROR").html("输入合作项目编号长度错误!");
	}else{
		$("#userInfoProjectNumber_ERROR").html("");
		flagProjectNumber=true;
	}
}


//输入合作合作项简介失去焦点事件(检查输入合作项目简介信息)
function checkProjectDesc(obj){
	flagProjectDesc=false;
	if($(obj).val()==null || $(obj).val()=='' || $(obj).val().length<2 || $(obj).val().length>500){
		$("#userInfoProjectDesc_ERROR").html("输入合作项目简介信息长度错误!");
	}else{
		$("#userInfoProjectDesc_ERROR").html("");
		flagProjectDesc=true;
	}
}


//输入合作项目资助单位失去焦点事件(检查输入合作项目资助单位信息)
function checkCooperativePartner(obj){
	flagCooperativePartner=false;
	if($(obj).val()==null || $(obj).val()=='' || $(obj).val().length<2 || $(obj).val().length>50){
		$("#userInfoCooperativePartner_ERROR").html("输入合作项目资助单位长度错误!");
	}else{
		$("#userInfoCooperativePartner_ERROR").html("");
		flagCooperativePartner=true;
	}
}





 



var flagUserName=false;
var flagUserRealName=false;
var flagUserEmail=false;
var flagUserPhone=false;
var flagUserTime=false;
var flagUserTaskSource=false;
var flagUserWorkDesc=false;

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
		checkUserName($("#userInfoUserName"));
		if(flagUserName==false)return false;
	}
	if(flagUserRealName==false){
		checkUserRealName($("#userInfoUserNameRealy"))
		if(flagUserRealName==false)return false;
	}
	if(flagUserEmail==false){
		checkUserEmail($("#userInfoUserEmail"))
		if(flagUserEmail==false)return false;
	}
	if(flagUserPhone==false){
		checkUserPhone($("#userInfoUserPhone"))
		if(flagUserPhone==false)return false;
	}
	  
	
	if(flagUserTime==false){
		checkTimeBegin();
		checkTimeEnd();
		if(flagUserTime==false)return false;
	}
	 
	if(flagUserTaskSource==false){
		checkUserTaskSource($("#userInfoUserTaskSource"))
		if(flagUserTaskSource==false)return false;
	}
	if(flagUserWorkDesc==false){
		checkUserWorkDesc($("#userInfoUserWorkDesc"))
		if(flagUserWorkDesc==false)return false;
	}
	
	
	
	if(userCountry==1){//国内
		if(flagUserIdCard==false){
			checkUserIdCard($("#userInfoUserIdCard"))
			if(flagUserIdCard==false)return false;
		}
		if(flagUserWorkingCard==false){
			checkUserWorkingCard($("#userInfoWorkingCard"))
			if(flagUserWorkingCard==false)return false;
		}
	}else if(userCountry==2){//国外
		if(flagExpertName==false){
			checkExpertName($("#userInfoExpertName"))
			if(flagExpertName==false)return false;
		}
		if(flagCooperative==false){
			checkCooperative($("#userInfoCooperative"))
			if(flagCooperative==false)return false;
		}
		if(flagProjectName==false){
			checkProjectName($("#userInfoProjectName"))
			if(flagProjectName==false)return false;
		}	
		if(flagProjectNumber==false){
			checkProjectNumber($("#userInfoProjectNumber"))
			if(flagProjectNumber==false)return false;
		}
		if(flagProjectDesc==false){
			checkProjectDesc($("#userInfoProjectDesc"))
			if(flagProjectDesc==false)return false;
		}
		if(flagCooperativePartner==false){
			checkCooperativePartner($("#userInfoCooperativePartner"))
			if(flagCooperativePartner==false)return false;
		}
	}
	return true;
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
  

//修改提交
function updateUserInfo(){
	if(checkFormAll()){
		//开始修改用户信息
		alertShowWait();
		$.ajax({
			url : ctx+"/management/camsuser/cams-user-info!update.action",
			type : 'post',
			data : $("#userInfoUpdate").serialize(),
			success : function(json) {
				alertCloseWait();
				if(json.SUCCESS==1){
					alertShow("用户信息修改成功!");
					window.location.href=ctx+"/management/camsuser/cams-user-info!userList.action";
				 }else{
					 $.messager.alert("温馨提示", "用户信息修改失败!");
				 }
			}
		});
	}else{
		alertShow("部分选项未通过验证")
	}
}

 