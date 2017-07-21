<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/head.jsp"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"></meta>
<title>灾害天气国家重点实验室</title>

<script type="text/javascript"> 
</script>
</head>
<body>
<%@ include file="top.jsp"%> 
<div class="minboxsx">
   <div class="minboxs">
    <div class="minbox">
     <div id="picBox"> 
      <ul id="show_pic" style="left:0;"> 
       <li><a href="${ctx}/kydt/ff8080814c92030b014cb1ef3ba20000.html" target="_blank">
       		<img src="${ctx}/siteResources/lasw//resources/images/show/20150429/i041540296da1b.jpg" width="988" height="311" /></a></li> 
       <li><a href="${ctx}/zhxw/ff8080814b21fd41014b339010550000.html" target="_blank">
       		<img src="${ctx}/siteResources/lasw//resources/images/show/20150213/i04452931888fb.jpg" width="988" height="311" /></a></li> 
       <li><a href="${ctx}/zhxw/ff80808149ccac7a0149ea2a3bcb0230.html" target="_blank">
      	 	<img src="${ctx}/siteResources/lasw//resources/images/show/20150109/i091027650f163.jpg" width="988" height="311" /></a></li> 
       <li><a href="h${ctx}/zhxw/ff8080814974fbd8014978c309810003.html" target="_blank">
     	  	<img src="${ctx}/siteResources/lasw//resources/images/show/20141127/i1009536479e73.jpg" width="988" height="311" /></a></li> 
       <li><a href="${ctx}/zhxw/ff8080814951158a01495b06d064006c.html" target="_blank">
      	 	<img src="${ctx}/siteResources/lasw//resources/images/show/20150302/i11124177082d6.jpg" width="988" height="311" /></a></li> 
      </ul> 
      <ul id="icon_num"> 
       <li class="active"></li> 
       <li></li> 
       <li></li> 
       <li></li> 
       <li></li> 
      </ul>
     </div>
     <script type="text/javascript">var glide =new function(){	function $id(id){return document.getElementById(id);};	this.layerGlide=function(auto,oEventCont,oSlider,sSingleSize,second,fSpeed,point){		var oSubLi = $id(oEventCont).getElementsByTagName('li');		var interval,timeout,oslideRange;		var time=1; 		var speed = fSpeed; 		var sum = oSubLi.length;		var a=0;		var delay=second * 3000; 		var setValLeft=function(s){			return function(){				oslideRange = Math.abs(parseInt($id(oSlider).style[point]));					$id(oSlider).style[point] =-Math.floor(oslideRange+(parseInt(s*sSingleSize) - oslideRange)*speed) +'px';						if(oslideRange==[(sSingleSize * s)]){					clearInterval(interval);					a=s;				}			};		};		var setValRight=function(s){			return function(){	 					oslideRange = Math.abs(parseInt($id(oSlider).style[point]));											$id(oSlider).style[point] =-Math.ceil(oslideRange+(parseInt(s*sSingleSize) - oslideRange)*speed) +'px';				if(oslideRange==[(sSingleSize * s)]){					clearInterval(interval);					a=s;				}			};		};				function autoGlide(){			for(var c=0;c<sum;c++){oSubLi[c].className='';};			clearTimeout(interval);			if(a==(parseInt(sum)-1)){				for(var c=0;c<sum;c++){oSubLi[c].className='';};				a=0;				oSubLi[a].className="active";				interval = setInterval(setValLeft(a),time);				timeout = setTimeout(autoGlide,delay);			}else{				a++;				oSubLi[a].className="active";				interval = setInterval(setValRight(a),time);					timeout = setTimeout(autoGlide,delay);			}		}			if(auto){timeout = setTimeout(autoGlide,delay);};		for(var i=0;i<sum;i++){				oSubLi[i].onmouseover = (function(i){				return function(){					for(var c=0;c<sum;c++){oSubLi[c].className='';};					clearTimeout(timeout);					clearInterval(interval);					oSubLi[i].className="active";					if(Math.abs(parseInt($id(oSlider).style[point]))>[(sSingleSize * i)]){						interval = setInterval(setValLeft(i),time);						this.onmouseout=function(){if(auto){timeout = setTimeout(autoGlide,delay);};};					}else if(Math.abs(parseInt($id(oSlider).style[point]))<[(sSingleSize * i)]){							interval = setInterval(setValRight(i),time);						this.onmouseout=function(){if(auto){timeout = setTimeout(autoGlide,delay);};};					}				}			})(i);					}	};};glide.layerGlide(true,'icon_num','show_pic',988,2,0.1,'left');function doubleSelect(ele){	if(ele.value!=""){		window.open(ele.value);	}}</script>
     <!--主体-->
     <div class="minnavbox">
      <div class="minnavboxleft">
       <div class="tujdbox">
        <div class="tujdbox01">
         <div class="tujdbox01tit">
          <span>综合新闻</span>
          <i><a href="http://test22.zhongdianyun.com//zhxw/10010-1.html" target="_blank">[更多]</a></i>
         </div>
         <div class="tujdboxlisy">
          <ul> 
           <li><b class="spas01">&middot;</b><span class="spas02"><a href="http://test22.zhongdianyun.com/zhxw/000000004e2b51d3014eb475987e0001.html" title="美国圣何塞州立大学Robert Bornstein教授访问灾害天气国家重点实验室" target="_blank">美国圣何塞州立大学Robert Bo</a></span><i class="spas03">2015-07-22</i></li> 
           <li><b class="spas01">&middot;</b><span class="spas02"><a href="http://test22.zhongdianyun.com/zhxw/000000004e2b51d3014e628a42700000.html" title="美国宾夕法尼亚州立大学张福青教授来灾害天气国家重点实验室进行学术交流" target="_blank">美国宾夕法尼亚州立大学张福青教授来灾</a></span><i class="spas03">2015-07-06</i></li> 
           <li><b class="spas01">&middot;</b><span class="spas02"><a href="http://test22.zhongdianyun.com/zhxw/ff8080814cda292f014d6b026c9d0004.html" title="灾害天气国家重点实验室组织参观铁军纪念馆" target="_blank">灾害天气国家重点实验室组织参观铁军纪</a></span><i class="spas03">2015-05-19</i></li> 
           <li><b class="spas01">&middot;</b><span class="spas02"><a href="http://test22.zhongdianyun.com/zhxw/ff8080814cda292f014ce43ddfef0001.html" title="灾害天气国家重点实验室召开2015年汛期气象服务工作动员会" target="_blank">灾害天气国家重点实验室召开2015年</a></span><i class="spas03">2015-04-23</i></li> 
           <li><b class="spas01">&middot;</b><span class="spas02"><a href="http://test22.zhongdianyun.com/zhxw/ff8080814cda292f014ce452e10b0003.html" title="谢邵成博士来灾害天气国家重点实验室开展学术交流" target="_blank">谢邵成博士来灾害天气国家重点实验室开</a></span><i class="spas03">2015-04-23</i></li> 
          </ul>
         </div>
        </div>
        <div class="tujdbox01" style=" float:right;">
         <div class="tujdbox01tit">
          <span>科研动态</span>
          <i><a href="http://test22.zhongdianyun.com//kydt/10011-1.html" target="_blank">[更多]</a></i>
         </div>
         <div class="tujdboxlisy">
          <ul> 
           <li><b class="spas01">&middot;</b><span class="spas02"><a href="http://test22.zhongdianyun.com/kydt/ff8080814c92030b014cb1ef3ba20000.html" title="第三次青藏高原大气科学试验2015年度工作会议召开" target="_blank">第三次青藏高原大气科学试验2015年</a></span><i class="spas03">2015-04-13</i></li> 
           <li><b class="spas01">&middot;</b><span class="spas02"><a href="http://test22.zhongdianyun.com/kydt/ff8080814951158a01495b080b30006f.html" title="跟踪重大试验和典型灾害天气 实验室举办多期学术沙龙" target="_blank">跟踪重大试验和典型灾害天气 实验室举</a></span><i class="spas03">2014-10-29</i></li> 
           <li><b class="spas01">&middot;</b><span class="spas02"><a href="http://test22.zhongdianyun.com/kydt/ff8080814951158a01495ad44325004d.html" title="灾害天气国家重点实验室举办多期学术沙龙活跃学术氛围" target="_blank">灾害天气国家重点实验室举办多期学术沙</a></span><i class="spas03">2014-10-29</i></li> 
           <li><b class="spas01">&middot;</b><span class="spas02"><a href="http://test22.zhongdianyun.com/kydt/ff8080814951158a01495ac738030048.html" title="美国NCAR黄向宇博士来灾害天气国家重点实验室进行学术交流" target="_blank">美国NCAR黄向宇博士来灾害天气国家</a></span><i class="spas03">2014-10-29</i></li> 
           <li><b class="spas01">&middot;</b><span class="spas02"><a href="http://test22.zhongdianyun.com/kydt/ff8080814951158a01495ac62d4f0047.html" title="美国阿拉斯加大学张向东教授来灾害天气国家重点实验室进行学术交流" target="_blank">美国阿拉斯加大学张向东教授来灾害天气</a></span><i class="spas03">2014-10-29</i></li> 
          </ul>
         </div>
        </div>
       </div>
       <div class="tujdbox02">
        <div class="tujdbox02tit">
         <span>科学试验</span>
         <i><a href="http://test22.zhongdianyun.com//kxcb/100070002-1.html" target="_blank">[更多]</a></i>
        </div>
        <div class="tujdboxtou">
         <ul> 
          <li> <b class="spas01"><a href="http://test22.zhongdianyun.com/kxcb/ff80808149a457ae0149a83764500005.html" target="_blank">
          		<img src="${ctx}/siteResources/lasw//resources/images/show/20141030/i104922025d388.jpg" width="215" height="151" /></a></b> <span class="spas02"><a href="http://test22.zhongdianyun.com/kxcb/ff80808149a457ae0149a83764500005.html" title="华南季风降水试验（SCMREX计划）" target="_blank">华南季风降水试验（SCMR...</a></span> <span class="spas03"> SCMREX计划是我国气象部门针对我国华南季风强降水，尤其是突发性暴雨灾害亟待解决的科学问题而提出的国...<i><a href="http://test22.zhongdianyun.com/kxcb/ff80808149a457ae0149a83764500005.html" target="_blank">[详细]</a></i></span> </li> 
          <li> <b class="spas01"><a href="http://test22.zhongdianyun.com/kxcb/ff80808149a457ae0149a8372ca30004.html" target="_blank">
          		<img src="${ctx}/siteResources/lasw//resources/images/show/20141030/i110349747d13f.jpg" width="215" height="151" /></a></b> <span class="spas02"><a href="http://test22.zhongdianyun.com/kxcb/ff80808149a457ae0149a8372ca30004.html" title="第三次青藏高原大气科学试验（TIPEX-III）" target="_blank">第三次青藏高原大气科学试验...</a></span> <span class="spas03">2013年，在中国气象局、国家自然科学基金委员会、中国科学院共同推动下，第三次青藏高原大气科学试验全面开始...<i><a href="http://test22.zhongdianyun.com/kxcb/ff80808149a457ae0149a8372ca30004.html" target="_blank">[详细]</a></i></span> </li> 
          <li style=" margin:0;"> <b class="spas01"><a href="http://test22.zhongdianyun.com/kxcb/ff80808149a457ae0149a8378dc50006.html" target="_blank">
          		<img src="${ctx}/siteResources/lasw//resources/images/show/20141030/i1104155684292.jpg" width="215" height="151" /></a></b> <span class="spas02"><a href="http://test22.zhongdianyun.com/kxcb/ff80808149a457ae0149a8378dc50006.html" title="广州野外雷电试验" target="_blank">广州野外雷电试验</a></span> <span class="spas03">广州野外雷电试验开展人工引雷试验、雷电物理特征综合观测试验、闪电定位系统试验、雷电预警技术开发试验、雷电防...<i><a href="http://test22.zhongdianyun.com/kxcb/ff80808149a457ae0149a8378dc50006.html" target="_blank">[详细]</a></i></span> </li> 
         </ul>
        </div>
        <div class="tujdnews"> 
         <span class="spanso1"><a href="" target="_blank"><img src="${ctx}/siteResources/lasw//resources/images/show/20141028/i112752629c2e0.jpg" width="352" height="80" /></a></span> 
         <span class="spanso2"><a href="" target="_blank"><img src="${ctx}/siteResources/lasw//resources/images/show/20141028/i1128084589f1d.jpg" width="352" height="80" /></a></span> 
        </div>
       </div>
       <div class="tujdbox03">
        <div class="tujdbox02tit">
         <span>科学基地建设</span>
         <i><a href="http://test22.zhongdianyun.com//kxcb/100070003-1.html" target="_blank">[更多]</a></i>
        </div>
        <div class="tujdboxlisy03"> 
         <li> <b class="spas01"><a href="http://test22.zhongdianyun.com/kxcb/4028818d490c1b6401490db02adc0008.html" target="_blank"><img src="${ctx}/siteResources/lasw//resources/images/show/20141030/i1125258922b74.jpg" width="95" height="71" /></a></b> <span class="spas02"><a href="http://test22.zhongdianyun.com/kxcb/4028818d490c1b6401490db02adc0008.html" title="西藏那曲综合观测基地" target="_blank">西藏那曲综合观测基地</a></span> <span class="spas03"> 以那曲地区气象局气象观测场为中心，与周边安多、聂荣、班戈、比如、佳黎县气象局气象观测场和中科院BJ实验基地共同构成。目前已建成边界层观测网，GPS水...<a href="http://test22.zhongdianyun.com/kxcb/4028818d490c1b6401490db02adc0008.html" target="_blank">[详细]</a></span> </li> 
         <li> <b class="spas01"><a href="http://test22.zhongdianyun.com/kxcb/ff8080814951158a01495f26ffd200a2.html" target="_blank"><img src="${ctx}/siteResources/lasw//resources/images/show/20141030/i11434914743ce.jpg" width="95" height="71" /></a></b> <span class="spas02"><a href="http://test22.zhongdianyun.com/kxcb/ff8080814951158a01495f26ffd200a2.html" title="华南中尺度观测与应用试验基地" target="_blank">华南中尺度观测与应用试验基地</a></span> <span class="spas03"> 为了解决制约我国暴雨、台风等灾害天气研究的中尺度资料缺乏这一关键问题，实验室在2004年我国南方建立了以广东、湖北、安徽和上海三省 一市及其周边地区...<a href="http://test22.zhongdianyun.com/kxcb/ff8080814951158a01495f26ffd200a2.html" target="_blank">[详细]</a></span> </li> 
         <li> <b class="spas01"><a href="http://test22.zhongdianyun.com/kxcb/4028818d490c1b6401490c8cc6c00001.html" target="_blank"><img src="${ctx}/siteResources/lasw//resources/images/show/20141030/i1142001074f33.jpg" width="95" height="71" /></a></b> <span class="spas02"><a href="http://test22.zhongdianyun.com/kxcb/4028818d490c1b6401490c8cc6c00001.html" title="华东（长三角）中尺度观测与应用试验基地" target="_blank">华东（长三角）中尺度观测与应用试验基地</a></span> <span class="spas03">为了解决制约我国暴雨、台风等灾害天气研究的中尺度资料缺乏这一关键问题，实验室在2004年我国南方建立了以广东、湖北、安徽和上海三省一市及其周边地区组成的四个...<a href="http://test22.zhongdianyun.com/kxcb/4028818d490c1b6401490c8cc6c00001.html" target="_blank">[详细]</a></span> </li> 
         <li> <b class="spas01"><a href="http://test22.zhongdianyun.com/kxcb/ff8080814951158a01495f284be700a3.html" target="_blank"><img src="${ctx}/siteResources/lasw//resources/images/show/20141030/i114509951fd95.jpg" width="95" height="71" /></a></b> <span class="spas02"><a href="http://test22.zhongdianyun.com/kxcb/ff8080814951158a01495f284be700a3.html" title="华中中尺度观测与应用试验基地" target="_blank">华中中尺度观测与应用试验基地</a></span> <span class="spas03"> 为了解决制约我国暴雨、台风等灾害天气研究的中尺度资料缺乏这一关键问题，实验室在2004年我国南方建立了以广东、湖北、安徽和上海三省 一市及其周边地区组成的...<a href="http://test22.zhongdianyun.com/kxcb/ff8080814951158a01495f284be700a3.html" target="_blank">[详细]</a></span> </li> 
        </div>
       </div>
       <div class="minnavlmusd">
        <div class="tujdbox02tit">
         <span>友情连接</span>
        </div>
        <div class="minnavlmu">
         <select name="" class="imnput1" onchange="doubleSelect(this);"> <option value="">——国内气象部门——</option> <option value="http://www.nmc.gov.cn/">国家气象中心</option> <option value="http://www.nsmc.cma.gov.cn/NSMC/Home/Index.html">国家卫星气象中心</option> <option value="http://ncc.cma.gov.cn/cn/">国家气候中心</option> <option value="http://www.nmic.gov.cn/web/index.htm">国家气象信息中心</option> <option value="http://www.moc.cma.gov.cn/home">中国气象局气象探测中心</option> <option value="http://pmsc.cma.gov.cn/">中国气象局公共气象服务中心</option> <option value="http://www.cams.cma.gov.cn/">中国气象科学研究院</option> <option value="http://cmatc.cma.gov.cn/www/res/index/index.shtm">气象干部培训学院</option> <option value=" http://www.zgqxb.com.cn/">中国气象报社（新气象）</option> <option value="http://www.cmp.cma.gov.cn/">气象出版社</option> <option value="http://www.cms1924.org/">中国气象学会</option> <option value="http://www.cnhyc.com/">中国华云技术开发公司</option> <option value="http://www.tvhf.com/">华风传媒集团</option> <option value="http://www.cmtip.com/">中国气象科技产业园网站</option> </select>
         <select name="" class="imnput2" onchange="doubleSelect(this);"> <option value="">——相关专业网站——</option> <option value="http://www.lasg.ac.cn/">LASG网站</option> <option value="http://www.lapc.ac.cn/">LAPC网站</option> <option value="http://www.nuist.edu.cn/newindex/">南京信息工程大学</option> <option value="http://www.cuit.edu.cn/">成都信息工程学院</option> <option value="http://www.atmos.pku.edu.cn/index.action">北京大学大气科学系</option> <option value=" http://www.iap.cas.cn/">中国科学院大气物理研究所 </option> </select>
        </div>
       </div>
      </div>
      <div class="minnavboxright">
       <!--1-->
       <div class="rigtujdbox01">
        <div class="rigtujdbox01tit">
         <span>通知公告</span>
         <i><a href="http://test22.zhongdianyun.com//tzgg/10012-1.html" target="_blank">[更多]</a></i>
        </div>
        <div class="rigtujdboxlisy">
         <ul> 
          <li><b class="spas01">&middot;</b><span class="spas02"><a href="http://test22.zhongdianyun.com/tzgg/000000004e2b51d3014eb47c53310002.html" title="院深化科技体制改革启动会议于7月23日在信息中心四楼多功能厅召开" target="_blank">院深化科技体制改革启动会议于7月23...</a></span></li> 
          <li><b class="spas01">&middot;</b><span class="spas02"><a href="http://test22.zhongdianyun.com/tzgg/ff8080814b21fd41014bd935ce4d0003.html" title="2015年春节放假安排" target="_blank">2015年春节放假安排</a></span></li> 
          <li><b class="spas01">&middot;</b><span class="spas02"><a href="http://test22.zhongdianyun.com/tzgg/ff80808149ccac7a0149d03b4ca9000f.html" title="灾害天气国家重点实验室 关于请各团队提交2014年度总结素材的通知" target="_blank">灾害天气国家重点实验室 关于请各团队...</a></span></li> 
          <li><b class="spas01">&middot;</b><span class="spas02"><a href="http://test22.zhongdianyun.com/tzgg/ff8080814974fbd8014978c1dff40002.html" title="11月5日上午9：00在901会议室陈飞教授作学术报告，请积极参加" target="_blank">11月5日上午9：00在901会议室...</a></span></li> 
          <li><b class="spas01">&middot;</b><span class="spas02"><a href="http://test22.zhongdianyun.com/tzgg/ff8080814951158a01495e9d4f97008e.html" title="关于10月31日实验室党支部工会联合活动的通知" target="_blank">关于10月31日实验室党支部工会联合...</a></span></li> 
         </ul>
        </div>
       </div>
       <!--2-->
       <div class="rigtujdbox01" style=" height:200px;">
        <div class="rigtujdbox01tit">
         <span>内部登陆窗口</span>
        </div>
        <div class="minnavlmubox">
         <div class="sleif1">
          <span class="spans">用户名：</span>
          <input class="inputs" name="" id="username" type="text" />
         </div>
         <div class="sleif1">
          <span class="spans">密&nbsp;&nbsp;码：</span>
          <input class="inputs" name="" id="password" type="password" onfocus="setFlag('login');" />
         </div>
         <div class="slei2">
          <input name="remembername" type="checkbox" value="" />
          <span>记住密码</span>
         </div>
         <div class="slei3">
          <img src="${ctx}/resource/images/index_37.jpg" onclick="fuserlogin();" />
         </div>
        </div>
       </div>
       <!--3-->
       <div class="rigtujdbox01" style=" height:160px;">
        <div class="rigtujdbox01tit">
         <span>关于实验室</span>
         <i><a href="http://test22.zhongdianyun.com//gysys/10003-1.html" target="_blank">[更多]</a></i>
        </div>
        <div class="gysyshi">
         <div class="gysyshi01">
          <span class="tex01"><a href="http://test22.zhongdianyun.com//gysys/100030002-1.html">领导班子</a></span>
          <i>|</i>
          <span class="tex02"><a href="http://test22.zhongdianyun.com//gysys/100030003-1.html" target="_blank">顾问委员会</a></span>
         </div>
         <div class="gysyshi01">
          <span class="tex01"><a href="http://test22.zhongdianyun.com//gysys/100030005-1.html">成员介绍</a></span>
          <i>|</i>
          <span class="tex02"><a href="http://test22.zhongdianyun.com//gysys/100030004-1.html" target="_blank">学术委员会</a></span>
         </div>
         <div class="gysyshi01">
          <span class="tex01"><a href="http://test22.zhongdianyun.com//gysys/100030007-1.html">规章制度</a></span>
          <i>|</i>
          <span class="tex02"><a href="http://test22.zhongdianyun.com//gysys/100030006-1.html" target="_blank">发展大事记</a></span>
         </div>
        </div>
       </div>
       <!--4-->
       <div class="rigtujdbox01" style="height:220px;">
        <div class="rigtujdbox01tit">
         <span>专家特刊</span>
         <i><a href="http://test22.zhongdianyun.com//gysys/100030005-1.html" target="_blank">[更多]</a></i>
        </div>
        <div class="gysyshi"> 
         <div class="gysytekan"> 
          <b><a href="http://test22.zhongdianyun.com/gysys/1000300050007-1.html" target="_blank">周秀骥</a></b> 
          <span> 周秀骥是我国现代大气物理学创建人之一。创建和发展了我国云雾物... </span> 
         </div> 
         <div class="gysytekan"> 
          <b><a href="http://test22.zhongdianyun.com/gysys/1000300050008-1.html" target="_blank">陈联寿</a></b> 
          <span> 1957年毕业于南京大学气象学系。同年分配到中央气象科学研究... </span> 
         </div> 
        </div>
       </div>
       <!--5-->
       <div class="minnavbbiaoq">
        <a href="#"><img src="${ctx}/resource/images/index_54.jpg" width="260" height="50" /></a>
        <a href="#"><img src="${ctx}/resource/images/index_56.jpg" width="260" height="50" /></a> 
        <a href="#"><img src="${ctx}/resource/images/index_58.jpg" width="260" height="50" /></a> 
        <a href="http://test22.zhongdianyun.com/xzzq/100180001-1.html"><img src="${ctx}/resource/images/index_60.jpg" width="260" height="50" /> </a> 
       </div>
       <div class="rigtujdbox01" style="height:140px;">
        <div class="rigtujdbox01tit">
         <span>科学传播</span>
         <i><a href="http://test22.zhongdianyun.com/kxcb/100070001-1.html" target="_blank">[更多]</a></i>
        </div>
        <div class="rigtujdboxlisy" style=" height:auto;">
         <ul> 
          <li><b class="spas01">&middot;</b><span class="spas02"><a href="http://test22.zhongdianyun.com/kxcb/ff8080814951158a01495fd4970b00b0.html" target="_blank" title="灾害天气监测及预报技术研究">灾害天气监测及预报技术研究</a></span></li> 
          <li><b class="spas01">&middot;</b><span class="spas02"><a href="http://test22.zhongdianyun.com/kxcb/ff8080814951158a01495fd33f3500af.html" target="_blank" title="天气雷达在灾害天气监测中的应用">天气雷达在灾害天气监测中的应用</a></span></li> 
         </ul>
        </div>
       </div>
      </div>
     </div>
     <!--底部-->
	<%@ include file="foot.jsp"%> 
    </div>
   </div>
  </div> 	 
</body>
</html>
