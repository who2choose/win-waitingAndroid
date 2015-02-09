package cs495.winatwaiting;

import java.util.ArrayList;

import cs495.winatwaiting.task.Task;

public class World {

	public static ArrayList<Task> taskList = new ArrayList<Task>();
	private static Task remove = null;
	public static String[] todoList = { " ", " ", " ", " ", " " };
	static MainScreen ms;

	public World(MainScreen mainScreen) {
		ms = mainScreen;
	}

	public static void writeTasks() {
		ms.writeTasks();
	}

	public static void writeTodo() {
		ms.writeTodo();
	}

	public static String getTodo(int i) {
		return todoList[i];
	}

	public static void setTodo(int i, String s) {
		todoList[i] = s;
	}

	public static void remove(Task t) {
		for (Task task : taskList) {
			if (task.equals(t)){
				remove = task;
				break;
			}
		}
		taskList.remove(remove);
		remove = null;
	}
}