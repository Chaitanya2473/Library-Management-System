package com.commonUtils;

public class Validate {

	
	public static boolean isEmpty(String value) {
		return value==null|| value.trim().equals("")?true:false;
	}
}
