package com.ironiacorp.dts.unit;

public interface Time extends Unit
{
	public static final int MICROSECOND = 1;
	
	public static final int SECOND = 1000;
	
	public static final int MINUTE = SECOND * 60;
	
	public static final int HOUR = MINUTE * 60;
	
	public static final int DAY = HOUR * 24;
	
	public static final int WEEK = DAY * 7;
}
