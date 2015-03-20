package cs495.winatwaiting;

import cs495.winatwaiting.activities.*;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.annotation.SuppressLint;
import android.support.v4.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setupToolBar();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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

	public void setupToolBar() {
		setSupportActionBar((Toolbar) findViewById(R.id.action_bar_toolbar));
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			buildForLollipop();
		}
	}

	public void activityChangePrimer(View view) {
		switch (view.getId()) {
		case R.id.button_view_tasks:
			// add any necessary extras/synthesize back stack here
			startActivity(new Intent(this, TaskActivity.class));
			break;
		case R.id.button_create_tasks:
			// add any necessary extras/synthesize back stack here
			TaskStackBuilder
					.create(this)
					.addNextIntentWithParentStack(
							new Intent(this, TaskActivity.class))
					.addNextIntent(new Intent(this, CreateTaskActivity.class))
					.startActivities();
			break;
		case R.id.button_todo:
			// add any necessary extras/synthesize back stack here
			startActivity(new Intent(this, ToDoActivity.class));
			break;
		case R.id.button_social:
			break;
		case R.id.button_book:
			// add any necessary extras/synthesize back stack here
			startActivity(new Intent(this, BookActivity.class));
			break;
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
