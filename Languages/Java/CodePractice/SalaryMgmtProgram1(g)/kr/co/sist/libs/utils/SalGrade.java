package kr.co.sist.libs.utils;

import java.util.Hashtable;
import java.util.Properties;

public class SalGrade {
	/**
	 * @param grade : 호급수당코드 
	 * @return 호급수당코드에 대한 수당값
	 */
	public static int getSalaryGrade(int grade) {
		Hashtable<Integer, Integer> htGrade = new Hashtable<Integer, Integer>();
		htGrade.put(1, 900000);   htGrade.put(2, 400000);
		htGrade.put(3, 600000);   htGrade.put(4, 800000);
		htGrade.put(5, 300000);   htGrade.put(6, 800000);
		htGrade.put(7, 800000);   
		return htGrade.get(grade);
	}
	public static int getDefaultSalary(int grade) {
		Hashtable<Integer, Integer> htDefault = new Hashtable<Integer,Integer>();
		htDefault.put(1, 15000);    htDefault.put(2, 25000);
		htDefault.put(3, 35000);    htDefault.put(4, 45000);
		return htDefault.get(grade);
	}
	public static int getHourBonus(int hour) {
		Properties bonus = new Properties();
		bonus.setProperty("1", "1500");    bonus.setProperty("2", "2500");
		bonus.setProperty("3", "3500");    bonus.setProperty("4", "4500");
		//String hourStr = "" + hour;
		String hourStr = String.valueOf(hour);   //4 --> "4"
		return Integer.parseInt(bonus.getProperty(hourStr));  //"4500" --> 4500
	}
}
