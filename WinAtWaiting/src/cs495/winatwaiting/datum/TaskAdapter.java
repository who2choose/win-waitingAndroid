package cs495.winatwaiting.datum;

import java.util.List;

import cs495.winatwaiting.R;
import cs495.winatwaiting.activities.TaskActivity;
import cs495.winatwaiting.activities.ViewTaskActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TaskAdapter extends ArrayAdapter<Task> {

	public TaskAdapter(Context ctx, int resourceId, List<Task> objects) {
		super(ctx, resourceId, objects);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;

		if (convertView == null) {
			convertView = (RelativeLayout) LayoutInflater.from(getContext())
					.inflate(R.layout.activity_task_listview_item, parent, false);
			holder = new ViewHolder();
			holder.priority = (TextView) convertView
					.findViewById(R.id.view_item_textview_task_priority);
			holder.name = (TextView) convertView
					.findViewById(R.id.view_item_textview_task_name);
			holder.description = (TextView) convertView
					.findViewById(R.id.view_item_textview_task_description);
			holder.duration = (TextView) convertView
					.findViewById(R.id.view_item_textview_task_duration);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		final Task task = (Task) getItem(position);
		final String name = task.name;
		final String description = task.description;
		final String duration = task.duration;
		final String priority = task.priority;
		holder.name.setText(name);
		holder.description.setText(description);
		holder.duration.setText(duration);
		holder.priority.setText(priority);
		convertView.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Bundle extras = new Bundle();
				extras.putString(TaskActivity.NAME_FIELD, name);
				extras.putString(TaskActivity.DESCRIPTION_FIELD, description);
				extras.putString(TaskActivity.DURATION_FIELD, duration);
				extras.putString(TaskActivity.PRIORITY_FIELD, priority);
				Intent viewTaskActivity = new Intent(getContext(), ViewTaskActivity.class);
				viewTaskActivity.putExtras(extras);
				getContext().startActivity(viewTaskActivity);
			}
			
		});

		return convertView;
	}

	static class ViewHolder {
		TextView name;
		TextView description;
		TextView duration;
		TextView priority;

	}
}