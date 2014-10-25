package com.sram.expandablelistviewdemo.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.sram.expandablelistviewdemo.R;

/**
 * 2层结构可扩展列表适配器
 * @author LongWei
 *
 */
public class TwoExpandableAdapter extends BaseExpandableListAdapter{
	
	private List<TreeNode> treeNodes = new ArrayList<TreeNode>();
	
	private Context context;

	public TwoExpandableAdapter(Context context) {
		this.context = context;
	}

	public List<TreeNode> getTreeNodes() {
		return treeNodes;
	}

	public void setTreeNodes(List<TreeNode> treeNodes) {
		this.treeNodes = treeNodes;
	}

	@Override
	public int getGroupCount() {
		return treeNodes.size();
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		return treeNodes.get(groupPosition).getChilds().size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		return treeNodes.get(groupPosition).getParent();
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return treeNodes.get(groupPosition).getChilds();
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	@Override
	public boolean hasStableIds() {
		return false;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		if(convertView == null) {
			convertView = LayoutInflater.from(context).inflate(R.layout.groupview, null);
		}
		TextView textView = (TextView) convertView.findViewById(R.id.group_text);
		textView.setText(treeNodes.get(groupPosition).getParent().toString());
		return convertView;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		if(convertView == null) {
			convertView = LayoutInflater.from(context).inflate(R.layout.childview, null);
		}
		TextView textView = (TextView)convertView.findViewById(R.id.child_name);
		textView.setText(treeNodes.get(groupPosition).getChilds().get(childPosition).getName());
		return convertView;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}

	
}
