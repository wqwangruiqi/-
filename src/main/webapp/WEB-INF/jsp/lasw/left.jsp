<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/tag.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"></meta>

<script type="text/javascript">
</script>

<style type="text/css">
	.left_menu_div_1{
		width: 200px;
		height: 39px;
		line-height: 39px;
		float: left;
		background-image: url(${ctx}/resource/lasw/images/neiyepic01.jpg);
	}
	.left_menu_div_1 span{
		float: left; 
		line-height: 39px; 
		padding-left: 39px;
		font-size: 14px;
		font-weight: bold; 
		color: #FFF;
	}
</style>

</head>
<body>

	 <div class="monilistboxleft" style="margin-left: 6px;text-align: left;">
       <div class="mlefttit">
        <span id="left_menu_span_1"></span>
       </div> 
       <div class="newtushu" >
        <ul id="left_menu_ul_1"> 
         
        </ul>
       </div> 
       <div class="newtushubottombg"></div> 
      </div>
</body>

<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="${ctx}/resource/script/lasw.js" type="text/javascript"></script>
<script type="text/javascript">
var ctx='${ctx}';		
$(function(){
	var topMenuId=null;
	var leftMenuId=null;
	var titleId=null;
	if('${topMenuId}'==null || '${topMenuId}'==''){
		topMenuId=10000;
	}else{
		topMenuId='${topMenuId}';
	}
	if('${leftMenuId}'==null || '${leftMenuId}'==''){
		leftMenuId=0;
	}else{
		leftMenuId='${leftMenuId}';
	}
	
	if('${titleId}'==null || '${titleId}'==''){
		titleId=0;
	}else{
		titleId='${titleId}';
	}
	lasw.left.menu(topMenuId,leftMenuId,titleId);
});
</script>
</html>




