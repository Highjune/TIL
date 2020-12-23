import java.util.Calendar;
import java.util.GregorianCalendar;

//날짜를 표헌하는 방법3
//Calendar의 Gregorian (2가지 있음)
//장점 : setting을 할 수 있다. 달력만들 때 자주 사용. 윤년 등을 계산할 때 사용가능
public class Date3 {
	public static void main(String[] args) {


		Calendar now1 = new GregorianCalendar(2020, 2, 7); // 선언형은 부모형, 실제형은 자식형.
		System.out.println(now1);
				
		
	}
}
