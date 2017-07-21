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


<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>

<script type="text/javascript" src="${ctx}/js/plupload-2.1.0/js/plupload.full.min.js"></script>
<script type="text/javascript" src="${ctx}/js/GUID.js"></script>
<script type="text/javascript" src="${ctx}/js/date/My97DatePicker/WdatePicker.js"></script>

<script type="text/javascript" src="${ctx}/js/easydialog.min.js"></script>


<style type="text/css"> 
</style>

<style type="text/css"> 
 
</style>

<script type="text/javascript">
	
	
</script>
</head>

<body>

<jsp:include page="head.jsp" />


<div class="ch-container">
	<div class="row">
		<jsp:include page="left.jsp" />
		<div id="content" class="col-lg-10 col-sm-10">
			<div>
				<ul class="breadcrumb" style="margin-bottom: 0px;">
					<li><a href="#">新闻编辑管理</a>
					</li>
					<li><a href="#">新闻编辑<c:if test="${laswNewsContent.id==null}">录入</c:if><c:if test="${laswNewsContent.id!=null}">编辑</c:if></a>
					</li>
				</ul>
			</div>
			
			
			
		<div class="row">
		    <div class="box col-md-12">
		        <div class="box-inner">
		            <div class="box-header well">
		                <h2><i class="glyphicon glyphicon-user"></i> 新闻编辑<c:if test="${laswNewsContent.id==null}">录入</c:if><c:if test="${laswNewsContent.id!=null}">编辑</c:if></h2>
		                <div class="box-icon">
		                    <a href="#" class="btn btn-minimize btn-round btn-default"><i class="glyphicon glyphicon-chevron-up"></i></a>
		                </div>
		            </div>
		            <div class="box-content row">
			          	 <%--  <form method="post" action="${ctx }/management/post/news">
			           			<input type="text" name="titleName" id="titleName"  />
						     	<br> <input  type="submit" value="注册">
						   </form> --%>
						   
						   <form method="post"  id="naswForm" >
								<c:if test="${laswNewsContent.laswNewsTitle!=null}">
									<input  type="hidden" name="titleId" value="${laswNewsContent.laswNewsTitle.id}" />
								</c:if>
								<input  type="hidden" name="contentId" value="${laswNewsContent.id}" />
							
									<div style="padding-left:20px;"  >
			    						<table style="border-collapse:collapse;font-size:12px;width:98%;border-top: 0px solid #808080;" border="0" align="left">
										    <tr>
										        <td class="td-left-4" style="width: 10%;"><span style="color: #ff0000;">*</span>新闻类别：</td>
										        <td>
										        	<!-- <select name="" onchange="management.naws.menuTypeS(this)"  class="selectpicker"  > -->
										        	<select id="menuFirst" onchange="management.naws.menuTypeS(this)"  <c:if test="${laswNewsContent.id!=0}">disabled="disabled" </c:if>  > 
										   				<c:forEach var="menuF" items="${menuListF }" >
											   				 <c:choose>
											   				 		<c:when test="${menuF.id==10000}">
															       		 
															       </c:when>
															       <c:when test="${menuF.id==laswMenu.id}">
															       		<option value="${menuF.id}" selected="selected">${menuF.nameChina}</option>
															       </c:when>
															       <c:otherwise>
														       			<option value="${menuF.id}">${menuF.nameChina}</option>
															       </c:otherwise>
															</c:choose>
										   				</c:forEach>
											   		</select>
											   		<select name="laswmenuId"   id="menuSecond"  <c:if test="${laswNewsContent.id!=0}">disabled="disabled" </c:if> >
										   				<c:if test="${laswNewsContent.id==0}">
											   				<c:forEach var="menuS" items="${laswMenu.child }">
												   				 <c:choose>
																       <c:when test="${menuS.id==laswNewsContent.laswNewsTitle.laswmenuId}">
																       		<option value="${menuS.id}" selected="selected">${menuS.nameChina}</option>
																       </c:when>
																       <c:otherwise>
															       			<option value="${menuS.id}">${menuS.nameChina}</option>
																       </c:otherwise>
																</c:choose>
											   				</c:forEach>
										   			 </c:if>
										   			 <c:if test="${laswNewsContent.id!=0}">
											       			<option value="${laswMenu.id}">${laswMenu.nameChina}</option>
										   			 </c:if>
										   			 
											   		</select>
									        </td>
									    </tr>
			    
									    <tr>
									        <td class="td-left-4" ><span style="color: #ff0000;">*</span>发布日期：</td>
									        <td >
											        <c:if test="${laswNewsContent.id==0}">
												       	 <input onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M-%d %H:%m:%s'})"
															name="insertTime" id="newsdate" type="text" style="width: 185px" class="Wdate" 
															value="<fmt:formatDate value='${laswNewsContent.laswNewsTitle. insertTime}' pattern='yyyy-MM-dd HH:mm:ss'/>" readonly="readonly" />
											        </c:if>
											       <c:if test="${laswNewsContent.id!=0}">
											       		 <input   type="text" style="width: 185px"  name="insertTime"
											       		  value="<fmt:formatDate value='${laswNewsContent.laswNewsTitle. insertTime}' pattern='yyyy-MM-dd HH:mm:ss'/>" readonly="readonly" />
									        	  </c:if>
									        </td>
									    </tr>
			    
									    <tr>
									        <td class="td-left-4" ><span style="color: #ff0000;">*</span>新闻标题：</td>
									        <td >
									        	<input type="text" name="titleName" value="${laswNewsContent.laswNewsTitle.titleName}" style="width: 400px;" />
									        </td>
									    </tr>
									    
									     <tr >
									        <td class="td-left-4" ><span style="color: #ff0000;">*</span>是否置顶：</td>
									        <td style="height: 30px;line-height: 20px;">
										        <label class="radio-inline">
								                    <input name="istop"   value="0" type="radio"  <c:if test="${laswNewsContent.laswNewsTitle.istop==0}"> checked="checked"</c:if>> 否
								                </label>
								                <label class="radio-inline" style="margin-left: 30px">
								                    <input name="istop" value="1" type="radio" <c:if test="${laswNewsContent.laswNewsTitle.istop==1}"> checked="checked"</c:if>> 是
								                </label>
									         
									        </td>
									    </tr>
									    
									 
									    <tr id="newsContentTr">
									        <td class="td-left-4" ><span style="color: #ff0000;">*</span>新闻内容：</td>
									        <td >
									        	<div>
												     <!-- 加载编辑器的容器 -->
												    <script name="newsContent" id="container"  type="text/plain" style="width:800px;height:200px;">${laswNewsContent.newsContent} </script>
															    <!-- 配置文件 -->
												    <script type="text/javascript" src="${ctx}/js/ueditor/ueditor.config.js"></script>
												    			<!-- 编辑器源码文件 -->
												    <script type="text/javascript" src="${ctx}/js/ueditor/ueditor.all.js"></script>
												    			<!-- 加载中文语言类型 -->
												    <script type="text/javascript" charset="utf-8" src="${ctx}/js/ueditor/lang/zh-cn/zh-cn.js"></script>
												   				 <!-- 实例化编辑器 -->
												    <script type="text/javascript">
												        var ue = UE.getEditor('container');
												    </script>
												</div>
									        </td>
									    </tr>
								    <tr>
								    	<td class="td-left-4"  align="right" style="width: 10%;"> </td>
								     	<td  >
								     	<br/><br/><br/><br/>
								     		<div style="width: 20%" align="left">
												<a href="#" class="btn btn-primary" onclick="management.edit.submit()" 	id="uploadfiles"  style="margin-right: 40px;">保存</a>
												<c:if test="${laswNewsContent.id==0}"><a href="#" class="btn btn-default"  onclick="management.edit.cancel(0);">取消</a> </c:if>
												<c:if test="${laswNewsContent.id!=0}"><a href="#" class="btn btn-default"  onclick="management.edit.cancel(-1);">取消</a> </c:if>
								     		</div>
								     		<br/><br/>
								    	</td>
								  	  </tr> 
		   							</table> 
								</div>
							</form>
            			</div>
        			</div>
   				</div>
			</div>
		</div>
	</div>
</div>
	
 


 <div class="modal fade" id="myModal_alert_wait" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="margin-top: 100px;height: 500px;">
   <div class="modal-dialog">
    <div class="modal-content">
     <div class="modal-header">
         <h4 class="modal-title" id="myModalLabel">
           温馨提示
         </h4>
      </div>
      
      <div class="modal-body" id="alertContent" style="height: 300px;padding: 0px;">
      	<div style="width: 50%;float: left;border: 0px solid red;line-height: 300px;font-size: 20px;padding-right: 20px" align="right">请等待</div>
      	<div style="width: 50%;float: right;border: 0px solid red;line-height: 300px;" align="left"><i class="fa fa-spinner fa-spin" style="font-size: 80px;line-height: 300px;color: #11A4E9"></i></div>
       </div>
       <div class="modal-footer">
       </div>
     </div>
    </div>
</div>



<div class="modal fade" id="modal_success" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="padding-top: 0px;">
        <div class="modal-dialog">
	        <div class="modal-content">
		        <div class="modal-header">
		            <h4 class="modal-title" id="myModalLabel">
		              温馨提示
		            </h4>
		         </div>
		         
		         <div class="modal-body" id="modal_success_message">
		             
		         </div>
		         <div class="modal-footer">
		            <button type="button" class="btn btn-success"  data-dismiss="modal" onclick="management.edit.forwardUrlAndHidden(1)">
		               进入新闻列表
		            </button>
		             <button type="button" class="btn btn-success"  data-dismiss="modal" onclick="management.edit.forwardUrlAndHidden(0)">
		               继续编辑
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
<script src="${ctx}/back_stage/bower_components/bootstrap/dist/js/bootstrap-select.js"></script>
<script src="${ctx}/resource/script/management.js" type="text/javascript"></script>
<script type="text/javascript">
var ctx='${ctx}';		
$(function () { 
});
</script>

</body>
</html>
