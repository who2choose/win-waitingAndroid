package cs495.winatwaiting.activities;


import com.google.samples.apps.iosched.ui.widget.SlidingTabLayout;

import cs495.winatwaiting.R;
import cs495.winatwaiting.datum.CustomPagerAdapter;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

public class TaskActivity extends ActionBarActivity {
	
	public static final String NAME_FIELD = "cs495.winatwaiting.TaskActivity.NAME";
	public static final String PRIORITY_FIELD = "cs495.winatwaiting.TaskActivity.PRIORITY";
	public static final String DURATION_FIELD = "cs495.winatwaiting.TaskActivity.DURATION";
	public static final String DESCRIPTION_FIELD = "cs495.winatwaiting.TaskActivity.DESCRIPTION";
	//TODO: add a save state for the currently active fragment
	public static final String SAVED_FRAGMENT_NAME = "cs495.winatwaiting.TaskActivity.FRAGMENT";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_task);
		setupToolBar();
		
	    ViewPager mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(new CustomPagerAdapter(getSupportFragmentManager(), this));
		
		SlidingTabLayout mTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs);
        mTabLayout.setDistributeEvenly(true);
        mTabLayout.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
			
			@Override
			public int getIndicatorColor(int position) {
				// TODO Auto-generated method stub
				return getResources().getColor(R.color.primary_color_dark);
			}
		});
        mTabLayout.setViewPager(mViewPager);

	}
	
	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		
	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		
		super.onSaveInstanceState(savedInstanceState);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.task, menu);
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
		} else if (id == R.id.create_task) {
			// add any necessary extras/synthesize back stack here
			startActivity(new Intent(this, CreateTaskActivity.class));
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void setupToolBar() {
		setSupportActionBar((Toolbar) findViewById(R.id.action_bar_toolbar));
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			buildForLollipop();
		}
	}

	@SuppressLint("InlinedApi")
	public void buildForLollipop() {
		Window window = getWindow();
		window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
		window.setStatusBarColor(getResources().getColor(
				R.color.primary_color_dark));
	}

}
