<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/tag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="robots" content="noindex,nofllow" />
<title>LASW后台管理</title>


<link href="${ctx}/back_stage/css/bootstrap-cerulean.min.css" rel="stylesheet" id="bs-css">
<link href="${ctx}/back_stage/css/charisma-app.css" rel="stylesheet">
<link href='${ctx}/back_stage/bower_components/fullcalendar/dist/fullcalendar.css' rel='stylesheet'>
<link href='${ctx}/back_stage/bower_components/fullcalendar/dist/fullcalendar.print.css' rel='stylesheet' media='print'>
<link href='${ctx}/back_stage/bower_components/chosen/chosen.min.css' rel='stylesheet'>
<link href='${ctx}/back_stage/bower_components/colorbox/example3/colorbox.css' rel='stylesheet'>
<link href='${ctx}/back_stage/bower_components/responsive-tables/responsive-tables.css' rel='stylesheet'>
<link href='${ctx}/back_stage/bower_components/bootstrap-tour/build/css/bootstrap-tour.min.css' rel='stylesheet'>
<link href='${ctx}/back_stage/css/jquery.noty.css' rel='stylesheet'>
<link href='${ctx}/back_stage/css/noty_theme_default.css' rel='stylesheet'>
<link href='${ctx}/back_stage/css/elfinder.min.css' rel='stylesheet'>
<link href='${ctx}/back_stage/css/elfinder.theme.css' rel='stylesheet'>
<link href='${ctx}/back_stage/css/jquery.iphone.toggle.css' rel='stylesheet'>
<link href='${ctx}/back_stage/css/uploadify.css' rel='stylesheet'>
<link href='${ctx}/back_stage/css/animate.min.css' rel='stylesheet'>
<link href="${ctx}/back_stage/bower_components/bootstrap/dist/css/bootstrap-select.css" rel="stylesheet">
<link href="${ctx}/css/font-awesome-4.6.3/css/font-awesome.min.css" rel="stylesheet"/>
<script language="javascript" type="text/jscript" src="${ctx }/js/jquery.form.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script src="${ctx}/back_stage/bower_components/bootstrap/dist/js/bootstrap-select.js"></script>


<script type="text/javascript" src="${ctx}/js/table.js"></script>
<script type="text/javascript" src="${ctx}/js/date/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
function editNews(newstitleid){
	window.location.replace("${ctx}/management/news/manage/news-manage!updatepage.action?newstitleid="+newstitleid);
}
function deleteNews(newstitleid){
	if(confirm("确定要删除这条新闻吗?")){
		$.ajax({
			type: "POST",
			url: "${ctx}/management/news/manage/news-manage!delete.action",
			data: {
				"newstitleid": newstitleid
			},
			dataType: "json",
			success: function(data){
				if(data.status=="true"){
					alert("新闻删除成功");
					search('listForm');
				}else{
					alert("新闻删除失败");
				}
			},
			error: function(XMLHttpRequest, textStatus, errorThrown) {
                if(XMLHttpRequest.status=='403'){
                	alert("用户无权限执行该操作！");
                }else{
                	alert("用户删除失败!");
                }
            }
		});
	}
}



function jumpPage(formId, pageNo) {
	$("#pageNum").val(pageNo);
	$("#" + formId).submit();
}
 

</script>

<style type="text/css">
 
</style>

</head>
<body>
	
<jsp:include page="head.jsp" />

<div class="ch-container">
	<div class="row">
		<jsp:include page="left.jsp" />
		<div id="content" class="col-lg-10 col-sm-10">
			<div>
				<ul class="breadcrumb" style="margin-bottom: 0px;">
					<li><a href="#">新闻列表管理</a>
					</li>
					<li><a href="#">新闻列表</a>
					</li>
					
					<li><a href="#">当前用户人数${userNumber}</a>
					</li>
					
				</ul>
			</div>
			
			
			<div class=" row">
				<div class="box col-md-12">
					<div class="box-inner">
					<div class="box-header well" data-original-title="">
						<h2>
							<i class="glyphicon glyphicon-user"></i> 新闻列表
						</h2>

						<div class="box-icon">
							<a href="#" class="btn btn-minimize btn-round btn-default"><i
								class="glyphicon glyphicon-chevron-up"></i>
							</a>
						</div>
					</div>
					<div class="box-content">
						<form action="${ctx}/management/news/list" method="get" id="listForm">
						
						<input type="hidden" value="${page.pageNum}" name="pageNum" id="pageNum"/>
						<input type="hidden" value="${page.pageSize}" name="pageSize"/>
							
						
							<!--  条件查询：start -->
							<div style="padding-left:0px;">
							
							
							
							
							
							
								<table class="tb-edit" border="1" bordercolor="#FFFFFF" frame="hsides" rules="rows">
									<tr style="color: #468847;">
										<td>
										<label style="padding-left:20px" class="control-label" >新闻类别:</label>
										
											<select id="menuFirst" name="menuIdF" onchange="management.naws.menuTypeS(this)"  > 
														<option value="0">请选择</option>
										   				<c:forEach var="menuF" items="${menuListF }" >
											   				 <c:choose>
											   				 		<c:when test="${menuF.id==10000}">
															       		 
															       </c:when>
															       <c:when test="${menuF.id==menuIdF}">
															       		<option value="${menuF.id}" selected="selected">${menuF.nameChina}</option>
															       </c:when>
															       <c:otherwise>
														       			<option value="${menuF.id}">${menuF.nameChina}</option>
															       </c:otherwise>
															</c:choose>
										   				</c:forEach>
											   		</select>
											   		
											   		
											   		<select name="menuIdS"   id="menuSecond"   >
											   			<option value="0">请选择</option>
										   				 <c:forEach var="menuS" items="${laswMenu.child }">
												   				 <c:choose>
																       <c:when test="${menuS.id==menuIdS}">
																       		<option value="${menuS.id}" selected="selected">${menuS.nameChina}</option>
																       </c:when>
																       <c:otherwise>
															       			<option value="${menuS.id}">${menuS.nameChina}</option>
																       </c:otherwise>
																</c:choose>
											   				</c:forEach>
											   		</select>
											   		
										
										 
										</td>
										<td>
											<label style="padding-left:30px" class="control-label" >新闻标题</label>
											<input id="newsTitleName" name="newsTitleName" value="${newsTitleName }" type="text"  class="inputcss"/>
										</td>
										<td>
											<label style="padding-left:10px" class="control-label" >发布时间:</label>
												<input onfocus="WdatePicker({startDate:'%y-%M-%d %H:%m:%s',dateFmt:'yyyy-MM-dd HH:mm:ss'})"
														name="beginTime" id="onseTime"  value="${param['beginTime']}" type="text" style="width: 180px;height: 30px;" class="Wdate inputcss" readonly="readonly"/>
											<label style="" class="control-label" >至</label>
												<input onfocus="WdatePicker({startDate:'%y-%M-%d %H:%m:%s',dateFmt:'yyyy-MM-dd HH:mm:ss'})"
														name="endTime" id="expiresTime" value="${param['endTime']}" type="text" style="width: 180px;height: 30px;" class="Wdate inputcss" readonly="readonly"/>
										</td>
										<td>
											<button style="width:100px" type="button" class="btn btn-success"onclick="management.list.listSearch('listForm')">查询</button>
										</td>
									</tr>
								</table>
							</div>
						 
							<!-- 条件查询：end -->
						<table class="table  table-bordered " id="news_table" style="margin-top: 10px">
							<thead>
								<tr style="text-align: center;">
									<td width="200px" style="text-align: center;font-weight: bold;">新闻标题</td>
									<td width="100px" style="text-align: center;font-weight: bold;">发布时间</td>
									<td width="50px" style="text-align: center;font-weight: bold;">新闻类型</td>
									<td width="50px" style="text-align: center;font-weight: bold;">是否置顶</td>
									<td width="50px" style="text-align: center;font-weight: bold;">点击量</td>
									<td width="100px" style="text-align: center;font-weight: bold;">操作</td>
								</tr>
							</thead>
							
							<c:forEach items="${page.list}" var="title">
								<tr style="text-align: center;">
									<td>${title.titleName }</td>
									<td style="text-align: center;"><fmt:formatDate value="${title.insertTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
									<td style="text-align: center;">${title.laswMenu.nameChina}</td>
									<td style="text-align: center;">
										<c:if test="${title.istop==0}">否</c:if>
										<c:if test="${title.istop==1}">是</c:if>
									</td>
									<td style="text-align: center;">${title.clickNumber}</td>
									<td style="text-align: center;">
										<a href="javascript: void(0);" onclick="management.list.editTitle(${title.id})">编辑</a>&nbsp;&nbsp;
										<a href="javascript:void(0);" onclick="management.list.deleteModelShow(${title.id},this)">删除</a>
									</td>
								</tr>
							</c:forEach>
							 
						</table>
					
						 <div class="col-md-12 center-block">
									<div class="dataTables_paginate paging_bootstrap pagination" style="margin: 1px 0">
										<ul class="pagination" style="margin: 1px 0">
											<c:if test="${page.hasPreviousPage }">
												<li class="prev"><a href="javascript:jumpPage('listForm',1)">首页</a></li>
												<li class="prev"><a href="javascript:jumpPage('listForm',${page.prePage })">←上一页</a></li>
											</c:if>
											<c:if test="${page.isFirstPage}">
												<li class="prev disabled"><a>首页</a></li>
												<li class="prev disabled"><a>← 上一页</a></li>
											</c:if>
										</ul>


										<ul class="pagination" style="margin: 1px 0">
											<li class="disabled"><a>共计 ${page.total }
													条数据，当前第${page.pageNum}/${page.pages}页</a></li>
										</ul>

										<ul class="pagination" style="margin: 1px 0">
											<c:if
												test="${page.hasNextPage}">
												<li class="next"><a href="javascript:jumpPage('listForm',${page.nextPage })">下一页→ </a></li>
												<li class="prev"><a href="javascript:jumpPage('listForm',${page.pages })">尾页</a>
												</li>
											</c:if>
											<c:if test="${page.isLastPage}">
												<li class="next disabled"><a>下一页 → </a></li>
												<li class="prev disabled"><a>尾页</a></li>
											</c:if>
										</ul>
									</div>
								</div> 
								
							
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
	
	

<div class="modal fade" id="modal_delete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="padding-top: 0px;">
        <div class="modal-dialog">
	        <div class="modal-content">
		        <div class="modal-header">
		            <h4 class="modal-title" id="myModalLabel">
		              温馨提示
		            </h4>
		         </div>
		         
		         <div class="modal-body" id="modal_delete_message">
		             
		         </div>
		         <div class="modal-footer">
		            <button type="button" class="btn btn-success"  data-dismiss="modal" onclick="management.list.deleteTitle(1)">
		               确定
		            </button>
		             <button type="button" class="btn btn-default"  data-dismiss="modal" onclick="management.list.deleteTitle(0)" style="margin-left: 50px">
		               取消
		            </button>
		         </div>
	        </div>
        </div>
    </div>	
	
	
	
	
	<script src="${ctx}/back_stage/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<script src="${ctx}/back_stage/js/jquery.cookie.js"></script>
	<script src='${ctx}/back_stage/bower_components/moment/min/moment.min.js'></script>
	<script src='${ctx}/back_stage/bower_components/fullcalendar/dist/fullcalendar.min.js'></script>
	<script src='${ctx}/back_stage/js/jquery.dataTables.min.js'></script>
	<script src="${ctx}/back_stage/bower_components/chosen/chosen.jquery.min.js"></script>
	<script src="${ctx}/back_stage/bower_components/colorbox/jquery.colorbox-min.js"></script>
	<script src="${ctx}/back_stage/js/jquery.noty.js"></script>
	<script src="${ctx}/back_stage/bower_components/responsive-tables/responsive-tables.js"></script>
	<script src="${ctx}/back_stage/bower_components/bootstrap-tour/build/js/bootstrap-tour.min.js"></script>
	<script src="${ctx}/back_stage/js/jquery.raty.min.js"></script>
	<script src="${ctx}/back_stage/js/jquery.iphone.toggle.js"></script>
	<script src="${ctx}/back_stage/js/jquery.autogrow-textarea.js"></script>
	<script src="${ctx}/back_stage/js/jquery.uploadify-3.1.min.js"></script>
	<script src="${ctx}/back_stage/js/jquery.history.js"></script>
	<script src="${ctx}/back_stage/js/charisma.js"></script>
	<script src="${ctx}/resource/script/management.js" type="text/javascript"></script>
<script type="text/javascript">
	var ctx='${ctx}';	
	var deleteTitleId;
	var deleteTitleTR;
</script>
	 
</body>
</html>
