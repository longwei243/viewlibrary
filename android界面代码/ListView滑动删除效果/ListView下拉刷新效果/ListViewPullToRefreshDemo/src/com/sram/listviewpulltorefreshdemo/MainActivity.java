package com.sram.listviewpulltorefreshdemo;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnPullEventListener;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.handmark.pulltorefresh.library.PullToRefreshBase.State;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

public class MainActivity extends Activity {

	private PullToRefreshListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		listView = (PullToRefreshListView)findViewById(R.id.pull_refresh_list);
//		ListView actualListView = listView.getRefreshableView();
		listView.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, new String[]{"aaa", "bbb", "ccc"}));
//		actualListView.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, new String[]{"aaa", "bbb", "ccc"}));
		
		listView.setOnRefreshListener(new OnRefreshListener<ListView>() {

			@Override
			public void onRefresh(PullToRefreshBase<ListView> refreshView) {
				refreshView.getLoadingLayoutProxy().setLastUpdatedLabel("设置上次更新标签内容");
//				refreshView.getLoadingLayoutProxy().setPullLabel("设置下拉时的内容");
//				refreshView.getLoadingLayoutProxy().setRefreshingLabel("设置正在刷新时的内容");
//				refreshView.getLoadingLayoutProxy().setReleaseLabel("设置释放时的内容");
				new GetDataTask().execute();
			}
		});
		
		
	}
	
	private class GetDataTask extends AsyncTask<Void, Void, Void> {

		@Override
		protected void onPostExecute(Void result) {
			listView.onRefreshComplete();
			super.onPostExecute(result);
		}

		@Override
		protected Void doInBackground(Void... params) {
			// Simulates a background job.
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
			}
			return null;
		}

	
	}


}
