package com.fivt.inplan.client.utils;

public class Logger {
	
	public static void d(String tag, String msg) {
		System.out.println(System.currentTimeMillis() + " " + tag + ": " + msg);
	}
}
