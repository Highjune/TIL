import java.util.Calendar;		//컨+쉬+ o하면 바로 자동생성
import java.util.GregorianCalendar;

public class AbstractClassDemo1 {
	public static void main(String[] args) {
//		Calendar cal = new Calendar();  //인스턴스화(new) 할 수 없다. 왜? 추상클래스이므로
		
//		Calendar cal; // 선언형은 부모로 선언
//		cal = new GregorianCalendar(); //자식으로 생성 (API에서)  //추상클래스는 반드시 다형성을 통해서만 객체가 만들어진다.
	
//		Mammal m = new Mammal(); //는 안되지만
		Mammal [] array = new Mammal[3]; //배열은 생성된다. 왜냐하면 mammal를 만든 것이 아니라 mammal를 넣을 수첩을 만든거니까!
		array[0] = new Dog();
	
	}
}

