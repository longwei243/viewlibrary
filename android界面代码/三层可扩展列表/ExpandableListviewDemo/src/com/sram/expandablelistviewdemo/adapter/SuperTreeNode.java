package com.sram.expandablelistviewdemo.adapter;

import java.util.ArrayList;
import java.util.List;
/**
 * 3级结构节点
 * @author LongWei
 *
 */
public class SuperTreeNode {

	private String grandfather;
	private List<TreeNode> father = new ArrayList<TreeNode>();
	
	public String getGrandfather() {
		return grandfather;
	}
	public void setGrandfather(String grandfather) {
		this.grandfather = grandfather;
	}
	public List<TreeNode> getFather() {
		return father;
	}
	public void setFather(List<TreeNode> father) {
		this.father = father;
	}
}
