<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>秒杀详情页</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- include jsp的静态包含 和jsp的动态包含的区别是 静态包含是将两个合并成一个servlet输出 动态包含是输出两个servlet  然后把结果做合并 -->
	<%@include file="/common/head.jsp" %>
	
</head>
<body>
	 <div class="container">
			<div class="panel  panel-default text-center ">
				<div class="panel-heading">
						<h1>${seckill.name}</h1>
				</div>
				<div class="panel-body" style="background-color: yellow;">
				
					<h2 class="text-danger">
							<!-- 显示时间 -->
							<span class="glyphicon glyphicon-time "></span>
							<!-- 展示倒计时 -->
							<span class="glyphicon " id="seckill-box"></span>
					</h2>
			</div>
			</div>
			
	</div>
	
	
	
 <div  id="killPhoneModal" class="modal fade">
        <div class="modal-dialog">
	        <div class="modal-content">
		        <div class="modal-header">
		            <h4 class="modal-title text-center" >
		              		<span class="glyphicon glyphicon-phone"></span>秒杀电话:
		            </h4>
		         </div>
		         <div class="modal-body" >
		         	<div class="row">
		         		<div class="col-xs-8 col-xs-offset-2">
		         					<input type="text" name="killPhone" id="killPhone" placeholder="请填写手机号" class="form-control">
		         		</div>
		         	</div>
		         </div>
		         <div class="modal-footer">
		         		<!-- 验证信息 -->
		         		<span id="killPhoneMessage" class="glyphicon"></span>
		         		<button type="button" id="killPhoneBtn" class="btn btn-success">
		         			<span class="glyphicon glyphicon-phone"></span>
		         			Submit
		         		</button>
		         </div>
	        </div>
        </div>
   </div>
	
	
	
					
	
</body>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script src="http://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<script src="http://cdn.bootcss.com/jquery.countdown/2.2.0/jquery.countdown.min.js"></script>

<script src="${ctx}/resource/script/seckill.js" type="text/javascript"></script>
 
<script type="text/javascript">
var ctx='${ctx}';

$(function(){
	/* 使用EL表达式传入参数 */
	seckill.detail.init({
		seckillId : 		${seckill.seckillId},
		startTime :	 	${seckill.startTime.time},
		endTime : 		${seckill.endTime.time},
		createTime : 	${seckill.createTime.time}
	});
});

	
	</script>

</html>