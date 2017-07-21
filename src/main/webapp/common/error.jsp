<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/tag.jsp"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"></meta>
<title>您访问的页面走丢了</title>
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript"> 
var imgPool=new Array('${ctx}/resource/images/lost1.JPG',
		'${ctx}/resource/images/lost2.JPG',
		'${ctx}/resource/images/lost3.JPG');
var imgTextPool=new Array(
		'你访问的页面走丢在大山中......',
		'你访问的页面跟着大风看世界去了......',
		'你访问的页面走丢在人群中......');
	
$(function(){
	var num = GetRandomNum(1,imgPool.length); 		
		$("#error_img").attr("src",imgPool[num-1]); 
		$("#error_context").html(imgTextPool[num-1]);
		
});

function GetRandomNum(Min,Max)
{   
var Range = Max - Min;   
var Rand = Math.random();   
return(Min + Math.round(Rand * Range));   
}   

	

</script>
<style type="text/css">
html{
}
body{
	margin: 0px;
}
</style>
</head>
<body>
	<div style="width: 100%;height: 100%;position:relative;">
			<div id="error_context" style="width: auto;height: 100px;border: 0px solid red;margin-left:40%;margin-top:15%;
			position:absolute;z-index: 99999;font-size: 30px;color: white;text-align: center;font-family: 楷体;" ></div>
    	   <img id="error_img"  alt="" src="" title="" style="width: 100%;height: 100%; position:fixed;background-repeat: no-repeat; " align="middle">  
	</div>

</body>
</html>
