package com.sram.expandablelistviewdemo.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.TextView;

import com.sram.expandablelistviewdemo.R;
/**
 * 3层结构可扩展列表适配器
 * @author LongWei
 *
 */
public class ThreeExpandableAdapter extends BaseExpandableListAdapter{

	private Context context;
	private OnChildClickListener stvClickEvent;//外部回调函数
	public ThreeExpandableAdapter(Context context) {
		this.context = context;
	}
	public ThreeExpandableAdapter(Context context, OnChildClickListener stvClickEvent) {
		this.context = context;
		this.stvClickEvent = stvClickEvent;
	}

	private List<SuperTreeNode> superNodes = new ArrayList<SuperTreeNode>();
	
	public List<SuperTreeNode> getSuperNodes() {
		return superNodes;
	}

	public void setSuperNodes(List<SuperTreeNode> superNodes) {
		this.superNodes = superNodes;
	}

	@Override
	public int getGroupCount() {
		return superNodes.size();
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		return superNodes.get(groupPosition).getFather().size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		return superNodes.get(groupPosition);
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return superNodes.get(groupPosition).getFather().get(childPosition);
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
		textView.setText(superNodes.get(groupPosition).getGrandfather());
		return convertView;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		View view = LayoutInflater.from(context).inflate(R.layout.expandablelist, null);
		ExpandableListView listView = (ExpandableListView) view.findViewById(R.id.expandableListView);
		TwoExpandableAdapter adapter = new TwoExpandableAdapter(context);
		List<TreeNode> treeNodes = adapter.getTreeNodes();
		TreeNode treeNode = (TreeNode) getChild(groupPosition, childPosition);
		treeNodes.add(treeNode);
		adapter.setTreeNodes(treeNodes);
		listView.setGroupIndicator(context.getResources().getDrawable(R.drawable.expand_selector));
		listView.setAdapter(adapter);
		listView.setOnChildClickListener(new OnChildClickListener() {
			
			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				System.out.println("点击了子节点");
				return false;
			}
		});
		return view;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}

}
