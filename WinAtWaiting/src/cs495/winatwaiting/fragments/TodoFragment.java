package cs495.winatwaiting.fragments;

import cs495.winatwaiting.R;
import cs495.winatwaiting.World;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView.BufferType;

public class TodoFragment extends Fragment {
	
	private World w;
	
	public TodoFragment(World w) {
		this.w = w;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_todo, container, false);
		
		final EditText et1 = (EditText) view.findViewById(R.id.todo_edittext1);
		et1.setText(World.getTodo(0), BufferType.EDITABLE);
		final EditText et2 = (EditText) view.findViewById(R.id.todo_edittext2);
		et2.setText(World.getTodo(1), BufferType.EDITABLE);
		final EditText et3 = (EditText) view.findViewById(R.id.todo_edittext3);
		et3.setText(World.getTodo(2), BufferType.EDITABLE);
		final EditText et4 = (EditText) view.findViewById(R.id.todo_edittext4);
		et4.setText(World.getTodo(3), BufferType.EDITABLE);
		final EditText et5 = (EditText) view.findViewById(R.id.todo_edittext5);
		et5.setText(World.getTodo(4), BufferType.EDITABLE);
		
		Button b = (Button) view.findViewById(R.id.todo_button);
		b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				World.setTodo(0, et1.getText().toString());
				World.setTodo(1, et2.getText().toString());
				World.setTodo(2, et3.getText().toString());
				World.setTodo(3, et4.getText().toString());
				World.setTodo(4, et5.getText().toString());
				World.writeTodo();
				getFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment(w)).commit();
			}
		});
		
		return view;
	}

}
