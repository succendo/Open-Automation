package openautomation.OpenAutomation.Database;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

public abstract class DatabaseOpenHelper extends SQLiteOpenHelper {
	protected static final int DATABASE_VERSION = 1;
	protected static final String DATABASE_NAME = "OpenAutomation.db";
    
	DatabaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
