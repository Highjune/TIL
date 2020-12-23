package test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExample {
	public static void main(String[] args) {
		Date now = new Date();
		String strNo1 = now.toString();
		System.out.println(strNo1);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		String strNo2 = sdf.format(now);
		System.out.println(strNo2);
		
	}
}
