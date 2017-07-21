var path="/lasw_cms";
/**
 * 用户登录
 */
function fuserlogin(){
	var username=$("#username").val();
	var password=$("#password").val();
	var imgcode=$("#imgcode").val();
	var remember="0";
	//判断是否选中保存登录名
	var rem=$("[name='remembername']");
	for ( var i = 0; i < rem.length; i++) {
		if(rem[i].checked==true){
			remember="1";
		}
	}
	//判断是否为空
	if(username=="" || username==null){
		alert("请输入用户名","lash('username');");
		/*_("flag").value=1;*/
		return;
	}
	if(password=="" || password==null){
		alert("请输入密码","lash('password');");
		/*_("flag").value=1;8*/
		return;
	}
	/*if(imgcode=="" || imgcode==null){
		alert("请输入验证码","lash('imgcode');");
		_("flag").value=1;
		return;
	}*/
	
	$.ajax({
		type:"post",
		url:path+"/login/userLogin.do",
		data:{
			"username":username,
			"password":password,
			"verify":"frontLogin",
			"remember":remember
		},
		dataType:"json",
		success:function(data){
			if(data.result.resultname=="1"){
				window.location.href=path+"/cec_wcp/main.jsp";
			}else{
				alert(data.result.resultname,"nextImage()");
				/*_("flag").value=1;*/
				return;
			}
			
		}
	});
}


/**
 * 看不清，换一张
 */
function nextImage(){
	if($("#yzm")){
		$("#yzm").attr("src",path+"/AutoCode.do?temp="+new Date().getTime().toString(36));
		lash('imgcode');
	}

}


/**
 * 回车登录
 */
/*function enter(event){
	var flag=(_("flag").value)/1;
	if(event.keyCode=='13' && flag!=1){
		 userlogin();
	}
}

function lash(id){
	$('#'+id).focus();
	_("flag").value=0;
}*/


