<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/tag.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"></meta>
<title>灾害天气国家重点实验室</title>
<link href="${ctx}/resource/lasw/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/resource/lasw/css/neiye.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/resource/lasw/css/index.css" rel="stylesheet" type="text/css" />
<style type="text/css">	
	.English{width:1000px;height:28px;color:#accbe9;line-height:28px; text-align:right;font-size: 12px}        
	.English a{color:#accbe9;margin-right:3px;}       
	.English a:hover{color:#fff;}  
	.menu_A{
		width: 114px;
	}
</style>
<script type="text/javascript"> 
</script>
</head>
<body>
	<div class="topnav">
		<div class="English">
			<a href="${ctx}/">简体中文</a>| <a
				href="${ctx}/">English</a>
		</div>
		<div class="topnavsbox" style="margin-top: 37px;">
			<a href="${ctx}/lasw/index">
				<img src="${ctx}/resource/lasw/images/logo.png" width="512" height="72" />
			</a>
		</div>
	</div>
	
	<div class="menu_box" style="margin-bottom: 0px">
		<div class="menu_boxs">
			<div class="menu_boxs_1">
				<a href="${ctx}/lasw/index">
					<img src="${ctx}/resource/lasw/images/menubg.jpg" width="87" height="48" />
				</a>
			</div>
			<div class="menu_boxs_2" id="menuFirst">
					<!-- 动态生成导航菜单 -->
			</div>
		</div>
		<div class="menu_boxsrig">
			 <input id="seachs" class="inp01" name="" type="text" onblur="if (value ==''){value='全站搜索'}" 
						onclick="if(this.value!=''){this.value='';setFlag('search');}" value="全站搜索" />
			 <input class="inp02" name="" type="button" onclick="seach();" /> 
			 <input id="searchOrLog" type="hidden" value="" />
		</div>
	</div>
	
	
</body>



<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="${ctx}/resource/script/lasw.js" type="text/javascript"></script>
<script type="text/javascript">
var ctx='${ctx}';		
$(function(){
	lasw.top.menu();
});
		
		
	</script>

</html>


