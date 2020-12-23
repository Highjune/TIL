
class A {
	public void method(I i) { //인터페이스 I를 구현한 것들만 들어올 수 있다. 
		i.method();
	}
}


//B클래스의 선언과 구현을 분리
interface I {  //메서드의 선언
	void method();	//추상메서드
}


class B implements I { //메서드의 구현
	public void method() {
		System.out.println("B클래스의 메서드");
	}
}

class C implements I{
	public void method() {
		System.out.println("C클래스의 메서드");
	}
}



public class InterfaceTest {
	public static void main(String[] args) {
//		A a = new A();
//		a.method(new B());
		
		A a = new A();
		a.method(new C());  //C도 인터페이스 I를 구현해야 method()의 매개변수로 가능
	}
}
