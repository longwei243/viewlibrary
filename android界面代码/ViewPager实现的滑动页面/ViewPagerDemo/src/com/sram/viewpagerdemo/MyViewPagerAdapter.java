package com.sram.viewpagerdemo;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

public class MyViewPagerAdapter extends PagerAdapter {
	
	List<View> list;
	
	public MyViewPagerAdapter(List<View> list) {
		this.list = list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0 == arg1;
	}
	
	@Override  
    public void destroyItem(View view, int position, Object object)                       //Ïú»ÙItem  
    {  
        ((ViewPager) view).removeView(list.get(position));  
    }  
      
    @Override  
    public Object instantiateItem(View view, int position)                                //ÊµÀý»¯Item  
    {  
        ((ViewPager) view).addView(list.get(position), 0);  
          
        return list.get(position);  
    }  

}
