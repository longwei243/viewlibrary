package android.view.ext;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.ext.SatelliteMenu.SateliteClickedListener;

public class SatelliteMenuActivity extends Activity {
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        SatelliteMenu menu = (SatelliteMenu) findViewById(R.id.menu);
        
//		  Set from XML, possible to programmatically set        
//        float distance = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 170, getResources().getDisplayMetrics());
//        menu.setSatelliteDistance((int) distance);
//        menu.setExpandDuration(500);
//        menu.setCloseItemsOnClick(false);
//        menu.setTotalSpacingDegree(60);
        
        List<SatelliteMenuItem> items = new ArrayList<SatelliteMenuItem>();
        items.add(new SatelliteMenuItem(6, R.drawable.ic_1));
        items.add(new SatelliteMenuItem(5, R.drawable.ic_3));
        items.add(new SatelliteMenuItem(4, R.drawable.ic_4));
        items.add(new SatelliteMenuItem(3, R.drawable.ic_5));
        items.add(new SatelliteMenuItem(2, R.drawable.ic_6));
        items.add(new SatelliteMenuItem(1, R.drawable.ic_2));
//        items.add(new SatelliteMenuItem(5, R.drawable.sat_item));
        menu.addItems(items);        
        
        menu.setOnItemClickedListener(new SateliteClickedListener() {
			
			public void eventOccured(int id) {
				switch(id) {
				case 1:
					Log.i("sat", "Clicked on " + 1);
					break;
				case 2:
					Log.i("sat", "Clicked on " + 2);
					break;
				case 3:
					Log.i("sat", "Clicked on " + 3);
					break;
				case 4:
					Log.i("sat", "Clicked on " + 4);
					break;
				case 5:
					Log.i("sat", "Clicked on " + 5);
					break;
				case 6:
					Log.i("sat", "Clicked on " + 6);
					break;
				}
//				Log.i("sat", "Clicked on " + id);
			}
		});
    }
}