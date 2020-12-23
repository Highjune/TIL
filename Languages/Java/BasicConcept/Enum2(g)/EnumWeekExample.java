package practice;

import java.util.Calendar;

public class EnumWeekExample {
   public static void main(String[] args) {
      // Calendar로 원하는 날짜를 java에서 얻을 수 있다. 아래처럼.
      Calendar now = Calendar.getInstance();
//      
//      int year = now.get(Calendar.YEAR);            //연
//      int month = now.get(Calendar.MONTH) + 1;   //월 + 1
//      int day = now.get(Calendar.DAY_OF_MONTH); //일
//      int week = now.get(Calendar.DAY_OF_WEEK); //요일(1~7)
//      int hour = now.get(Calendar.HOUR);         //시간
//      int minute = now.get(Calendar.MINUTE);      //분
//      int second = now.get(Calendar.SECOND);       //초
      
      //////////////////////////////////
      
      // 열거 타입 변수 선언
      Week today = null; 
      
      Calendar cal = Calendar.getInstance();
      int week = cal.get(Calendar.DAY_OF_WEEK); // 1~7까지 리턴      
      
      switch(week) {
      case 1 :
         today = Week.SUNDAY; break;
      case 2 :
         today = Week.MONDAY; break;
      case 3 :
         today = Week.TUESDAY; break;
      case 4 :
         today = Week.WEDNESDAY; break;
      case 5 :
         today = Week.THURSDAY; break;
      case 6 :
         today = Week.FRIDAY; break;
      case 7 :
         today = Week.SATURDAY; break;
      }
      
      System.out.println("오늘 요일 : " + today);
      
      if(today == Week.SUNDAY) {
         System.out.println("일요일에는 축구를 합니다");
      } else {
         System.out.println("일요일이 아니면 자바 공부합니다.");
      }
      
      
      
   }
}