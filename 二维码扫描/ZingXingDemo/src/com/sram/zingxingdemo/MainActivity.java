package com.sram.zingxingdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.google.zxing.CaptureActivity;
import com.sram.zingxingdemo.R;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById(R.id.button1).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
				startActivityForResult(intent, 111);
			}
		});
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode == 111 && resultCode == Activity.RESULT_OK) {
			Bundle bundle = data.getExtras();
            String scanResult = bundle.getString("result");
			Toast.makeText(getApplicationContext(), "扫描成功："+scanResult, 100).show();
			System.out.println("扫描结果："+scanResult);
		}
	}
}
