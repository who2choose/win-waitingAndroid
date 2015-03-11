package cs495.winatwaiting;

import cs495.winatwaiting.activities.*;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {
	
	public final static String EXTRA_MESSAGE = "cs495.winatwaiting.MESSAGE";

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
	
	public void setupToolBar(){
		Toolbar actionBarToolbar = (Toolbar) findViewById(R.id.action_bar_toolbar);
		setActionBar(actionBarToolbar);
	}
	
	public void activityChangePrimer(View view){
		switch(view.getId()){
		case R.id.button_view_tasks:
			activityChangeDriver(ViewTasksActivity.class);
			break;
		case R.id.button_create_tasks:
			activityChangeDriver(CreateTasksActivity.class);
			break;
		case R.id.button_todo:
			activityChangeDriver(ToDoActivity.class);
			break;
		case R.id.button_social:
			break;
		case R.id.button_book:
			activityChangeDriver(BookActivity.class);
			break;
		}
	}
	
	public void activityChangeDriver(Class c){
		Intent i = new Intent(this, c);
		startActivity(i);
	}
	
}
