// JavaScript Document
/**
 * @name: gelly.imagesZoom.js
 * @created: 2013-11-19
 * @update:  2013-11-19
 * @author: Cpanda yu
 * @describe: 该插件的主要功能是预加载图片和图片缩放
 */

(function($) {
    //start
    $.fn.starplusImagesZoom = function(options) {
        var opts = $.extend({},$.fn.starplusImagesZoom.defaults, options);
        return this.each(function() {
            var $this = $(this);
            var o = $.meta ? $.extend({},opts, $this.data()) : opts;
            $this.each(function(index, element) {
                var boxWidth=$this.parents(".imgParent").width();
                var boxHeight=$this.parents(".imgParent").height();
                var imgSrc = $this.attr("src"); //获取当前图片地址
                var imgObject = new Image(); //创建图片对象
                //初始隐藏图片元素,插入等待图片
                $this.hide();
                insertLoading();
                //图片加载完成触发相关事件
                $(imgObject).load(function(e) {
                    $(".loadingImage").hide();
                    $this.attr("src", this.src);
                    $this.show();
                    if(o.scale==true){
                        autoScaling()
                    }
                    else
                    {
                        singleScale()
                    }
                });
				imgObject.src = imgSrc;
                //加入加载预加载图片
                function insertLoading() {
                    if (o.loadPicUrl != "") {
                        var preloadArea = '<div class="loadingImage"></div>';
                        $this.after(preloadArea);
                    }
                }
                //处理ff下会自动读取缓存图片
                if (imgObject.complete) {
                    if(o.scale==true){
                        autoScaling()
                    }
                    else
                    {
                        singleScale()
                    }
                    return;
                }
                //图片等比例缩放
                function autoScaling() {
                    if ((boxWidth / boxHeight) >= (imgObject.width / imgObject.height)) {
                        //重新设置img的width和height
                        $this.width((boxHeight * imgObject.width) / imgObject.height);
                        $this.height(boxHeight);
                        //让图片居中显示
                        var margin = (boxWidth - $this.width()) / 2;
                        $this.css("margin-left", margin);
                    } else {
                        //重新设置img的width和height
                        $this.width(boxWidth);
                        $this.height((boxWidth * imgObject.height) / imgObject.width);
                        //让图片居中显示
                        var margin = (boxHeight - $this.height()) / 2;
                        $this.css("margin-top", margin);
                    }

                }
                //end function autoScaling

                //图片按宽或高长度缩放
                function singleScale(){
                   if((boxWidth/imgObject.width)>=(boxHeight/imgObject.height)){
                       $this.width(boxWidth)
                    }else{
						$this.height(boxHeight)
                    }
				    /*if(boxWidth>=boxHeight){
                        $this.width(boxWidth)
                    }
                    else
                    {
                        $this.height(boxHeight)
                    }*/
                }
                //end function singleScale


            })

        })
    }
    $.fn.starplusImagesZoom.defaults = {
        scale:true
    };
    //end
})(jQuery)