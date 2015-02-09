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
import android.widget.EditText;
import android.widget.RadioGroup;

public class TasksCreateFragment extends Fragment {
	
	EditText name, location, companions, needs, description;
	RadioGroup time, situation, interruptible;
	int timeNeeded;
	boolean situationn, interruptablee = true;
	Button save;
	private World w;
	
	public TasksCreateFragment(World w) {
		this.w = w;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_createtask, container, false);
		
		name = (EditText) view.findViewById(R.id.edittextName);
		location = (EditText) view.findViewById(R.id.edittextLocation);
		companions = (EditText) view.findViewById(R.id.edittextCompanions);
		needs = (EditText) view.findViewById(R.id.edittextNeeds);
		description = (EditText) view.findViewById(R.id.edittextDescription);
		time = (RadioGroup) view.findViewById(R.id.radioGroupTime);
		situation = (RadioGroup) view.findViewById(R.id.radioGroupSituation);
		interruptible = (RadioGroup) view.findViewById(R.id.radioGroupInterruptible);
		save = (Button) view.findViewById(R.id.saveNewTask);
		
		time.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.radioLT5:
					timeNeeded = 5;
					break;
				case R.id.radioLT10:
					timeNeeded = 10;
					break;
				case R.id.radioLT30:
					timeNeeded = 30;
					break;
				case R.id.radioLT45:
					timeNeeded = 45;
					break;
				case R.id.radioMT1:
					timeNeeded = 60;
					break;
				}
			}
		});
		
		situation.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.radioPrivate:
					situationn = false;
					break;
				case R.id.radioPublic:
					situationn = true;
					break;
				}
			}
		});
		
		interruptible.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.radioYes:
					interruptablee = true;
					break;
				case R.id.radioNo:
					interruptablee = false;
					break;
				}
			}
		});
		
		save.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				World.taskList.add(new Task(name.getText().toString(), //
						timeNeeded, situationn, location.getText().toString(), //
						interruptablee, companions.getText().toString(), //
						needs.getText().toString(), description.getText().toString()));
				World.writeTasks();
				getFragmentManager().beginTransaction().replace(//
						R.id.fragment_container, new TasksViewFragment(w)).commit();
			}
		});
		
		return view;
	}
	
}
