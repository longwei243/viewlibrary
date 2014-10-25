package com.sram.expandablelistviewdemo.adapter;

import java.util.List;

import com.sram.expandablelistviewdemo.entity.People;
/**
 * 2层结构节点
 * @author LongWei
 *
 */
public class TreeNode {

	private String parent;
	private List<People> childs;
	
	public Object getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public List<People> getChilds() {
		return childs;
	}
	public void setChilds(List<People> childs) {
		this.childs = childs;
	}
}
