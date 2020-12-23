//자바의 정석 p381
//5. interface는 instantiation을 할 수 없다. 그래서 다형성으로 구현해야 된다.


public class InterfaceDemo {
	public static void main(String[] args) {
//		Weekable w = new Weekable(); // interface는 일종의 추상클래스라서 new를 못 쓴다. 다형성으로 해야 된다. 따라서 아래와 같이.
		Weekable w = new Week();
		w.set(Weekable.THU); //static이므로 new를 쓸 필요 없고, 클래스 이름! 또는 인터페이스 이름(Weekable.) 로 접근
//				Weekable.FRI = 100; //안된다. 상수 변경 안됨.
		System.out.println("오늘은" + w.get() + "요일입니다.");
	}
}
		

