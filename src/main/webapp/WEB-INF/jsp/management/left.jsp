<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/tag.jsp" %>
<script type="text/javascript">
 $(function(){
	 //控制后台后边菜单栏的打开和关闭
	 var nowUrl=document.URL.split(window.location.port+"/")[1];
	 var urlClass=nowUrl.split("!")[0].split("/");
	 var aUrlClass="";
	 $("a[class='none_wq']").each(function(i){
		 if($(this).attr('href')!=null&&$(this).attr('href')!=''&&$(this).attr('href')!='undefined'&&$(this).attr('href')!='#'){
			 aUrlClass=$(this).attr('href').split("!")[0].split("/");
			 if(urlClass[urlClass.length-1]==aUrlClass[aUrlClass.length-1]){
				 $(this).parent().parent().parent().addClass("active");
				 $(this).parent().parent().css("display","block");
				 return false; 
			 }
		 }
	 });
 });
 
 
 
</script>
 <div class="col-sm-2 col-lg-2" style="padding-bottom: 30px;">
    <div class="sidebar-nav">
        <div class="nav-canvas">
            <div class="nav-sm nav nav-stacked">
            </div>
            
            <ul class="nav nav-pills nav-stacked main-menu">
                
                
                <li class="nav-header">新闻管理</li>
                <li class="accordion">
	                   <a href="#"><i class="glyphicon glyphicon-plus"></i><span> 项目动态管理</span></a>
	                   <ul style="display: none;" class="nav  nav-stacked">
	                      <li>
	                      		<a href="${ctx}/management/news/list" class="none_wq">
	                      			<i class="glyphicon glyphicon-globe"></i>
	                      			<span>新闻列表</span>
	                      		</a>
	                      </li>
	                      <li>
	                      		<a href="${ctx}/management/news/0/edit" class="none_wq">
	                     		 		<i class="glyphicon glyphicon-globe"></i>
	                     		 		<span>新闻录入</span>
	                     		 </a>
	                      </li>
	                   </ul>
                </li>
            </ul>
        </div>
    </div>
</div>
  