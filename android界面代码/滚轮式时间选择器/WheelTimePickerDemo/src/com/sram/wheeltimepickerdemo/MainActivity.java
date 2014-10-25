package com.sram.wheeltimepickerdemo;

import java.util.Calendar;

import com.henan.ui.view.timepick.NumericWheelAdapter;
import com.henan.ui.view.timepick.WheelView;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById(R.id.button1).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				AlertDialog dlg;
				final View DialogView = LayoutInflater.from(MainActivity.this).inflate(
						R.layout.richeng_timepick, null);
				// -- Ϊtimepick������
				final WheelView hours = (WheelView) DialogView
						.findViewById(R.id.richeng_timepick_hour);
				hours.setAdapter(new NumericWheelAdapter(0, 23));
				hours.setLabel("hours");
				hours.setCyclic(true);

				final WheelView mins = (WheelView) DialogView
						.findViewById(R.id.richeng_timepick_mins);
				mins.setAdapter(new NumericWheelAdapter(0, 59, "%02d"));
				mins.setLabel("mins");
				mins.setCyclic(true);
				
				// -- ���õ�ǰʱ��
				Calendar c = Calendar.getInstance();
				int curHours = c.get(Calendar.HOUR_OF_DAY);
				int curMinutes = c.get(Calendar.MINUTE);
				hours.setCurrentItem(curHours);
				mins.setCurrentItem(curMinutes);
				
				dlg = new AlertDialog.Builder(MainActivity.this)
				.setTitle("��ѡ��")
				.setView(DialogView)
				.setPositiveButton("ȷ  ��",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								int hour = hours.getCurrentItem();
								int min = mins.getCurrentItem();
								// �жϿ�ʼʱ���Ƿ�С�ڻ��ߵ��ڽ���ʱ��
							System.out.println("time:"+hour+",mins:"+min);
								
							}
						}).setNegativeButton("ȡ  ��", // ���á�ȡ������ť
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int whichButton) {

							}
						}).create();
		dlg.show();// ��ʾ
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
