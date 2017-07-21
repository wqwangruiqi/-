<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/tag.jsp" %>
 <link href="${ctx}/resource/css/font-awesome-4.6.3/css/font-awesome.min.css" rel="stylesheet"/>
<script type="text/javascript">
	 
</script>
<div class="navbar navbar-default" role="navigation">
  <div class="navbar-inner">
       
      <a class="navbar-brand" href="${ctx }" style="width: 670px"> 
      	<img style="width:50px;height:39px;margin-top: -10px" alt="CAMS Logo" src="${ctx}/back_stage/img/qkylogo.png" class="hidden-xs"/>
	  	<span>Institue of Atmospheric Composition,CAMS</span>
      
      </a>

      <div class="btn-group pull-right">
          <button class="btn btn-default dropdown-toggle" data-toggle="dropdown" style=" width: 160px;">
              <i class="glyphicon glyphicon-user"></i>
              <span class="hidden-sm hidden-xs">
					 
              </span>
              <span class="caret"></span>
          </button>
          <ul class="dropdown-menu">
              <li class="divider"></li>
              <li><a onclick="logout()">安全退出</a></li>
              <li><a onclick="getHelpFileDoc()">系统帮助</a></li>
          </ul>
      </div>
      <div class="btn-group pull-right theme-container animated tada" style="">
          <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
              <i class="glyphicon glyphicon-tint"></i>
              <span class="hidden-sm hidden-xs">　切换主题/皮肤　</span>
              <span class="caret"></span>
          </button>
          <ul class="dropdown-menu" id="themes" address="${ctx}/back_stage/">
              <li><a data-value="classic" href="#"><i class="whitespace"></i> 经典白</a></li>
              <li><a data-value="cerulean" href="#"><i class="whitespace"></i> 天空蓝</a></li>
              <li><a data-value="cyborg" href="#"><i class="whitespace"></i> 金属黑</a></li>
              <li><a data-value="simplex" href="#"><i class="whitespace"></i> 单纯白</a></li>
              <li><a data-value="darkly" href="#"><i class="whitespace"></i> 夜空黑</a></li>
              <li><a data-value="lumen" href="#"><i class="whitespace"></i> 黎明白</a></li>
              <li><a data-value="slate" href="#"><i class="whitespace"></i> 深蓝灰</a></li>
              <li><a data-value="united" href="#"><i class="whitespace"></i> 橘子橙</a></li>
          </ul>
      </div>
    </div>
</div>
<div style="display: none;">
	<form action="" method="post" target="_black" id="projectLoginForm">
		<input  type="hidden" name="fromToCamsManagement" value="fromToCamsManagement"/>
	</form>
</div>
 
 <div class="modal fade" id="myModal_alert" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="padding-top: 0px;z-index：9999">
        <div class="modal-dialog">
	        <div class="modal-content">
		        <div class="modal-header">
		           <!--  <button type="button" class="close" data-dismiss="modal"  aria-hidden="true">
		            	×
		            </button> -->
		            <h4 class="modal-title" id="myModalLabel">
		              温馨提示
		            </h4>
		         </div>
		         
		         <div class="modal-body" id="alertContent">
		             
		         </div>
		         <div class="modal-footer">
		            <button type="button" class="btn btn-default"  data-dismiss="modal">
		               确定
		            </button>
		         </div>
	        </div>
        </div>
    </div>
    
    
    
    
    
    <div class="modal fade" id="myModal_alert_url" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="padding-top: 0px;">
        <div class="modal-dialog">
	        <div class="modal-content">
		        <div class="modal-header">
		           <!--  <button type="button" class="close" data-dismiss="modal"  aria-hidden="true">
		            	×
		            </button> -->
		            <h4 class="modal-title" id="myModalLabel">
		              温馨提示
		            </h4>
		         </div>
		         
		         <div class="modal-body" id="alertContent_url">
		             
		         </div>
		         <div class="modal-footer">
		            <button type="button" class="btn btn-default"  data-dismiss="modal" onclick="forwardUrlAndHidden()">
		               确定
		            </button>
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

