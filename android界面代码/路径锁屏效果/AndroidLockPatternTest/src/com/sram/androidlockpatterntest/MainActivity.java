package com.sram.androidlockpatterntest;

import group.pals.android.lib.ui.lockpattern.LockPatternActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private static final int REQ_CREATE_PATTERN = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Intent intent = new Intent(LockPatternActivity.ACTION_CREATE_PATTERN, null,
				MainActivity.this, LockPatternActivity.class);
		startActivityForResult(intent, REQ_CREATE_PATTERN);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	        Intent data) {
	    switch (requestCode) {
	    case REQ_CREATE_PATTERN: {
	        if (resultCode == RESULT_OK) {
	            Toast.makeText(getApplicationContext(), "setting is ok!", 100).show();
	        }
	        break;
	    }// REQ_CREATE_PATTERN
	    }
	}

}
