package openautomation.OpenAutomation;

import openautomation.OpenAutomation.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.view.View;
import android.content.Context;
import android.content.Intent;
import android.app.AlarmManager;
import android.app.PendingIntent;

public class TaskCreateActivity extends Activity implements OnClickListener {
	private Button buttonStart, buttonStop;
	private AlarmManager alarm;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		alarm = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
		alarm.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 10000, getTaskWatcherServicePendingIntent());
		
		buttonStart = (Button) findViewById(R.id.buttonStart);
		buttonStop = (Button) findViewById(R.id.buttonStop);

		buttonStart.setOnClickListener(this);
		buttonStop.setOnClickListener(this);
	}

	public void onClick(View src) {
		switch (src.getId()) {
			case R.id.buttonStart:
				Logger.Debug(this, "onClick: starting service");
				alarm.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 10000, getTaskWatcherServicePendingIntent());
				break;
			case R.id.buttonStop:
				Logger.Debug(this, "onClick: stopping service");
				alarm.cancel(getTaskWatcherServicePendingIntent());
				break;
		}
	}
	
	private PendingIntent getTaskWatcherServicePendingIntent() {
		return PendingIntent.getService(
				this, 
				0,
				new Intent(this, TaskWatcherService.class),
				PendingIntent.FLAG_UPDATE_CURRENT
		);
	}
}