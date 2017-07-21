$(document).ready(function(e) {
        var fHeight = $('.cy-partThree dl.dl02 dd').height();

        $(".cy-partThree dl.dl02").hover(function() {
            $(".cy-partThree dl.dl02 dd").css('margin-top', -fHeight).removeClass("fn-hide")
        },
        function() {
            $(".cy-partThree dl.dl02 dd").css('margin-top', -fHeight).addClass("fn-hide")
        })

        $("#idx-business .cy-bd dd,#idx-business .cy-bd dt").hover(function() {
            $(this).addClass("dhover")
        },
        function() {
            $(this).removeClass("dhover")
        });
    });