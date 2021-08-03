package com.main.Utility;

import org.apache.log4j.Logger;
import com.main.Helper.*;

import com.aventstack.extentreports.model.Log;

public class LoggerUtil {
	public static Logger Log = Logger.getLogger(Log.class.getName());

	public static void info(String msg) {
		Log.info(msg);
	}

	public static void warn(String msg) {
		Log.warn(msg);
	}

	public static void debug(String msg) {
		Log.debug(msg);
	}

	public static void error(String msg) {
		Log.error(msg);
	}

	public static Logger getLogger(Class<WaitHelper> class1) {
		// TODO Auto-generated method stub
		return null;
	}

}
