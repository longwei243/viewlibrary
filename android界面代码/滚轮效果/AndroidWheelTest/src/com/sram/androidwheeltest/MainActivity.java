package com.sram.androidwheeltest;

import it.sephiroth.android.wheel.view.Wheel;
import it.sephiroth.android.wheel.view.Wheel.OnScrollListener;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Wheel mWheel;
	private TextView textView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		textView = (TextView)findViewById(R.id.text);
		
		mWheel = (Wheel) findViewById( R.id.wheel );
	    mWheel.setOnScrollListener( new OnScrollListener() {

	        @Override
	        public void onScrollStarted( Wheel view, float value, int roundValue ) {
	        	Toast.makeText(getApplicationContext(), "开始滚动", 100).show();
	        }

	        @Override
	        public void onScrollFinished( Wheel view, float value, int roundValue ) {
	        	Toast.makeText(getApplicationContext(), "结束滚动", 100).show();
	        }

	        @Override
	        public void onScroll( Wheel view, float value, int roundValue ) {
//	        	mWheel.setValue(value, false);
	        	textView.setText(roundValue+"");
	        }
	    } );
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
