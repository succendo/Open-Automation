package openautomation.OpenAutomation;

import android.util.Log;

public class Logger {
	private static final String LOGTAG = "Open Automation";
	
	public static void Error(Object src, String message) {
		Log.e(LOGTAG, sourceToString(src) + ": " + message);
	}
	
	public static void Warn(Object src, String message) {
		Log.w(LOGTAG, sourceToString(src) + ": " + message);
	}
	
	public static void Info(Object src, String message) {
		Log.i(LOGTAG, sourceToString(src) + ": " + message);
	}
	
	public static void Debug(Object src, String message) {
		Log.d(LOGTAG, sourceToString(src) + ": " + message);
	}
	
	public static void Verbose(Object src, String message) {
		Log.v(LOGTAG, sourceToString(src) + ": " + message);
	}
	
	private static String sourceToString(Object src) {
		String source = src.getClass().getName();
		
		int pos = source.lastIndexOf('.');
		
		return source.substring(pos + 1);
	}
}
