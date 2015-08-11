package com.vish.twitterAnalyst.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CompareFormModel {

	private String tag1;
	private String tag2;
	
	private String DateFormated1;
	private String DateFormated2;
	
	private String time1;
	private String time2;
	
	private Date date1 = new Date();
	private Date date2 = new Date();
	
	
	public String getTag1() {
		return tag1;
	}
	public void setTag1(String tag1) {
		this.tag1 = tag1;
	}
	public String getTag2() {
		return tag2;
	}
	public void setTag2(String tag2) {
		this.tag2 = tag2;
	}
	
	public String getDateFormated1() {
		return DateFormated1;
	}
	public void setDateFormated1(String DateFormated1) {
		this.DateFormated1 = DateFormated1;
	}
	public String getDateFormated2() {
		return DateFormated2;
	}
	public void setDateFormated2(String DateFormated2) {
		this.DateFormated2 = DateFormated2;
	}
	public String getTime1() {
		return time1;
	}
	public void setTime1(String time1) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date1);
		try{
			Date javaDate=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX").parse(time1);
			Calendar cal1 = new GregorianCalendar();
			cal.setTime(javaDate);
			cal.set(Calendar.HOUR_OF_DAY,cal1.get(Calendar.HOUR_OF_DAY));
			cal.set(Calendar.MINUTE,cal1.get(Calendar.MINUTE));
		}catch(Exception e){
			cal.set(Calendar.HOUR_OF_DAY,0);
			cal.set(Calendar.MINUTE,0);
		}

		date1 = cal.getTime();
		this.time1 = time1;
	}
	public String getTime2() {
		return time2;
	}
	public void setTime2(String time2) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date2);
		try{
			Date javaDate=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX").parse(time2);
			Calendar cal1 = new GregorianCalendar();
			cal.setTime(javaDate);
			cal.set(Calendar.HOUR_OF_DAY,cal1.get(Calendar.HOUR_OF_DAY));
			cal.set(Calendar.MINUTE,cal1.get(Calendar.MINUTE));
		}catch(Exception e){
			cal.set(Calendar.HOUR_OF_DAY,0);
			cal.set(Calendar.MINUTE,0);
		}

		date2 = cal.getTime();
		this.time2 = time2;
	}
	
	
	public static void main(String[] args) throws ParseException {
		String strDate = "1969-12-31T21:45:00.000Z";
		Date javaDate=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX").parse(strDate);
		Calendar cal = new GregorianCalendar();
		cal.setTime(javaDate);
		System.out.println(cal.get(Calendar.HOUR_OF_DAY));
		System.out.println(cal.get(Calendar.MINUTE));
		System.out.println(javaDate);
	}
}
