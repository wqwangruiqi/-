//存放主要交互逻辑js代码
//javascript 模块化
//lasw.top.menu(partments) 
var lasw={
		//封装秒杀相关ajax的URL
		URL:{
			main:function(topMenuId,leftMenuId,titleId){
				return ctx+"/lasw/"+topMenuId+"/main/"+leftMenuId+"/left/"+titleId+"/detail"; 
			},
			menu:function (){
				//返回top 获取菜单的数据
				return ctx+"/lasw/menu/top";
			},
			left:function (parentId){
				//返回top 获取菜单的数据
				return ctx+"/lasw/"+parentId+"/left";
			},
			right:{
				//右边详情页url
				detail:function(leftMenuId){
					return ctx+"/lasw/right/"+leftMenuId+"/detail";
				},
				news:function(titleId){
					return ctx+"/lasw/right/"+titleId+"/news";
				}
			}
		}, 
		//重新加载main页面
		refreshMainPage:function(menuId){
			window.location.href=lasw.URL.main(menuId,0,0);
		},
		//改变指定id对象的高度
		changeIframeHight:function(){
			parent.document.getElementById("rightIframe").height=document.body.scrollHeight;
		},
		top:{
			menu:function(){
				$.get(lasw.URL.menu(),{},function(result){
					var menuFirstHtml='';
					$.each(result,function(i,menuFirst){
						//因为首页项已经存在 不需要加载首页 这里过滤掉首页项
						if(menuFirst.id != 1 && menuFirst.menuShow==1){
							menuFirstHtml+='<a href="javascript:void(0)" onclick="lasw.refreshMainPage('+menuFirst.id+',0,0)"  class="'+menuFirst.cssimg+'"></a>  ';
						}
					});
					$("#menuFirst").html(menuFirstHtml);
				});
			}
		},
		left:{
			//加载左边菜单列信息
			menu:function(topMenuId,leftMenuId,titleId){
				var left_menu_ul_1_html='';
				//获取左边菜单栏
				$.get(lasw.URL.left(topMenuId),{},function(result){
					$("#left_menu_span_1").html(result.nameChina);
					$.each(result.child,function(i,menuSecond){
						left_menu_ul_1_html+='<li><a href="javascript:void(0)" onclick="lasw.right.iframe('+menuSecond.id+',this)" id=leftMenu_a_'+menuSecond.id+'><div class="lixsttyext"><span>'+menuSecond.nameChina+'</span><i>'+menuSecond.nameEnglish+'</i></div></a></li>';
					});
					$("#left_menu_ul_1").html(left_menu_ul_1_html);
					
					if(leftMenuId>0){
						//表示有指定显示哪个二级菜单
						$(".kjhover").removeClass("kjhover");
						//表示有指定显示哪个新闻内容
						if(titleId>0){
							$("#leftMenu_a_"+leftMenuId).addClass("kjhover");
							$('#rightIframe').attr('src',lasw.URL.right.news(titleId));
						}else{
							$("#leftMenu_a_"+leftMenuId).click();
						}
						
					}else{
						//默认点击一下第一个菜单
						$("#left_menu_ul_1").find("a")[0].click();
					}
				});
			}
		},
		right:{
			iframe:function(leftMenuId,li_a_obj){
				$(".kjhover").removeClass("kjhover");
				$(li_a_obj).addClass("kjhover");
				$('#rightIframe').attr('src',lasw.URL.right.detail(leftMenuId)) ;
			}
		}
}



