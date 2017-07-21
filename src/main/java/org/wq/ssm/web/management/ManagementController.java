package org.wq.ssm.web.management;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wq.ssm.dto.lasw.LaswNews;
import org.wq.ssm.dto.seckill.Resout;
import org.wq.ssm.entity.lasw.LaswMenu;
import org.wq.ssm.entity.lasw.LaswNewsContent;
import org.wq.ssm.entity.lasw.LaswNewsTitle;
import org.wq.ssm.enums.LaswNewsEnum;
import org.wq.ssm.exception.management.LaswException;
import org.wq.ssm.service.lasw.LaswMenuService;
import org.wq.ssm.service.lasw.LaswNewsContentService;
import org.wq.ssm.service.lasw.LaswNewsTitleService;

import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/management")
public class ManagementController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private LaswMenuService laswMenuService;
	@Autowired
	private LaswNewsContentService newsContentService;
	@Autowired
	private LaswNewsTitleService laswNewsTitleService;

	// beginTime, endTime;//开始时间和结束时间
	// menuIdF, menuIdS;//菜单第一级选择值 和 第二级选择值
	// 新闻列表页面
	@GetMapping(value = "/news/list")
	public String newsList(Model model, PageInfo<LaswNewsTitle> page,
			@RequestParam(value = "menuIdF", required = false, defaultValue = "0") Long menuIdF,
			@RequestParam(value = "menuIdS", required = false, defaultValue = "0") Long menuIdS,
			@RequestParam(value = "newsTitleName", required = false) String newsTitleName,
			@RequestParam(value = "beginTime", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date beginTime,
			@RequestParam(value = "endTime", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endTime) {
		
		List<LaswMenu> menuListF = laswMenuService.queryParentFirst();
		LaswMenu laswMenu = new LaswMenu();
		if (menuIdF > 0) {
			// 菜单栏有传值过来
			laswMenu = laswMenuService.queryById(menuIdF);
		} else {
			// 菜单栏无值传递过来 默认第一个
			/*
			 * laswMenu=laswMenuService.queryById(menuListF.get(1).getId());
			 * menuIdS=laswMenu.getChild().get(0).getId();
			 */
		}

		page = laswNewsTitleService.queryPage(menuIdF, menuIdS, newsTitleName, beginTime, endTime, page);
		model.addAttribute("menuListF", menuListF);
		model.addAttribute("laswMenu", laswMenu);
		model.addAttribute("page", page);
		model.addAttribute("menuIdF", menuIdF);
		model.addAttribute("menuIdS", menuIdS);
		model.addAttribute("beginTime", beginTime);
		model.addAttribute("endTime", endTime);
		model.addAttribute("newsTitleName", newsTitleName);
		return "/management/newsList";
	}

	// 新闻添加、修改页面
	@RequestMapping(value = "/news/{titleId}/edit", method = RequestMethod.GET)
	public String newsEdit(Model model, @PathVariable("titleId") int titleId) {
		List<LaswMenu> menuListF = laswMenuService.queryParentFirst();
		LaswMenu laswMenu = new LaswMenu();
		LaswNewsContent laswNewsContent = new LaswNewsContent();
		if (titleId > 0) {
			// 表示修改
			laswNewsContent = newsContentService.queryByTitleIdWithTitleWithAtts(titleId);
			laswMenu = laswMenuService.queryById(laswNewsContent.getLaswNewsTitle().getLaswmenuId());
		} else {
			// 表示新增 默认选择第二个
			laswMenu = laswMenuService.queryById(menuListF.get(1).getId());
		}

		model.addAttribute("menuListF", menuListF);
		model.addAttribute("laswMenu", laswMenu);
		model.addAttribute("laswNewsContent", laswNewsContent);
		LaswNewsTitle laswNewsTitle = new LaswNewsTitle();
		model.addAttribute("laswNewsTitle", laswNewsTitle);
		return "/management/newsAdd";
	}

	// @RequestParam 获取表单提交的参数
	// @PathVariable获取url路径里面的参数值
	@SuppressWarnings("rawtypes")
	@PostMapping(value = "/post/news")
	@ResponseBody
	public Resout insert(@Valid LaswNewsTitle laswNewsTitle, BindingResult bindingResultT,
			@Valid LaswNewsContent laswNewsContent, BindingResult bindingResultC,
			@RequestParam(value = "titleId", required = false, defaultValue = "0") int titleId,
			@RequestParam(value = "contentId", required = false, defaultValue = "0") int contentId) {
		Resout<LaswNews> resout = null;

		if (bindingResultT.hasErrors()) {
			LaswException laswException = new LaswException();
			laswException.setStateInfo(bindingResultT.getFieldError().getDefaultMessage());
			return new Resout<LaswException>(false, laswException);
		}
		if (bindingResultC.hasErrors()) {
			LaswException laswException = new LaswException();
			laswException.setStateInfo(bindingResultC.getFieldError().getDefaultMessage());
			return new Resout<LaswException>(false, laswException);
		}
		try {
			// 保存title 表单提交 已有值 添加时间 + titleName + menuId +istop(对象默认为0)
			// 保存content 表单提交 已有值 content
			if (titleId == 0 && contentId == 0) {
				// 添加
				boolean insertFlag;
				insertFlag = laswNewsTitleService.insert(laswNewsTitle, laswNewsContent, null);
				if (insertFlag) {
					return resout = new Resout<LaswNews>(true, new LaswNews(LaswNewsEnum.SUCCES));
				}
			} else if (titleId > 0 && contentId > 0) {
				// 修改
				laswNewsTitle.setId(titleId);
				laswNewsContent.setId(contentId);
				boolean updateFlag = laswNewsTitleService.update(laswNewsTitle, laswNewsContent);
				if (updateFlag) {
					return resout = new Resout<LaswNews>(true, new LaswNews(LaswNewsEnum.SUCCES));
				}
			}
		} catch (Exception e) {
			LaswException exception=null;
			 if(e instanceof LaswException){
				 exception=(LaswException) e;
			 }else{
				 exception=new LaswException(LaswNewsEnum.UNKONW_ERROR);
			 }
			 logger.error(e.getMessage(),e);
			 throw exception;
		}
		return resout;
	} 
	
	public Resout<LaswNews> insert2(@Valid LaswNewsTitle laswNewsTitle, BindingResult bindingResultT,
			@Valid LaswNewsContent laswNewsContent, BindingResult bindingResultC) {
		Resout<LaswNews> resout = null;
		if (bindingResultT.hasErrors()) {
			System.out.println(bindingResultT.getFieldError().getDefaultMessage());
			return resout = new Resout<LaswNews>(false,
					new LaswNews(bindingResultT.getFieldError().getDefaultMessage()));
		}
		if (bindingResultC.hasErrors()) {
			System.out.println(bindingResultC.getFieldError().getDefaultMessage());
			return resout = new Resout<LaswNews>(false,
					new LaswNews(bindingResultC.getFieldError().getDefaultMessage()));
		}
		try {
			// 保存title 表单提交 已有值 添加时间 + titleName + menuId +istop(对象默认为0)
			// 保存content 表单提交 已有值 content
			if (laswNewsTitle.getId() == 0 && laswNewsContent.getId() == 0) {
				// 添加
				boolean insertFlag = laswNewsTitleService.insert(laswNewsTitle, laswNewsContent, null);
				if (insertFlag) {
					return resout = new Resout<LaswNews>(true, new LaswNews(LaswNewsEnum.SUCCES));
				} else {
					return resout = new Resout<LaswNews>(false, new LaswNews(LaswNewsEnum.FAIL));
				}
			} else if (laswNewsTitle.getId() > 0 && laswNewsContent.getId() > 0) {
				// 修改
				boolean updateFlag = laswNewsTitleService.update(laswNewsTitle, laswNewsContent);
				if (updateFlag) {
					return resout = new Resout<LaswNews>(true, new LaswNews(LaswNewsEnum.SUCCES));
				} else {
					return resout = new Resout<LaswNews>(false, new LaswNews(LaswNewsEnum.FAIL));
				}
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return resout = new Resout<LaswNews>(false, new LaswNews(LaswNewsEnum.FAIL));
		}
		return resout;
	}

	@DeleteMapping(value = "/delete/news/{titleId}")
	@ResponseBody
	public Resout<LaswNews> deleteNewsByid(@PathVariable int titleId) {
		Resout<LaswNews> resout = null;
		int dnumber = laswNewsTitleService.delete(titleId);
		if (dnumber > 0) {
			// "删除成功"
			resout = new Resout<LaswNews>(true, new LaswNews(LaswNewsEnum.SUCCES));
		} else {
			// 删除失败
			resout = new Resout<LaswNews>(false, new LaswNews(LaswNewsEnum.FAIL));
		}
		return resout;
	}

}
