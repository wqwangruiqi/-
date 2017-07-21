<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/tag.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"></meta>
<link href="${ctx}/resource/lasw/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/resource/lasw/css/neiye.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/resource/lasw/css/index.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	
</script>
</head>
<body >
	 <div class="monilistboxright" style="margin-top: -8px;text-align: left;" >
       <div class="mhttit">
        <span>${laswMenu.nameChina}</span>
        <i style="font-size: 12px;"><a href="${ctx}/">首页</a> &gt; <a href="${ctx}/">${laswMenu.parent.nameChina}</a> &gt;${laswMenu.nameChina}</i>
       </div> 
       <div class="mhttittextbox">
			 <c:forEach var="title" items="${titleList}">
				 ${title.id}-- ----- ${title.titleName} -- -----${title.clickNumber}   --<fmt:formatDate value="${title.insertTime}" pattern="yyyy-MM-dd HH:mm:ss"/>    
			 -- <fmt:formatDate value="${title.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>   <br>
			</c:forEach>
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














