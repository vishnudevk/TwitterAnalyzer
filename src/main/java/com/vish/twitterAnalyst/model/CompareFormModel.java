package com.vish.twitterAnalyst.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CompareFormModel {

	private String tag1;
	private String tag2;
	
	private String dateFormated1;
	private String dateFormated2;
	
	private String time1;
	private String time2;
	
	private Date date1 ;
	private Date date2 ;
	
	//date format coming from the calendar picker
	private static String dateFmt = "dd MMMM, yyyy";
	//time format coming from the clock picker
	private static String timeFmt = "yyyy-MM-dd'T'HH:mm:ss.SSSX";
	
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
		return dateFormated1;
	}
	public void setDateFormated1(String DateFormated1) {
		this.dateFormated1 = DateFormated1;
	}
	public String getDateFormated2() {
		return dateFormated2;
	}
	public void setDateFormated2(String DateFormated2) {
		this.dateFormated2 = DateFormated2;
	}
	public String getTime1() {
		return time1;
	}
	public void setTime1(String time1) {
		this.time1 = time1;
	}
	public String getTime2() {
		return time2;
	}
	public void setTime2(String time2) {
		this.time2 = time2;
	}
	
	
	public void parseDates() throws ParseException{
			date1 = getConvertedDate(dateFormated1, time1);
			date2 = getConvertedDate(dateFormated2, time2);
		}
	
	
	private Date getConvertedDate(String date, String time) throws ParseException{
		Calendar cal = new GregorianCalendar();
		cal.setTime(new SimpleDateFormat(dateFmt).parse(date));
		try{
			Date javaDate=new SimpleDateFormat(timeFmt).parse(time);
			Calendar cal1 = new GregorianCalendar();
			cal1.setTime(javaDate);
			cal.set(Calendar.HOUR_OF_DAY,cal1.get(Calendar.HOUR_OF_DAY));
			cal.set(Calendar.MINUTE,cal1.get(Calendar.MINUTE));
		}catch(Exception e){
			cal.set(Calendar.HOUR_OF_DAY,0);
			cal.set(Calendar.MINUTE,0);
		}

		return cal.getTime();
	}
	
	
	public static void main(String[] args) throws ParseException {
		
		String dt ="3 August, 2015";
		
		Date javaDate= new SimpleDateFormat("").parse(dt);
		System.out.println(javaDate);
		/*String strDate = "1969-12-31T21:45:00.000Z";
		Date javaDate=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX").parse(strDate);
		Calendar cal = new GregorianCalendar();
		cal.setTime(javaDate);
		System.out.println(cal.get(Calendar.HOUR_OF_DAY));
		System.out.println(cal.get(Calendar.MINUTE));
		System.out.println(javaDate);*/
	}
}
