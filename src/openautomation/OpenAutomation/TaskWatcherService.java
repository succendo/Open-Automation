package openautomation.OpenAutomation;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import openautomation.OpenAutomation.Database.TaskTable;
import java.util.List;
import java.util.Iterator;
import openautomation.OpenAutomation.Triggers.Time;

public class TaskWatcherService extends Service {
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	@Override
	public void onCreate() {
		Logger.Debug(this, "onCreate");
	}

	@Override
	public void onDestroy() {
		Logger.Debug(this, "onDestroy");
	}
	
	@Override
	public void onStart(Intent intent, int startid) {
		Logger.Debug(this, "onStart: " + startid);
		
		Time timeTrigger = new Time();
		List<Task> allTasks = new TaskTable(this).getAllTasks();
		
		Iterator<Task> i = allTasks.iterator();
		while (i.hasNext()) {
			//loop through all tasks and see if they are triggered
			if (timeTrigger.isTriggered(i.next())) {
			}
		}
	}
}
