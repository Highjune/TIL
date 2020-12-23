import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

//날짜를 표헌하는 방법3
//DateFormat
//만들어진 틀이지만 locale base로 찍을 경우
public class Date4 {
	public static void main(String[] args) {
		
		DateFormat df = DateFormat.getDateInstance(); //년, 월, 일 
		DateFormat df1 = DateFormat.getTimeInstance();  // 시간
		DateFormat df2 = DateFormat.getInstance();  // 년, 월, 일과 시간 둘 다
		
		DateFormat df3 = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL);  // 년, 월, 일과 시간 둘 다 (가장 자세하게, 영어의 경우는 더 확실). 파라미터1 - 날짜, 파라미터2 - 시간
		System.out.println(df3.format(new Date()));
		
		DateFormat df4 = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.US);  // 파라미터3 - Locale(나라별, 지역별, 정치적별로 구분, 한국도 포함되어 있다), FULL-자세히
//		DateFormat df4 = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, Locale.US);  // SHORT-간략
		System.out.println(df4.format(new Date()));
	}
}
