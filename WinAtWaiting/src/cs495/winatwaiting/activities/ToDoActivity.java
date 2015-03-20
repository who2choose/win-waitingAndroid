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
import android.widget.EditText;

public class ToDoActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_todo);
		setupToolBar();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.todo, menu);
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

	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		((EditText) this.findViewById(R.id.todo_edittext1))
				.setText(savedInstanceState.getString("task1"));
		((EditText) this.findViewById(R.id.todo_edittext2))
				.setText(savedInstanceState.getString("task2"));
		((EditText) this.findViewById(R.id.todo_edittext3))
				.setText(savedInstanceState.getString("task3"));
		((EditText) this.findViewById(R.id.todo_edittext4))
				.setText(savedInstanceState.getString("task4"));
		((EditText) this.findViewById(R.id.todo_edittext5))
				.setText(savedInstanceState.getString("task5"));
	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		savedInstanceState.putString("task1", ((EditText) this
				.findViewById(R.id.todo_edittext1)).getText().toString());
		savedInstanceState.putString("task2", ((EditText) this
				.findViewById(R.id.todo_edittext2)).getText().toString());
		savedInstanceState.putString("task3", ((EditText) this
				.findViewById(R.id.todo_edittext3)).getText().toString());
		savedInstanceState.putString("task4", ((EditText) this
				.findViewById(R.id.todo_edittext4)).getText().toString());
		savedInstanceState.putString("task5", ((EditText) this
				.findViewById(R.id.todo_edittext5)).getText().toString());
		super.onSaveInstanceState(savedInstanceState);
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

	public void onSaveButtonClick(View view) {
		String task1 = ((EditText) this.findViewById(R.id.todo_edittext1))
				.getText().toString();
		String task2 = ((EditText) this.findViewById(R.id.todo_edittext2))
				.getText().toString();
		String task3 = ((EditText) this.findViewById(R.id.todo_edittext3))
				.getText().toString();
		String task4 = ((EditText) this.findViewById(R.id.todo_edittext4))
				.getText().toString();
		String task5 = ((EditText) this.findViewById(R.id.todo_edittext5))
				.getText().toString();
		// TODO: write to the database
		System.out.println(task1 + task2 + task3 + task4 + task5);
	}

}
