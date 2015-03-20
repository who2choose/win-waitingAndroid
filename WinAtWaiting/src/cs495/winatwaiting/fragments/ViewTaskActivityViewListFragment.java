package cs495.winatwaiting.fragments;

import java.util.ArrayList;
import java.util.List;

import cs495.winatwaiting.R;
import cs495.winatwaiting.datum.Task;
import cs495.winatwaiting.datum.TaskAdapter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class ViewTaskActivityViewListFragment extends Fragment {

	private ListView listViewTask;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(
				R.layout.activity_task_fragment_view_list, container, false);
		// TODO: connect to db and get the values to add to the list view
		List<Task> listTask = new ArrayList<Task>();
		populateListTask(listTask);

		listViewTask = (ListView) rootView.findViewById(R.id.view_listview);
		listViewTask.setAdapter(new TaskAdapter(getActivity(),
				R.layout.activity_task_listview_item, listTask));
		return rootView;
	}

	private void populateListTask(List<Task> listTask) {
		listTask.add(new Task("Do research on Android L", "30", "1",
				"Check out the changes to the API introduced in level 22."));
		listTask.add(new Task("Jumping Jacks", "1", "7",
				"Do jumping jacks for about a minute during commercials"));
		listTask.add(new Task("Knee Bends", "1", "5",
				"Knee bends are objectibely better than jumping jacks in every way, I swear it."));
		listTask.add(new Task("Grade homework", "60", "1",
				"Grade final projects for CS222 Section 2"));
		listTask.add(new Task("Call Mom", "15", "2",
				"Don't forget to tell her that you love her!"));
		listTask.add(new Task("Check the news", "5", "3",
				"Make sure to only get news from Fox :^)"));
		listTask.add(new Task("Develop new memes", "10", "1",
				"These memes have to be really dank. The dankest memes. Ever. :^)"));
		listTask.add(new Task("Play Flappy Bird", "5", "9",
				"Demolish that old high score."));
		listTask.add(new Task("Filler", "60", "10",
				"I'm fresh out of ideas for fake tasks."));
	}

}
