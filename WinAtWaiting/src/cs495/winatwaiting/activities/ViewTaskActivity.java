package cs495.winatwaiting.activities;

import cs495.winatwaiting.R;
import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class ViewTaskActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_task);
		Bundle extras = getIntent().getExtras();
		setupToolBar();
		((TextView) this.findViewById(R.id.view_task_item_name))
				.setText(extras.getString(TaskActivity.NAME_FIELD));
		((TextView) this.findViewById(R.id.view_task_item_duration_value))
				.setText(extras.getString(TaskActivity.DURATION_FIELD));
		((TextView) this.findViewById(R.id.view_task_item_priority_value))
				.setText(extras.getString(TaskActivity.PRIORITY_FIELD));
		((TextView) this.findViewById(R.id.view_task_item_additional_information))
				.setText(extras.getString(TaskActivity.DESCRIPTION_FIELD));
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_task_item, menu);
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
