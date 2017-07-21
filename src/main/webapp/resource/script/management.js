//存放主要交互逻辑js代码
//javascript 模块化
var management={
		//封装秒杀相关ajax的URL
		URL:{
			list:function(menuF,menuS){
				return ctx+"/management/news/list?menuIdF="+menuF+"&menuIdS="+menuS;
			},
			edit:function(titleId){
				return ctx+"/management/news/"+titleId+"/edit"; 
			},
			delT:function(titleId){
				return ctx+"/management/delete/news/"+titleId; 
			},
			menuF:function (){
				//返回新闻类别第一级 菜单的数据
				return ctx+"/lasw/menu/top";
			},
			menuS:function (parentId){
				//返回新闻类别第二级 菜单的数据
				return ctx+"/lasw/"+parentId+"/left";
			},
			editSubmit:function(){
				return ctx+"/management/post/news";
			}
		}, 
		list:{
			editTitle:function(titleId){
				window.location.href=management.URL.edit(titleId);
			},
			deleteModelShow:function(titleId,obja){
				deleteTitleId=titleId;
				deleteTitleTR=obja;
				//弹出框框
				management.alert.showModalAndMessage("modal_delete","modal_delete_message","是否删除该数据?");
			},
			deleteTitle :function(val){
				if(val==0){
					management.alert.closeModal("modal_delete");
				}else if(val==1){
					$.ajax({
				        type: "delete",
				        url: management.URL.delT(deleteTitleId),
				        contentType: 'application/json',
				        success: function (result) {
				        	management.alert.closeModal("modal_delete");
				        	if(result.success){
								//删除成功
								$(deleteTitleTR).parent("td").parent("tr").remove();
							}else{
								//删除失败
								alert(result.data.stateInfo);
							}
				        }
				    });
				}
			},
			listSearch:function(formId){
				$("#pageNum").val(1);
				$("#"+formId).submit();
				
			}
			
		},
		alert:{
			showModalAndMessage:function(objId,messageId,message){////显示modal
				var messageObj=$("#"+messageId);
					   messageObj.html(message);
				var alertObj=$('#'+objId);
				//显示弹出层
				alertObj.modal({
					show:true,//显示弹出层
					backdrop: 'static', //禁止点击其他地方关闭
					keyboard: false//禁止键盘关闭
				});
			},
			showWaitModal:function(objId){////显示modal
				var alertObj=$('#'+objId);
				//显示弹出层
				alertObj.modal({
					show:true,//显示弹出层
					backdrop: 'static', //禁止点击其他地方关闭
					keyboard: false//禁止键盘关闭
				});
			},
			closeModal:function(objId){//关闭modal
				var closeObj=$('#'+objId);
				closeObj.modal('hide');
			}
		},
		naws:{
			menuTypeS:function(obj){
				var parentId=$(obj).val();
				$.get(management.URL.menuS(parentId),{},function(result){
					var menuTypeSHtml='<option value="0">请选择</option>';
					$.each(result.child,function(i,menuSecond){
						menuTypeSHtml+='<option value="'+menuSecond.id+'">'+menuSecond.nameChina+'</option>';
					});
					$("#menuSecond").html(menuTypeSHtml);
				});
			}
		},
		edit:{
			submit:function(){
				//$("#naswForm").submit()
				management.alert.showWaitModal("myModal_alert_wait");
			 	var naswFormValue=$("#naswForm").serialize();
				//新闻编辑页面提交数据
				$.post(management.URL.editSubmit(),naswFormValue,function(result){
					management.alert.closeModal("myModal_alert_wait");
						if(result.success){
							//保存成功
							management.alert.showModalAndMessage("modal_success","modal_success_message",result.data.stateInfo);
						}else{
							//保存失败
							alert(result.data.stateInfo);
							
						}
				}); 
			},
			forwardUrlAndHidden:function(value){
				management.alert.closeModal("modal_success");
				if(value==0){//继续添加新闻
					window.location.reload(true);
				}else if(value==1){//进入新闻列表
					$("#menuFirst").val();
					window.location.href=management.URL.list($("#menuFirst").val(),$("#menuSecond").val())
				}
			},
			cancel:function(val){
				if(val==-1){
					history.go(-1);
				}else if(val==0){
					window.location.reload(true);
				}
			}
		}
}



