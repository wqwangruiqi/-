package org.wq.ssm.web.seckill;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.wq.ssm.dto.seckill.Exposer;
import org.wq.ssm.dto.seckill.Resout;
import org.wq.ssm.dto.seckill.SeckillExecution;
import org.wq.ssm.entity.seckill.Seckill;
import org.wq.ssm.enums.SeckillStatEnum;
import org.wq.ssm.exception.seckill.RepeatKillException;
import org.wq.ssm.exception.seckill.SeckillCloseException;
import org.wq.ssm.service.seckill.SeckillService;

/**
 * seckill 的 controller
 * @author wangqiang
 *
 */
@Controller
@RequestMapping("/seckill")//模块  url:/模块/资源/{id}/细分....
public class SeckillController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired()  //SeckillService是接口 因为只有一个实现类 我们这里不需要特别指明   使用@Qualifier("xxxxxx")   可以指定实现类
	private SeckillService seckillService;
	
	
	//列表页
	@RequestMapping(value="/list", method = RequestMethod.GET)
	//注意:  不能写成  @RequestMapping(name="/list", method = RequestMethod.GET)   value="/list"  不能下写成name="/list" 
	//	会报以下错  There is already 'seckillController' bean method public java.lang.String cn.wq.seckill.web.SeckillController.list(org.springframework.ui.Model) mapped
	public String list(Model model){
		//list.jsp +  model = ModelAndView
		//获取列表列
		List<Seckill>  list=seckillService.getSeckillList();
		model.addAttribute("list", list);
		return "/seckill/list";
	}
	
	//详情页
	@RequestMapping(value="/{seckillId}/detail", method = RequestMethod.GET)
	public String detail(@PathVariable("seckillId")Long seckillId ,Model model){
		if(seckillId==null ){
			return "redirect:/seckill/list";//如果seckillId为空 将请求重定向到 /seckill/list默认回到列表页 url地址会变
		}
		Seckill seckill=seckillService.getById(seckillId);
		if(seckill==null ){
			return "forward:/seckill/list";//如果seckillId为空 将请求转发到 /seckill/list默认回到列表页url地址不会变
		}
		model.addAttribute("seckill", seckill);
		return "/seckill/detail";
	}
	
	/**
	 * ajax   返回json
	 * @param seckillId
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(
				value="/{seckillId}/exposer", 
				method = RequestMethod.POST, 
				produces={"application/json;charset=UTF-8"
				})
	@ResponseBody   //springmvc知道这个注解 会帮我们把返回值封装成json
	public Resout<Exposer> exposer(@PathVariable("seckillId") Long seckillId){
		Resout<Exposer> resout=null;
		try {
			Exposer exposer = seckillService.exportSeckillUrl(seckillId);
			resout=new Resout<Exposer>(true, exposer);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			resout=new Resout(false, e);
		}
		 return resout;
	}
	
	
	
	
	//执行秒杀
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(
			value="/{seckillId}/{md5}/execute", 
			method = RequestMethod.POST, 
			produces={"application/json;charset=UTF-8"
			})
	@ResponseBody
	public Resout  execute(@PathVariable("seckillId")Long seckillId,
																						@PathVariable("md5")String md5,
																						@CookieValue(value="killPhone",required=false)Long killPhone){//userPhone是保存在cookie里面的  required=false表示 如果coolie里面没有需要的值 程序不会报错
		//注意 killPhone 定义为long 如果cookie里面存储的是String 前端会报400错误 这个需要注意 
		if(killPhone==null || killPhone==0){
			return new Resout(false, new Exception("未注册"));
		}
		
		Resout<SeckillExecution> resout=null;
		try {
			//SeckillExecution seckillExecution =seckillService.excuteSeckill(seckillId, killPhone, md5);
			SeckillExecution seckillExecution =seckillService.excuteSeckillProcedure(seckillId, killPhone, md5);
			resout=new Resout<SeckillExecution>(true, seckillExecution);
		} catch (RepeatKillException e) {
			SeckillExecution seckillExecution=new SeckillExecution(seckillId, SeckillStatEnum.REPEAT_KILL);
			resout=new Resout<SeckillExecution>(true, seckillExecution);
		} catch (SeckillCloseException e) {
			SeckillExecution seckillExecution=new SeckillExecution(seckillId, SeckillStatEnum.END);
			resout=new Resout<SeckillExecution>(true, seckillExecution);
		} catch (Exception e) {
			SeckillExecution seckillExecution=new SeckillExecution(seckillId, SeckillStatEnum.INNER_ERROR);
			resout=new Resout<SeckillExecution>(true, seckillExecution);
		}
		return resout;
		
	}
	
	//获取服务器时间
	@RequestMapping(
			value="/time/now", 
			method = RequestMethod.GET
			)
	@ResponseBody
	public Resout<Long> time(){
		Date now=new Date();
		return new Resout<Long>(true, now.getTime());
	}
	
	@RequestMapping(value="/gotobaidul1", method = RequestMethod.GET)
	public ModelAndView gotoBaidu1(){
		return  new ModelAndView(new RedirectView("http://www.baidu.com")); 
	}
	
 
	
}
