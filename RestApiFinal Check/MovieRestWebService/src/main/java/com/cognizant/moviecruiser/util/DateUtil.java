package com.cognizant.moviecruiser.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static Date convertToDate(String date) {
		Date df = null;
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			df = sf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return df;
	}
}
