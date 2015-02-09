package cs495.winatwaiting.fragments;

import cs495.winatwaiting.R;
import cs495.winatwaiting.World;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class HomeFragment extends Fragment {

	private static final String[] ACTION_OPTIONS = new String[] { "Tasks", "To-Do", "Social", "Book", "Credits" };
	private ListView actionsView;
	private ArrayAdapter<String> actionsAdapter;
	private World w;
	
	public HomeFragment(World w) {
		this.w = w;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_home, container, false);
		actionsView = (ListView) view.findViewById(R.id.home_listview);
		actionsAdapter = new ArrayAdapter<String>(getActivity(), R.layout.fragment_item, ACTION_OPTIONS);
		actionsView.setAdapter(actionsAdapter);
		actionsView.setOnItemClickListener(ActionListener);
		actionsAdapter.notifyDataSetChanged();
		return view;
	}

	private OnItemClickListener ActionListener = new OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			switch (position) {
			case 0:
				getFragmentManager().beginTransaction().replace(R.id.fragment_container, new TasksViewFragment(w)).commit();
				break;
			case 1:
				getFragmentManager().beginTransaction().replace(R.id.fragment_container, new TodoFragment(w)).commit();
				break;
			case 2:
				//coming soon
				break;
			case 3:
				getFragmentManager().beginTransaction().replace(R.id.fragment_container, new BookFragment()).commit();
				break;
			case 4:
				getFragmentManager().beginTransaction().replace(R.id.fragment_container, new CreditsFragment()).commit();
				break;
			}
		}

	};

}
