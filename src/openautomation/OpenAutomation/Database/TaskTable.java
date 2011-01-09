package openautomation.OpenAutomation.Database;

import openautomation.OpenAutomation.Task;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;


public class TaskTable {
	
	private Context context;
	private SQLiteDatabase db;

	public TaskTable(Context context) {
		this.context = context;
		OpenHelper openHelper = new OpenHelper(this.context);
		this.db = openHelper.getWritableDatabase();
	}

	public List<Task> getAllTasks() {
		List<Task> list = new ArrayList<Task>();
		
		Cursor cursor = this.db.query(OpenHelper.TABLE_NAME, new String[] { "id", "name", "description" },
			null, null, null, null, null);
		
		if (cursor.moveToFirst()) {
			do {
				Task task = new Task();
				task.id = cursor.getInt(0);
				task.name = cursor.getString(1);
				task.description = cursor.getString(2);
				list.add(task);
			} while (cursor.moveToNext());
		}
		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}
		return list;
	}
	
	private class OpenHelper extends DatabaseOpenHelper {
		private static final String TABLE_NAME = "tasks";
		
		OpenHelper(Context context) {
			super(context);
		}
	
		@Override
	    public void onCreate(SQLiteDatabase db) {
	    	String createSql = 
	    		"CREATE TABLE " + TABLE_NAME + " (id integer primary key autoincrement, "
	    		+ "name TEXT, "
	    		+ "description TEXT);";
	        db.execSQL(createSql);
	    }
	
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
			onCreate(db);
		}
	}
}
