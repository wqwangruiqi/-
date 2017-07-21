<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/tag.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"></meta>
<title>灾害天气国家重点实验室</title>
<style type="text/css">
	body{
		margin:0;
		padding:0;
		font:12px/21px "宋体";
		color:#333; 
		background:url('${ctx}/resource/lasw/images/minbgs.jpg') no-repeat center top; 
		background-color:#2765ba;
	}
</style>
<script type="text/javascript"> 
</script>
</head>
		<body >
		
			<table style="width: 1000px;height: auto;border: 0px solid red;margin:0 auto;border-color: white;border-collapse: separate;border-spacing:0px; "align="center">
				<tr style="">
					<td colspan="2"> 
							<div style="width: 100%;height: 240px;border: 0px solid red;" >
					 			<%@include file="top.jsp"%>
							</div> 
					</td>
				</tr>
				<tr>
					<td colspan="2"> 
							 <div  style="width: 1000px;background-color: white;margin:0 auto"align="center">
								<img src="${ctx}/resource/lasw/images/neiyebanner01.jpg" style="height: 180px;width: 988px;margin: 6px;">
							</div>
					</td>
				</tr>
				
				<tr style="background-color: white;">
					<td  > 
							 <%@include file="left.jsp"%> 
					</td>
					<td style="vertical-align:top;" > 
							 <%@include file="right.jsp"%> 
					</td>
				</tr>
				
				<tr>
					<td colspan="2" style="background-color: white;text-align: center;"> 
							 <div style="width: 988px;height: 100px;margin:0 auto;">
								 <%@include file="foot.jsp"%>
							</div> 
					</td>
				</tr>
				
			</table>
		 
		</body>
</html>
