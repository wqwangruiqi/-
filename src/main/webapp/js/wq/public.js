$(function(){
	//搜索条件下拉
	$("#all").parent().addClass("cur");
	$(".trigger").hover(function(){
			$(this).children("ul").css("display","block");
		},function(){
			$(this).children("ul").css("display","none");
		});
		$(".trigger ul li").click(function(){
			var content = $(this).children("a").text();
			$(".trigger").children("a").html(content);
			$(this).addClass("cur");
			$(this).siblings("li").removeClass("cur");
	});
	
	//左侧菜单
	$('.sideMenu li').hover(function(){
		$(this).toggleClass('active');
		$(this).find('.subMenu').toggleClass('dn');
	});
	$('.list li p a:last-child').css('border-right-width','0px');
			
	//右侧浮动栏
	$('.rightBar a').hover(function(){
		$(this).find('span').toggleClass('iconText');
		$(this).find('i').toggleClass('dn');
		})
	//回到顶部
	$('#return').hide();
	function x() {
		h = $(window).height(),
		t = $(document).scrollTop(),
		t > h ? $("#return").show() : $("#return").hide()
	}
	$('#return').click(function(){
		//x(),
		//$(document).animate({scrollTop: '0px'},'slow')
		$(document).scrollTop(0);
		})
	$(window).scroll(function() {
		x()
	});
			
})