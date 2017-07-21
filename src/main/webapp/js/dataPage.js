


/*  数据列表分页查询相关操作 begin  */

//分页查询
function jumpPage(formId,pageNo){
	var action = $("#formList").attr("action") + "?pageNo=" + pageNo;
	$("#formList").attr("action",action);
	findData();
}
//查询提交
function findData(){
	var key="TIPEXIII_DATA_FIND_"+$("input[name='dataTypeNew.id']").val();
	if(parent.parent.map[key]==1){
		if(parent.parent.returnUserName()==null ||parent.parent.returnUserName()=="") {
			alert("该功能需要用户具有操作权限，请您登陆!");
			return;
		}else if(parent.parent.map_U[key]!=1){
			alert("用户无权限操作，请联系管理员");					
			return;
		}
	}
	 $("#formList").submit();
}
//页面跳转
function gotupage(maxpage){
	var pageNo=$("#gotoPageNumber").val();
	if(pageNo>maxpage){
		alert("超出最大页数!	");
		return ;
	}else if(pageNo>=1 && pageNo<=maxpage){
		jumpPage("",pageNo);
	}else {
		alert("输入页数格式错误!");
		return ;
	}
}
/*  数据列表分页查询相关操作 end  */



/*  数据列表文件选择checkbox选中与否事件  begin  */
//页面初始化的时候 选中页面的checkbox
function checkboxOnHtmloOnload(){
	var checkbox_download=$("input[name='datafileid']");
	var downFileIds=$('#downFileIds').val();
	if(downFileIds.length<1){
		$("input[name = datafileid]").prop("checked",false);
		return;
	}
	for(var i=0;i<checkbox_download.length;i++){
		if((downFileIds).indexOf(","+$(checkbox_download[i]).val()+",")>=0){//如果字符串里面有这个id  选中该checkbox
			 $(checkbox_download[i]).prop("checked",true);
		}
	}
	var notChecked = $("input[name=datafileid]").not("input:checked").length ;//获取未被选择的checkbox
	if(notChecked>0){
		if($("#checkOrNO").is(":checked")) {
			$("#checkOrNO").prop("checked",false);
		}
	}else{
		if(!$("#checkOrNO").is(":checked")) {
			$("#checkOrNO").prop("checked",true);
		}
	}
}

//全选 全部选
function  checkOrNO(){ 
	var allCheckBox=$("input[name = datafileid]");
	var allCheckBoxIds="";
	for(var i=0;i<allCheckBox.length;i++){
		if(i==0){
			allCheckBoxIds+=$(allCheckBox[i]).val();
		}else{
			allCheckBoxIds+=","+$(allCheckBox[i]).val();
		}
		
	}
	if($("#checkOrNO").is(':checked')){//全选
		$("input[name = datafileid]").prop("checked",true);
		//将页面的所有checkbox的id添加到 downFileIds
		addIdToDownFileIds(allCheckBoxIds,1);
	}else{//全不选
		$("input[name = datafileid]").prop("checked",false);
		////将页面的所有checkbox的id从 downFileIds里面删除
		addIdToDownFileIds(allCheckBoxIds,0);
	}
}

//点击 数据列表单个数据触发事件
function checkbox_checkOrNo(obj){
	var notChecked = $("input[name=datafileid]").not("input:checked").length ;//获取未被选择的checkbox
	if(notChecked>0){
		if($("#checkOrNO").is(":checked")) {
			$("#checkOrNO").prop("checked",false);
		} 
	}else{
		if(!$("#checkOrNO").is(":checked")) {
			$("#checkOrNO").prop("checked",true);
		}
	}
	//判断该对象是选中还是未选中
	if($(obj).is(':checked')){//选中该数据
		//将该数据添加到downFileIds尾部
		addIdToDownFileIds($(obj).val(),1);
	}else{//取消选中该数据
		//将该数据从downFileIds里面删除
		addIdToDownFileIds($(obj).val(),0);
	}
}

//将字符串添加或删除到downFileIds里面 0表示删除,1表示添加
function addIdToDownFileIds(ids,aOrd){
	var downFileIds=$('#downFileIds').val();
	var allIds=ids.split(",");
	if(aOrd==0){//删除id
		for(var i=0;i<allIds.length;i++){
			if(downFileIds.indexOf(","+allIds[i]+",")>=0){//如果字符串里面有这个id  则删除该id
				downFileIds=downFileIds.replace(new RegExp(","+allIds[i]+","), "");
			}
		}
	}else{//添加id
		for(var i=0;i<allIds.length;i++){
			if(downFileIds.indexOf(","+allIds[i]+",")<0){//如果字符串里面没有这个id  则添加该id到downFileIds
				downFileIds+=","+allIds[i]+",";
			}
		}
	}
	$('#downFileIds').val(downFileIds);
}

/*  数据列表文件选择checkbox选中与否事件  end  */







/*  页面数据下载触发事件 begin */
//点击下载按钮
function downloadFile(dataTypeId) {
	
	var key="TIPEXIII_DATA_DOWNLOAD_"+dataTypeId;
	if(parent.parent.map[key]==1){
		if(parent.parent.returnUserName()==null ||parent.parent.returnUserName()=="") {
			alert("该功能需要用户具有操作权限，请您登陆!");
			return;
		}else if(parent.parent.map_U[key]!=1){
			alert("用户无权限操作，请联系管理员");					
			return;
		}
	}
	
	var downFileIds=$('#downFileIds').val();
	downFileIds=downFileIds.replace(new RegExp(',+',"gm"),',');
	downFileIds=downFileIds.substring(1,downFileIds.length-1)
	if (downFileIds.length == 0) {
		 $.messager.alert("温馨提示", "你还没有选择下载的文件!");
	}else {
		
		if(confirm("您此次下载选择了"+downFileIds.split(",").length+"个文件,点击确定开始下载文件")){
			$.ajax({
				url :ctx_downLoadFile_js+"/management/data/retrieval/down-load-file!downLoadFile.action?dataTypeNew.id="+dataTypeId+"&downFileIds="+downFileIds,
				type : 'post',
				dataType: 'json',
				success : function(json) { 
					 if(json.returnString=="downLoadFile_OK"){
						 //downLoadFileThredGo(dataTypeId,json.dataDownLoadTaskId);
						 alert("后台数据正在处理,数据处理成功会将文件下载链接发送到您的邮箱,请注意查收!!");
						 $('#downFileIds').val("");
						 $("input[name = datafileid]").prop("checked",false);
						 $("#checkOrNO").prop("checked",false);
					 }else if(json.returnString=="downLoadFile_ERROR"){
						 alert("后台数据打包异常!");
					 }else if(json.returnString=="403"){
						 if("${webServiceCamsuserInfo}"==null ||"${webServiceCamsuserInfo}"=="") {
								alert("该功能需要用户具有操作权限，请您登陆!");
							}else{
								alert("用户无权限操作，请联系管理员");					
							}
					 }
				}
			});
		}
		 
	}
}

function downLoadFileThredGo(dataTypeId,taskId){
	$.ajax({
		url :ctx_downLoadFile_js+"/management/data/retrieval/down-load-file!downLoadFileThred.action?dataTypeNew.id="+dataTypeId+"&dataDownLoadTaskId="+taskId,
		type : 'post',
		dataType: 'json',
		success : function(json) { 
		}
	}); 
}



/*  页面数据下载触发事件 end */


/*
 * 页面点击返回按钮触发事件
 */
function goBack(url){
	window.location.href=url;
}




window.onload = function() {
	checkIframeHeightFirst();
};   

/* 用户设置页面的iframe高度 begin*/
var shuaxingzhixin_id;//定时器返回的id
var shuaxingjiange=500;//间隔时间
var shuaxingcishu=0;//当前执行了多少次定时方法
var shuaxingcishumax=10;//最多执行多少次定时方法
function checkIframeHeightFirst(){
	shuaxingzhixin_id = setInterval(checkIframeHeight, shuaxingjiange);
}
//设置页面的iframe高度
function checkIframeHeight(){
	 shuaxingcishu++;
	 if(shuaxingcishu>shuaxingcishumax){
		 window.clearInterval(shuaxingzhixin_id);
	 }
	var ddfdsfdsfds=$('#alldataDiv').height();
	if(ddfdsfdsfds<200){
		$('#alldataDiv').height(ddfdsfdsfds);
		ddfdsfdsfds=200;
	}
	parent.checkHeight(ddfdsfdsfds+200);
} 
/* 用户设置页面的iframe高度 end*/
