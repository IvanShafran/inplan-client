package com.fivt.inplan.client.utils;

public class StringUtils {
	private StringUtils() {
		
	}
	
	public static String getNotNullString(String string) {
		return string == null ? "" : string;
	}
}
