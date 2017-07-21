package org.wq.ssm.web.lasw;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wq.ssm.entity.lasw.LaswMenu;
import org.wq.ssm.entity.lasw.LaswNewsContent;
import org.wq.ssm.entity.lasw.LaswNewsTitle;
import org.wq.ssm.service.lasw.LaswMenuService;
import org.wq.ssm.service.lasw.LaswNewsContentService;
import org.wq.ssm.service.lasw.LaswNewsTitleService;

/**
 * @author wangqiang
 *联系邮箱:417297506@qq.com
 * 2017年7月6日 下午2:56:13
 * 类的说明:菜单栏目的controller
 */
@Controller
@RequestMapping("/lasw")//模块  url:/模块/资源/{id}/细分....
public class LaswMenuController {
	@SuppressWarnings("unused")
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private LaswMenuService  laswMenuService;
	@Autowired
	private LaswNewsContentService newsContentService;
	@Autowired
	private LaswNewsTitleService laswNewsTitleService;
	
	//进入首页
	@RequestMapping(value="/index", method = RequestMethod.GET)
	public String index(){
		return "index";
	}
	
	
	//进入非首页的其他页面
	@RequestMapping(value="/{topMenuId}/main/{leftMenuId}/left/{titleId}/detail", method = RequestMethod.GET)
	public String main(Model model,@PathVariable("topMenuId")Long topMenuId,@PathVariable("leftMenuId")Long leftMenuId,@PathVariable("titleId")int titleId){
		model.addAttribute("topMenuId", topMenuId);
		model.addAttribute("leftMenuId", leftMenuId);
		model.addAttribute("titleId", titleId);
		return "/lasw/main";
	}
	
	
	//加载页面头部菜单信息  如果这里并发很高的话  可以考虑使用缓存
	@RequestMapping(value="/menu/top", method = RequestMethod.GET)
	@ResponseBody
	public List<LaswMenu>  top(){
		List<LaswMenu>  list=laswMenuService.queryParentFirst();
		return list;
	}
	
	
	//加载页面左边二级菜单 如果这里并发很高的话  也可以考虑使用缓存
	@RequestMapping(value="/{menuId}/left", method = RequestMethod.GET)
	@ResponseBody
	public LaswMenu left(@PathVariable("menuId")Long menuid){
		LaswMenu laswMenu=laswMenuService.queryById(menuid);
		return laswMenu;
	}
	
	//加载页面右边
	@RequestMapping(value="/{menuId}/right", method = RequestMethod.GET)
	public String right(Model model,@PathVariable("menuId")Long menuid){
		/*LaswMenu laswMenu=laswMenuService.queryById(menuid);
		model.addAttribute("laswMenu", laswMenu);*/
		return "/lasw/right";
	}

	
	//加载页面右边详情页
	@RequestMapping(value="/right/{leftMenuId}/detail", method = RequestMethod.GET)
	public String detail(Model model,@PathVariable("leftMenuId")Long leftMenuId){
		LaswMenu laswMenu=laswMenuService.queryById(leftMenuId);
		List<LaswNewsTitle> titleList= laswNewsTitleService.queryByMenuId(leftMenuId);
		if(titleList!=null && titleList.size()==1){
			//只有一个新闻标题直接显示
			return "redirect:/lasw/right/"+titleList.get(0).getId()+"/news";
		}
		model.addAttribute("laswMenu", laswMenu);
		model.addAttribute("titleList", titleList);
		return "/lasw/detail";
	}
	
	
	@RequestMapping(value="/right/{titleId}/news", method = RequestMethod.GET)
	public  String  showNews(Model model,@PathVariable("titleId")int titleId){
		LaswNewsContent laswNewsContent =  newsContentService.queryByTitleIdWithTitleWithAtts(titleId);
		model.addAttribute("laswNewsContent", laswNewsContent);
		return "lasw/news";
	}
	
	
	
	 
	@RequestMapping(value="/{menuid}/secondPage", method = RequestMethod.GET)
	public String SecondPage(Model model,@PathVariable("menuid")Long menuid){
		LaswMenu laswMenu=laswMenuService.queryById(menuid);
		model.addAttribute("laswMenu", laswMenu);
		return "/lasw/secondPage";
	}
 
	
}
