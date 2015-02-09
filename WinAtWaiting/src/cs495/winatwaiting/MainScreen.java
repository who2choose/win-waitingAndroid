package cs495.winatwaiting;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import cs495.winatwaiting.fragments.HomeFragment;
import cs495.winatwaiting.task.Task;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.WindowManager;

public class MainScreen extends ActionBarActivity {
	
	private HomeFragment home;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainscreen);
		
		World w = new World(this);
		readTasks();
		readTodo();
		home = new HomeFragment(w);
		
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
		
		if (findViewById(R.id.fragment_container) != null && savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, home).commit();
		}
	}
	
	public void pressHome(View v){
		if (!home.isVisible()) {
			getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, home).commit();
		}
	}
	
	public void readTasks() {
		try {
			InputStream inputStream = openFileInput("tasks.txt");

			if (inputStream != null) {
				InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
				String receiveString = "";
				World.taskList.clear();
				while ((receiveString = bufferedReader.readLine()) != null) {
					World.taskList.add(new Task(receiveString));
				}
				inputStream.close();
			}
		} catch(Exception e){}
	}
	
	public void writeTasks() {
		try {
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput("tasks.txt", Context.MODE_PRIVATE));
			for (Task t : World.taskList) {
				outputStreamWriter.write(t.getTask() + "\n");
			}
			outputStreamWriter.close();
		} catch (Exception e) {}
	}
	
	public void readTodo() {
		try {
			InputStream inputStream = openFileInput("todo.txt");

			if (inputStream != null) {
				InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
				String receiveString = "", txt = "";
				while ((receiveString = bufferedReader.readLine()) != null) {
					txt += receiveString + "\n";
				}
				for (int i = 0; i < txt.split("\n").length; i++) {
					World.setTodo(i, txt.split("\n")[i]);
				}
				inputStream.close();
			}
		} catch(Exception e){}
	}
	
	public void writeTodo() {
		try {
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput("todo.txt", Context.MODE_PRIVATE));
			for (String s : World.todoList) {
				outputStreamWriter.write(s+"\n");
			}
			outputStreamWriter.close();
		} catch (Exception e) {}
	}
	
}