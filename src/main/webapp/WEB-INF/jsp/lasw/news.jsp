<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/tag.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"></meta>
<link href="${ctx}/resource/lasw/css/neiye.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	
</script>
</head>
<body >
	 <div class="monilistboxright" style="margin-top: -8px;text-align: left;" >
       <div class="mhttit">
        <span>${laswNewsContent.laswNewsTitle.titleName}</span>
        <i style="font-size: 12px;">
        						<a href="${ctx}/lasw/index">首页</a> 
        				&gt; <a href="${ctx}/lasw/index">${laswNewsContent.laswNewsTitle.titleName}</a> 
        				&gt;${laswNewsContent.laswNewsTitle.titleName}
        </i>
       </div> 
       <div class="mhttittextbox">
       		${laswNewsContent. newsContent}
       
       </div>
      <div></div></div>
</body>

<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="${ctx}/resource/script/lasw.js" type="text/javascript"></script>
<script type="text/javascript">
var ctx='${ctx}';		
$(function () { 
	lasw.changeIframeHight();
});
</script>


</html>














