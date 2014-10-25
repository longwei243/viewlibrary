package com.sram.expandablelistviewdemo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;
import android.widget.ExpandableListView.OnChildClickListener;

import com.sram.expandablelistviewdemo.adapter.SuperTreeNode;
import com.sram.expandablelistviewdemo.adapter.ThreeExpandableAdapter;
import com.sram.expandablelistviewdemo.adapter.TreeNode;
import com.sram.expandablelistviewdemo.entity.People;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		/*ExpandableListView listView = (ExpandableListView) findViewById(R.id.two_expandableListView);
		TwoExpandableAdapter adapter = new TwoExpandableAdapter(this);
		
		List<TreeNode> treeNodes = new ArrayList<TreeNode>();
		for (int i = 0; i < 5; i++) {
			TreeNode treeNode = new TreeNode();
			treeNode.setParent("群组"+i);
			List<People> peoples = new ArrayList<People>();
			for(int j=0; j<3; j++) {
				People p = new People();
				p.setName("姓名"+j);
				peoples.add(p);
			}
			treeNode.setChilds(peoples);
			treeNodes.add(treeNode);
		}
		adapter.setTreeNodes(treeNodes);
		listView.setGroupIndicator(getResources().getDrawable(R.drawable.expand_selector));
		listView.setAdapter(adapter);*/
		
		ExpandableListView listView = (ExpandableListView) findViewById(R.id.two_expandableListView);
		ThreeExpandableAdapter adapter = new ThreeExpandableAdapter(MainActivity.this);
		List<SuperTreeNode> superNodes = new ArrayList<SuperTreeNode>();
		for (int i = 0; i < 4; i++) {
			SuperTreeNode superTreeNode = new SuperTreeNode();
			superTreeNode.setGrandfather("祖父"+i);
			List<TreeNode> father = new ArrayList<TreeNode>();
			for (int j = 0; j < 4; j++) {
				TreeNode treeNode = new TreeNode();
				treeNode.setParent("父亲"+j);
				List<People> peoples = new ArrayList<People>();
				for(int k=0; k<3; k++) {
					People p = new People();
					p.setName("孩子"+k);
					peoples.add(p);
				}
				treeNode.setChilds(peoples);
				father.add(treeNode);
			}
			superTreeNode.setFather(father);
			superNodes.add(superTreeNode);
		}
		adapter.setSuperNodes(superNodes);
		listView.setGroupIndicator(getResources().getDrawable(R.drawable.expand_selector));
		listView.setAdapter(adapter);
		
	}

	/*OnChildClickListener stvClickEvent = new OnChildClickListener() {

		@Override
		public boolean onChildClick(ExpandableListView parent, View v,
				int groupPosition, int childPosition, long id) {
			// TODO Auto-generated method stub
			String msg = "parent_id = " + groupPosition + " child_id = "
					+ childPosition;
			Toast.makeText(MainActivity.this, msg,
					Toast.LENGTH_SHORT).show();
			return true;
		}
	};*/

}
