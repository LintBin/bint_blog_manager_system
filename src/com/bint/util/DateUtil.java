package com.bint.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public static String getDateStr(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(date);
		return dateStr;
	}
}
