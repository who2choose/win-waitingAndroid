package cs495.winatwaiting.fragments;

import cs495.winatwaiting.R;
import cs495.winatwaiting.World;
import cs495.winatwaiting.task.Task;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TasksViewFragment extends Fragment {

	private World w;

	public TasksViewFragment(World w) {
		this.w = w;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_taskview, container, false);
		LinearLayout tasklayout = (LinearLayout) view.findViewById(R.id.fragment_taskview_layout);
		
		for (final Task t : World.taskList) {
			View taskview = inflater.inflate(R.layout.taskfragment, null);
			TextView name = (TextView) taskview.findViewById(R.id.fragmentName);
			name.setText(t.getName());
			TextView time = (TextView) taskview.findViewById(R.id.fragmentTime);
			time.setText(t.getTimeNeeded());
			TextView situation = (TextView) taskview.findViewById(R.id.fragmentSituation);
			situation.setText(t.getSituation());
			TextView location = (TextView) taskview.findViewById(R.id.fragmentLocation);
			location.setText(t.getLocation());
			TextView interuptable = (TextView) taskview.findViewById(R.id.fragmentInterruptable);
			interuptable.setText(t.isInterruptable());
			TextView people = (TextView) taskview.findViewById(R.id.fragmentPeople);
			people.setText(t.getPeople());
			TextView needs = (TextView) taskview.findViewById(R.id.fragmentNeeds);
			needs.setText(t.getNeeds());
			TextView description = (TextView) taskview.findViewById(R.id.fragmentDescription);
			description.setText(t.getDescription());
			
			Button delete = (Button) taskview.findViewById(R.id.delete_button);
			delete.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					World.remove(t);
					World.writeTasks();
					getFragmentManager().beginTransaction().replace(R.id.fragment_container, new TasksViewFragment(w)).commit();
				}
			});

			tasklayout.addView(taskview);
		}
		
		Button b = (Button) view.findViewById(R.id.changeToCreateTaskFragment);
		b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				getFragmentManager().beginTransaction().replace(R.id.fragment_container, new TasksCreateFragment(w)).commit();
			}
		});

		return view;
	}
	
}
