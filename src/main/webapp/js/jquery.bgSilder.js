// JavaScript Document
/**
 * @name: jquery.bgSlider.js
 * @created: 2014-04-17
 * @update:  2014-04-17
 * @author: Cpanda yu
 */
(function($) {
    //start		
    $.fn.bgSlider = function(options) {
        var opts = $.extend({},$.fn.bgSlider.defaults, options);
        return this.each(function() {
            var $this = $(this);
            var o = $.meta ? $.extend({},opts, $this.data()) : opts;
            var wrapBox = $this.parents(".slider-parent"); //slider外框对象
            var sliderBox = $this.find(".slider-box"); //滚动图片外框对象
            var navBox = $this.find(".slider-pagination"); //导航对象
            var navLinks = $("a", navBox); //导航链接集合
            var sliderDds = $("dd", sliderBox);
            //获取插件外框的宽高
            var wrapWidth = wrapBox.width();
            var wrapHeight = wrapBox.height();
            //获取滑动模块数目
            var sliderLength = sliderDds.length;
            var end = sliderLength - 1;
            var cur = 0;
            var timer;
            //设置切换模块元素适屏后的宽高
            $this.width(wrapWidth);
            $this.height(wrapHeight);
            sliderDds.width(wrapWidth);
            sliderDds.height(wrapHeight);
            //设置外框总宽度
            $(sliderBox).width(wrapWidth * sliderLength);
            //插件切换函数
            function animate(dur, index) {
                $(sliderBox).animate({
                    marginLeft: "-" + (index * wrapWidth + "px")
                },
                o.speed * (dur));
            }
            //插件向前滚动函数
            function goPrev() {
                if ($this.is(":not(:animated)")) {
                    dur = 1;
                    if (cur > 0) {
                        cur--;
                    } else {
                        cur = end;
                        dur = cur
                    }
                    $(navLinks).removeClass("current");
                    animate(dur, cur);
                    $(navLinks).eq(cur).addClass("current")
                }
            }
            //插件向后滚动函数
            function goNext() {
                if ($this.is(":not(:animated)")) {
                    dur = 1;
                    if (cur < end) {
                        cur++;
                    } else {
                        cur = 0;
                        dur = end
                    }
                    $(navLinks).removeClass("current");
                    animate(dur, cur);
                    $(navLinks).eq(cur).addClass("current")
                }
            }

            $(o.prevId).click(function() {
                startAuto();
                goPrev();
            });

            $(o.nextId).click(function() {
                startAuto();
                goNext();
            });


            //插件开始自动切换函数
            function startAuto() {
                if (o.auto == true) {
                    if (timer != null) {
                        clearInterval(timer);
                    }
                    timer = setInterval(goNext, o.pause);
                }
            }
            //插件停止自动切换函数
            function stopAuto() {}
            //点击控制器事件
            $(navLinks).each(function(i) {
                $(this).click(function() {
                    startAuto();
                    $(navLinks).removeClass("current");
                    $(this).addClass("current");
                    if ($this.is(":not(:animated)")) {
                        var dur = Math.abs(cur - i);
                        //alert("cur:"+cur+"i:"+i+"dur:"+dur);
                        animate(dur, i);
                        cur = i
                    } //if
                }) //click
            }) //each
            startAuto();
        })
    };

    $.fn.bgSlider.defaults = {
        navigation: true,
        title: false,
        prevId: "#prevBtn",
        nextId: "#nextBtn",
        auto: true,
        speed: 500,
        pause: 10000
    };
    //end
})(jQuery)