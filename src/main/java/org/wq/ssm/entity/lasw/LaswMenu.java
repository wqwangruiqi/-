package org.wq.ssm.entity.lasw;

import java.util.List;

//菜单对象
public class LaswMenu {
	private Long id;//id
	private Long parentId;//父类id
	private String nameChina;//栏目名(中文)
	private String nameEnglish;//栏目名(英文)
	private String desChina;//说明(中文)
	private String desEnglish;//说明(英文)
	private LaswMenu parent;//父类
	private List<LaswMenu> child;//子类
	private Long orderColumn;//排序列
	private String cssimg;//menu背景class
	private int menuShow;//是否在菜单栏显示该项 
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getNameChina() {
		return nameChina;
	}

	public void setNameChina(String nameChina) {
		this.nameChina = nameChina;
	}

	public String getNameEnglish() {
		return nameEnglish;
	}

	public void setNameEnglish(String nameEnglish) {
		this.nameEnglish = nameEnglish;
	}

	public String getDesChina() {
		return desChina;
	}

	public void setDesChina(String desChina) {
		this.desChina = desChina;
	}

	public String getDesEnglish() {
		return desEnglish;
	}

	public void setDesEnglish(String desEnglish) {
		this.desEnglish = desEnglish;
	}

	public LaswMenu getParent() {
		return parent;
	}

	public void setParent(LaswMenu parent) {
		this.parent = parent;
	}

	public List<LaswMenu> getChild() {
		return child;
	}

	public void setChild(List<LaswMenu> child) {
		this.child = child;
	}

	
	public Long getOrderColumn() {
		return orderColumn;
	}

	public void setOrderColumn(Long orderColumn) {
		this.orderColumn = orderColumn;
	}
	
	public String getCssimg() {
		return cssimg;
	}

	public void setCssimg(String cssimg) {
		this.cssimg = cssimg;
	}

	public int getMenuShow() {
		return menuShow;
	}

	public void setMenuShow(int menuShow) {
		this.menuShow = menuShow;
	}

	

}
