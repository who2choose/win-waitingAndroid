package cs495.winatwaiting.activities;

import cs495.winatwaiting.R;
import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class CreateTaskActivity extends ActionBarActivity {
	
	public static final String NAME_FIELD = "cs495.winatwaiting.CreateTaskActivity.NAME";
	public static final String PRIORITY_FIELD = "cs495.winatwaiting.CreateTaskActivity.PRIORITY";
	public static final String DURATION_FIELD = "cs495.winatwaiting.CreateTaskActivity.DURATION";
	public static final String PRIVATE_FIELD = "cs495.winatwaiting.CreateTaskActivity.PRIVATE";
	public static final String DESCRIPTION_FIELD = "cs495.winatwaiting.CreateTaskActivity.DESCRIPTION";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_tasks);
		setupToolBar();
		((TextView) this.findViewById(R.id.create_tasks_item_priority_value))
				.setText("1");
		((TextView) this.findViewById(R.id.create_tasks_item_duration_value))
				.setText("1");
	}

	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		((EditText) this.findViewById(R.id.create_tasks_item_name))
				.setText(savedInstanceState.getString(NAME_FIELD));
		((TextView) this.findViewById(R.id.create_tasks_item_priority_value))
				.setText(String.valueOf(savedInstanceState.getInt(PRIORITY_FIELD)));
		((TextView) this.findViewById(R.id.create_tasks_item_duration_value))
				.setText(String.valueOf(savedInstanceState.getInt(DURATION_FIELD)));
		((CheckBox) this.findViewById(R.id.create_tasks_item_privacy_checkbox))
				.setChecked(savedInstanceState.getBoolean(PRIVATE_FIELD));
		((EditText) this
				.findViewById(R.id.create_tasks_item_additional_information))
				.setText(savedInstanceState.getString(DESCRIPTION_FIELD));
	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		savedInstanceState.putString(NAME_FIELD, ((EditText) this
				.findViewById(R.id.create_tasks_item_name)).getText()
				.toString());
		savedInstanceState.putInt(PRIORITY_FIELD, Integer.parseInt(((TextView) this
				.findViewById(R.id.create_tasks_item_priority_value)).getText()
				.toString()));
		savedInstanceState.putInt(DURATION_FIELD, Integer.parseInt(((TextView) this
				.findViewById(R.id.create_tasks_item_duration_value)).getText()
				.toString()));
		savedInstanceState.putBoolean(PRIVATE_FIELD, ((CheckBox) this
				.findViewById(R.id.create_tasks_item_privacy_checkbox))
				.isChecked());
		savedInstanceState.putString(DESCRIPTION_FIELD, ((EditText) this
				.findViewById(R.id.create_tasks_item_additional_information))
				.getText().toString());
		super.onSaveInstanceState(savedInstanceState);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.create_task, menu);
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
		setSupportActionBar(((Toolbar) findViewById(R.id.action_bar_toolbar)));
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

	public void onPriorityClicked(View view) {
		// TODO: make this use a dialog
		TextView priorityValueTextView = ((TextView) this
				.findViewById(R.id.create_tasks_item_priority_value));
		priorityValueTextView.setText(String.valueOf(Integer
				.parseInt(priorityValueTextView.getText().toString()) + 1));
	}

	public void onDurationClicked(View view) {
		// TODO: make this use a dialog
		TextView durationValueTextView = (TextView) this
				.findViewById(R.id.create_tasks_item_duration_value);
		durationValueTextView.setText(String.valueOf(Integer
				.parseInt(durationValueTextView.getText().toString()) + 1));
	}

	public void onPrivacyClicked(View view) {
		CheckBox privacyCheckbox = (CheckBox) this
				.findViewById(R.id.create_tasks_item_privacy_checkbox);
		if (privacyCheckbox.isChecked()) {
			privacyCheckbox.setChecked(false);
		} else {
			privacyCheckbox.setChecked(true);
		}

	}

}
