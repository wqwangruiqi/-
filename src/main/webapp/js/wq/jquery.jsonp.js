/*
 * jquery extend json
 * 
 * author hitec_wenty
 * 
 * 2014年12月01日11:13:19
 */
__CreateJSPath = function (js) {
    var scripts = document.getElementsByTagName("script");
    var path = "";
    for (var i = 0, l = scripts.length; i < l; i++) {
        var src = scripts[i].src;
        if (src.indexOf(js) != -1) {
            var ss = src.split(js);
            path = ss[0];
            break;
        }
    }
    var href = location.href;
    href = href.split("#")[0];
    href = href.split("?")[0];
    var ss = href.split("/");
    ss.length = ss.length - 1;
    href = ss.join("/");
    if (path.indexOf("https:") == -1 && path.indexOf("http:") == -1 && path.indexOf("file:") == -1 && path.indexOf("\/") != 0) {
        path = href + "/" + path;
    }
    return path;
};
//获取脚本库URL路径
var bootPATH = __CreateJSPath("js/core/jquery.jsonp.js");
jQuery.extend({
	jsoncallback:function(json){return json;},
	jsonToString : function(obj){   
		var THIS = this;
		switch(typeof(obj)){   
		case 'string':   
			return '"' + obj.replace(/(["\\])/g, '\\$1') + '"';   
		case 'array':   
			return '[' + obj.map(THIS.jsonToString).join(',') + ']';   
		case 'object':
			if(obj instanceof Array){   
				var strArr = [];   
				var len = obj.length;   
				for(var i=0; i<len; i++){   
					strArr.push(THIS.jsonToString(obj[i]));   
				}   
				return '[' + strArr.join(',') + ']';   
			}else if(obj==null){   
				return 'null';   

			}else{   
				var string = [];   
				for (var property in obj) string.push(THIS.jsonToString(property) + ':' + THIS.jsonToString(obj[property]));   
				return '{' + string.join(',') + '}';   
			}   
		case 'number':   
			return obj;   
		case false:   
			return obj;   
		}   
	},
	//remote json
	/**
	 * r3url : rrrs服务请求地址,如果从服务器
	 * rurl : 远程url,
	 * rparams: 远程调用参数(json)
	 * callback: 回调函数(结果)
	 */
	JSONP : function(method, rurl, rparams, callback, errorcall,debug, params)
	{
		var r3url = method == "SC" ? "sc-get.action":(method=="POST"?"rj-post.action":"rj-get.action");
		r3url = bootPATH+r3url;
		var rquestParams = {
				debug :debug?debug:0,
						rurl: encodeURI(rurl),
						dataid: rurl,
						rparams: encodeURI(jQuery.jsonToString(rparams))
					};
		if(params){
			jQuery.extend(rquestParams, params);
		}
		return $.ajax({
			type: "GET",
			url: r3url,
			data: rquestParams,
			dataType: "jsonp",
			jsonp: 'jsoncallback',
			success: function(json){
				callback(json);
			},
			error: function(XMLHttpRequest, textStatus, errorThrown)
			{
				jQuery.holdReady(false);
				if(errorcall && jQuery.isFunction(errorcall))
					errorcall(XMLHttpRequest, textStatus, errorThrown);
			}
		});
	},
	getJSONP : function(rurl, rparams, callback, errorcall,debug)
	{
		return jQuery.JSONP("GET", rurl, rparams, callback, errorcall,debug)
	},
	postJSONP : function(rurl, rparams, callback, errorcall,debug)
	{
		return jQuery.JSONP("POST", rurl, rparams, callback, errorcall,debug)
	},
	scJSONP : function(dataid, rparams, p1, p2, p3)
	{
		var params, callback, errorcall;
		if(p1 && jQuery.isPlainObject(p1)){
			params = p1;
			callback = p2;
			errorcall = p3;
		}
		else if(jQuery.isFunction(p1)){
			callback = p1;
			errorcall = p2;
			params = false;
		}
		return jQuery.JSONP("SC", dataid, rparams, callback, errorcall,false, params)
	}
});
