package br.mc.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	
	public static Date getDateWithDaysDiference(int days) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, days);
		return cal.getTime();
	}
}
