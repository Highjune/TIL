package practice;

public class EnumWeekConcept {
   public static void main(String[] args) {
      // 열거타입 변수 -> 선언방식
	   //열거 타입은 단독으로 사용할 수 없고, 반드시 '열거타입.열거상수' 의 형태로 사용된다.
      // today, reservation 등의 변수들은 스택 영역에 생성
      Week today; 
      Week reservaionDay; 
//      Week tomorrow = null; // 열거타입도 참조 타입이므로 null저장가능
      
      // 열거타입.열거상수 형태로 접근
      today = Week.SATURDAY;  // today에 저장되는 값은 Week.SUNDAY 열거상수가 참조하는 객체의 번지다. 이 둘은 힙 영역에 있는 같은 Week(SUNDAY) 객체를 가리키게 된다.

   }
}
