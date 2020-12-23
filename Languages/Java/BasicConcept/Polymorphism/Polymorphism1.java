import java.util.Scanner;

public class PolymorphismDemo {
	public static void main(String[] args) {
	
		Parent p = new Child(); 
		p.display(); // 부모의 주소(p)인데 이건 자식의 메소드를 호출함!!! => 다형성
		
		Object obj = new String("Hello"); //String이 obj가 되기도 하고~
		obj = new Integer("5"); // Integer가 obj도 되기도 하고~
		obj = new Scanner(System.in); //Scanner가 obj가 되기도 하고~
	
		
	}
}


class Parent{
	public void display() {System.out.println("나는 부모 메소드");}
	}
class Child extends Parent{
	@Override // 똑같은 메소드 이름
	public void display() {System.out.println("나는 자식 메소드");}
	}

//Override메소드는 상속되지 않는다. cf) 상속이 안되기 때문에 부모 메소드의 body를 바꾸는 것. ex) 어제 했던 것처럼 부모가 가지고 있는 toString과 equals를 재정의