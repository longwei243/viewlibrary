package com.sram.viewpagerdemo;

import java.util.ArrayList;
import java.util.List;

import com.special.ResideMenu.menu.ResideMenu;
import com.special.ResideMenu.menu.ResideMenuItem;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{

	private ViewPager viewPager;
	private List<View> list = new ArrayList<View>();
	private ResideMenu resideMenu;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		View view1 = LayoutInflater.from(this).inflate(R.layout.lay1, null);
		View view2 = LayoutInflater.from(this).inflate(R.layout.lay2, null);
		View view3 = LayoutInflater.from(this).inflate(R.layout.lay3, null);
		list.add(view1);
		list.add(view2);
		list.add(view3);
		MyViewPagerAdapter adapter = new MyViewPagerAdapter(list);
		
		
		view1.findViewById(R.id.button1).setOnClickListener(this);
		
		viewPager = (ViewPager)findViewById(R.id.viewpager);
		viewPager.setAdapter(adapter);
		
		resideMenu = new ResideMenu(this);
        resideMenu.setBackground(R.drawable.menu_background);
        resideMenu.attachToActivity(this);
        resideMenu.setMenuListener(menuListener);

        // create menu items;
        String titles[] = { "Home", "Profile", "Calendar", "Settings" };
        int icon[] = { R.drawable.icon_home, R.drawable.icon_profile, R.drawable.icon_calendar, R.drawable.icon_settings };

        for (int i = 0; i < titles.length; i++){
            ResideMenuItem item = new ResideMenuItem(this, icon[i], titles[i]);
            item.setOnClickListener(this);
            resideMenu.addMenuItem(item);
        }
		
	}
	
	private ResideMenu.OnMenuListener menuListener = new ResideMenu.OnMenuListener() {
        @Override
        public void openMenu() {
            Toast.makeText(MainActivity.this, "Menu is opened!", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void closeMenu() {
            Toast.makeText(MainActivity.this, "Menu is closed!", Toast.LENGTH_SHORT).show();
        }
    };

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()) {
		case R.id.button1:
			resideMenu.openMenu();
			break;
		default :
			resideMenu.closeMenu();
			break;
		}
		
	}

}
