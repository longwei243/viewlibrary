package com.sram.zoomtextviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        TextView textView = (TextView) this.findViewById(R.id.main_tv);  
        try {  
            textView.setText("文字文字文字文字文" +
            		"字文字文字文字文字文字文字文" +
            		"字文字文字文字文字文字文字文" +
            		"字文字文字文字文字文字文字文" +
            		"字文字文字文字文字文字文字文" +
            		"字文字文字文字文字文字文字文" +
            		"字文字文字文字文字文字文字文" +
            		"字文字文字文字文字文字文字文" +
            		"字文字文字文字文字文字文字文" +
            		"字文字文字文字文字文字文字文" +
            		"字文字文字文字文字文字文字文" +
            		"字文字文字文字文字文字文字文" +
            		"字文字文字文字文字文字文字文字");  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        float zoomScale = 0.5f;// 缩放比例  
        new ZoomTextView(textView, zoomScale);  
	}

	

}
