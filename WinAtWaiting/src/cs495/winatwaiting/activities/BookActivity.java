package cs495.winatwaiting.activities;

import cs495.winatwaiting.R;
import cs495.winatwaiting.datum.BookActivityObject;
import cs495.winatwaiting.datum.DrawerItemCustomAdapter;
import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

public class BookActivity extends ActionBarActivity {

	private String[] mNavigationDrawerItemTitles;
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_book);
		setupToolBar();
		
		mNavigationDrawerItemTitles= getResources().getStringArray(R.array.navigation_drawer_items_array);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.book_activity_drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.book_activity_left_drawer);
		
		BookActivityObject[] drawerItem = new BookActivityObject[mNavigationDrawerItemTitles.length];
		
		for (int i = 0; i < mNavigationDrawerItemTitles.length; i++) {
			drawerItem[i] = new BookActivityObject(mNavigationDrawerItemTitles[i]);
		}
		
		DrawerItemCustomAdapter adapter = new DrawerItemCustomAdapter(this, R.layout.activity_book_listview_item_row, drawerItem);
		mDrawerList.setAdapter(adapter);
		
		mDrawerList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				selectItem(position);
			}
		});
		
		((TextView) findViewById(R.id.book_activity_textview_link)).setMovementMethod(LinkMovementMethod.getInstance());
	}
	
	private void selectItem(int position) {
	    int y = 0;
	    switch (position) {
	    case 0:
	    	y = findViewById(R.id.book_activity_textview_chapter1).getTop();
	        break;
	    case 1:
	    	y = findViewById(R.id.book_activity_textview_chapter1sup1).getTop();
	        break;
	    case 2:
	    	y = findViewById(R.id.book_activity_textview_chapter1sup2).getTop();
	        break;
	    case 3:
	    	y = findViewById(R.id.book_activity_textview_chapter1sup3).getTop();
	        break;
	    case 4:
	    	y = findViewById(R.id.book_activity_textview_chapter1sup4).getTop();
	        break;
	    default:
	    	y = findViewById(R.id.book_activity_textview_ending).getTop();
	        break;
	    }
	    ((ScrollView) findViewById(R.id.activity_book_scrollview)).scrollTo(0, y);
	    setItemNotChecked(position);
	    mDrawerLayout.closeDrawer(mDrawerList);
	}
	
	private void setItemNotChecked(int pos){
		mDrawerList.setItemChecked(pos, false);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.book, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void setupToolBar(){
		Toolbar actionBarToolbar = (Toolbar) findViewById(R.id.action_bar_toolbar);
		setSupportActionBar(actionBarToolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
			buildForLollipop();
		}
	}
	
	@SuppressLint("InlinedApi")
	public void buildForLollipop(){
		Window window = getWindow();
		window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
		window.setStatusBarColor(getResources().getColor(R.color.primary_color_dark));
	}
	
}
