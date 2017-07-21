//存放主要交互逻辑js代码
//javascript 模块化
//sekil.detail.init(partments) 
var seckill={
		//封装秒杀相关ajax的URL
		URL:{
			now:function (){
				return ctx+"/seckill/time/now";
			},
			exposer:function(seckillId){
				return ctx+"/seckill/"+seckillId+"/exposer";
			},
			execute:function(seckillId,md5){
				return ctx+"/seckill/"+seckillId+"/"+md5+"/execute"; 
			}
		},
		//验证手机号
		validatePhone:function(phone){
			if(phone  && phone.length==11 && !isNaN(phone) ){
				return true;
			}else{
				return false;
			}
		},
		handleSeckill:function(seckillId,node){
			//处理秒杀逻辑
			//添加节点 隐藏节点 
			node.hide().html('<button class="btn btn-primary btn-lg" id="killBtn" >开始秒杀</button>');
			$.post(seckill.URL.exposer(seckillId),{},function(result){
				//在回调函数中执行交互流程
				if(result && result.success){
					var exposer=result.data;
					if(exposer.exposed){
						//开启秒杀
						//获取秒杀地址
						var md5=exposer.md5;
						var killUrl=seckill.URL.execute(seckillId,md5);
						console.log("killUrl:"+killUrl);
						$("#killBtn").one("click",function(){//只绑定一次点击事件  防止用户不停的发送请求
							//先禁用按钮
							$(this).addClass('disabled');
							//执行秒杀操作事件(发送秒杀请求)
							$.post(killUrl,{},function(result){
								if(result && result.success){
									var seckillExecution=result.data;
									var state=seckillExecution.state;
									var stateInfo=seckillExecution.stateInfo;
									//显示秒杀结果
									node.html('<span class="label label-success">'+stateInfo+'</span>');
								}else{
									console.log("result:"+result);
								}
							});
						});
						
						node.show();
					}else{
						//未开始秒杀  一般客户机和服务器存在时间差的情况下 以服务器时间为准
						var now = exposer.now;
						var start = exposer.start;
						var end = exposer.end;
						//重新计算 倒计时逻辑
						seckill.countDown(seckillId,now,start,end);
					}
				}else{
					console.log("result:"+result);
				}
			});
			
		},
		countDown:function(seckillId,nowTime,startTime,endTime){
			var seckillBox=$("#seckill-box");
			if(nowTime>endTime){
				//秒杀结束
				seckillBox.html("秒杀结束!");
			}else if(nowTime<startTime){
				//秒杀未开始 倒计时
				//计时时间绑定
				var killTime=new Date(startTime+1000);//加一秒是防止计时的偏移
				seckillBox.countdown(killTime,function(event){
					//控制时间格式
					var format=event.strftime('秒杀倒计时: %D天 %H时 %M分 %S秒');
					seckillBox.html(format);
				}).on('finish.countdown',function(){
					//倒计时完成后回调事件
					//倒计时结束 表示秒杀开始   即  获取秒杀地址 
					seckill.handleSeckill(seckillId,seckillBox);
				});
				
			}else{
				// 秒杀开始   即  获取秒杀地址 
				//seckillBox.html("");
				seckill.handleSeckill(seckillId,seckillBox);
			}
			
		},
		//详情页秒杀逻辑
		detail:{
			//详情页初始化
			init: function(params){
				//用户手机验证和登录  以及 及时交互
				//规划我们的交互流程 
				//在cookie里面查找手机号
				var  killPhone = $.cookie('killPhone');
				
				//console.log("killPhone="+killPhone);
				//验证手机号
				if(!seckill.validatePhone(killPhone)){//需要绑定手机号码
					//绑定phone
					var killPhoneModal=$('#killPhoneModal');
					//显示弹出层
					killPhoneModal.modal({
						show:true,//显示弹出层
						backdrop: 'static', //禁止点击其他地方关闭
						keyboard: false//禁止键盘关闭
					});
					
					//绑定点击事件 (用户填写了表单输入框)
					$("#killPhoneBtn").click(function(){
						var  inputPhone=$("#killPhone").val();
						if(seckill.validatePhone(inputPhone)){
							//电话写入cookie  expires 有效时间    path 有效模块
							$.cookie('killPhone', inputPhone, { expires: 7, path: ctx+'/seckill' }); 
							//刷新页面
							window.location.reload();
						}else{
							$("#killPhoneMessage").hide().html('<label class="label label-danger">手机号错误!</label>').show(300);
						}
					});
				} 
				//已经登录 console.log("");
				var startTime=params['startTime'];
				var endTime=params['endTime'];
				var seckillId=params['seckillId'];
				$.get(seckill.URL.now(),{},function(result){
					if(result  &&  result['success']){
						var nowTime=result.data;
						//时间判断  计时交互
						seckill.countDown(seckillId,nowTime,startTime,endTime);
					}else{
						console.log("result:"+result);
					}
				});
			}
		}
}



