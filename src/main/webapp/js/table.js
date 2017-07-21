function jumpPage(formId,pageNo){
	var action = $("#"+formId).attr("action") + "?pageNo=" + pageNo;
	$("#"+formId).attr("action",action);
	$("#"+formId).submit();
}

function jumpPage(formId, pageNo,totalPage){
	if(pageNo > totalPage){
		alert("最大页数为" + totalPage + "页，请重新输入！");
	}else{
		$("#pageNo").val(pageNo);
		$("#"+formId).submit();
	}
}

function ajaxPage(formName, pageNo){
	$("#pageNo").val(pageNo);
	var contentName = $("#contentName").val();
	var options ={
		  url:$("#"+formName).action,  
		  type:'POST', 
		  success: function(msg) {
		  	  $("#"+contentName).html(msg);
		  }  
    };  
 	$("#"+formName).ajaxSubmit(options);
}
	                    
function search(formId){
	$("#order").val("");
	$("#orderBy").val("");
	$("#pageNo").val("1");
	$("#"+formId).submit();
}


function toUrl(url){
	if(url == 'undefied' || url == null || url == ''){
		alert('没有跳转路径');
		return;
	}
		
	location.href = url;
 }	

 function delUrl(url){
	 var str="";  
	 $("[type='checkbox']:checked").each(function(){
		 if($(this).val() != "on"){
			 str+=$(this).val()+",";
			 
		 }     
	 });

	 if(str.lastIndexOf(',') == -1){
		alert("没有选择一条记录");
	 }else{
		if(confirm("注意：删除时会将对应的所有下级数据删除,确认删除吗?")){
			if(url.indexOf('?') >= 0){
				location.href=url +"&delId="+ str.substring(0,str.lastIndexOf(','));
			}else{
				location.href=url +"?delId="+ str.substring(0,str.lastIndexOf(','));
			}
		
		}
	 } 
 }
 
 

 function editUrl(url){
	 var str=""; 
	 $("[type='checkbox']:checked").each(function(){
		 if($(this).val() != "on"){
			 str+=$(this).val()+",";
		 }     
	 });
	
	 if(str.lastIndexOf(',') == -1){
		alert("没有选择一条记录");
	 }else{
		var eid = str.substring(0,str.lastIndexOf(','));
		if(eid.indexOf(',') >= 0){
			alert("只能选择一条记录进行编辑");
		}else{
			if(url.indexOf('?') >=0){
				//shW(url +"&id="+ eid);
				location.href=url +"&id="+ eid;
			}else{
				//shW(url +"?id="+ eid);
				location.href=url +"?id="+ eid;
			}
		}
	 } 
 }
 
 function editUrlUser(url){
	 var str=""; 
	 $("[type='checkbox'][checked]").each(function(){
		 if($(this).val() != "on"){
			 str+=$(this).val()+",";
		 }     
	 }); 
	      
	 if(str.lastIndexOf(',') == -1){
		alert("没有选择一条记录");
	 }else{
		var eid = str.substring(0,str.lastIndexOf(','));
		if(eid.indexOf(',') >= 0){
			alert("只能选择一条记录进行编辑")
		}else{
			if(url.indexOf('?') >=0){
				shW(url +"&ids="+ eid);
				//location.href=url +"&ids="+ eid;
			}else{
				shW(url +"?ids="+ eid);
				//location.href=url +"?ids="+ eid;
			}
		}
	 } 	 
 }
 
 function editUrlRole(url){
	 var str=""; 
	 
	 $(":checkbox[checked]").each(function(){
		 if($(this).val() != "on"){
			 str+=$(this).val()+",";
		 }     
	 }); 
	     
	 if(str.lastIndexOf(',') == -1){
		alert("没有选择一条记录");
	 }else{
		var eid = str.substring(0,str.lastIndexOf(','));
		if(eid.indexOf(',') >= 0){
			alert("只能选择一条记录进行编辑");
		}else{
			if(url.indexOf('?') >=0){
				location.href=url +"&id="+ eid+"&type=update";
			}else{
				location.href=url +"?id="+ eid+"&type=update";
			}
		}
	 } 
 }
 
function toggleCheckbox(o){
	 if($(o).attr("checked")){
			$("[type='checkbox']").attr("checked",'true');//全选
	 }else{
			$("[type='checkbox']").removeAttr("checked");//取消全选
	 }
}
function shW(url){
	var frame = document.getElementById("frame");
	frame.style.display = "block";
	var cover = document.getElementById("cover");
	
	frame.style.top = "10%";
	frame.style.left = "15%";
	frame.src = url;
	
	cover.style.display = "block";
}

function checkCount(name){
	var ids = new Array();
	$.each($(':input[name="' + name + '"]:checked'),function(i,n){
		ids.push($(n).val());
	});
	return ids;
}

//------日期转换-----
Date.prototype.format = function(format){
	var o = {
	 "M+" : this.getMonth()+1, //month
	 "d+" : this.getDate(),    //day
	 "h+" : this.getHours(),   //hour
	 "m+" : this.getMinutes(), //minute
	 "s+" : this.getSeconds(), //second
	 "q+" : Math.floor((this.getMonth()+3)/3),  //quarter
	 "S" : this.getMilliseconds() //millisecond
	};
	if(/(y+)/.test(format)) 
		format=format.replace(RegExp.$1,(this.getFullYear()+"").substr(4 - RegExp.$1.length));
	for(var k in o)
		if(new RegExp("("+ k +")").test(format))
			format = format.replace(RegExp.$1,RegExp.$1.length==1 ? o[k] :("00"+ o[k]).substr((""+ o[k]).length));
	return format;
}

//鼠标在表格行上时高亮显示
function FocusTableRow(tableId,rowIndex)
{
	var preBgColor = null;
	var table = document.getElementById(tableId);
	if (table == null){
    	return;
	}
	if (table.rules != null){
	    table.rules = "none";
	}
	var tbody = table.getElementsByTagName("tbody")[0];
	var rows = tbody.getElementsByTagName("tr");
	for (var i=rowIndex; i < rows.length; i++){
		rows[i].onmouseover = function() { preBgColor=this.style.backgroundColor; this.style.backgroundColor='#CFE4FE'; };
		rows[i].onmouseout = function() { this.style.backgroundColor=preBgColor; };
	}
}
//折叠表单区块
function WrapBlock(strDivId,wrapImg){
    var objImg = document.getElementById(wrapImg);
	var objDiv = document.getElementById(strDivId);
	var objInnerDivs = objDiv.getElementsByTagName("div");
    if (objImg){
        if (objImg.src.toString().indexOf("block_unwrap") != -1){
            objImg.src = "../../images/block_wrap.gif";
			for (var i=0; i<objInnerDivs.length; i++){
			    if(objInnerDivs[i].className == "DivTail"){
				    objInnerDivs[i].style.display = "none";
				}
			}
        }else{
            objImg.src = "../../images/block_unwrap.gif";
            for (var i=0; i<objInnerDivs.length; i++)
			{
			    if(objInnerDivs[i].className == "DivTail")
				{
				    objInnerDivs[i].style.display = "block";
				}
			}
        }
    }
}

function positionDiv(e, errorMsg, id){
	var divContent = "<div id='"+id+"Tip' class='ui-tooltip ui-widget ui-corner-all ui-widget-content' role='tooltip' style='top:'"+ (e.offset().top+25) +"'px; left: '"+e.offset().left+"'px; display: block;'><div class='ui-tooltip-content'>"+errorMsg+"</div></div>";
    $("#"+id).insertAfter(divContent);                       
}

 