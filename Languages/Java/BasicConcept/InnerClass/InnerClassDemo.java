/*
 * Instance Inner Class
 * 1. Why? : 재정의의 부담(의무)없이 다중상속하려고
 * 2. How to create : 바깥 클래스의 주소를 통해서 생성.
 * 3. restricted Point : static 변수, static method를 가질 수 없다. 
 * 
 */
public class InnerClassDemo {
	public static void main(String[] args) {
		InstanceOuter outer = new InstanceOuter();
		int age = outer.age;
		InstanceOuter.InstanceInner inner = outer.new InstanceInner();  // 주소.생성자
		
	}
}
class InstanceOuter{
	int age = 24; // 바깥클래스의 멤버변수	
	static int kor = 100; //바깥클래스의 스태틱변수
	class InstanceInner{//바깥클래스의 스태틱변수  //멤버클래스!   //안쪽에 있는 클래스는 private이 된다.
		int eng = 90;
//		static int mat = 70; // 안쪽 클래스는 static을 가질 수 없다.
		public InstanceInner( ) { //안쪽 클래스의 생성자
			System.out.println("안쪽 클래스가 방금 생성됐습니다."); 
		}
		public void display() {  //나도 일종의 멤버이므로 static을 가질 수 없다.
			System.out.println(age);
		}
	}
}
//		
//	}
//	
//}










//public class InnerClassDemo {
//	public static void main(String[] args) {
//		InstanceOuter outer = new InstanceOuter();
//		int age = outer.age;
//		InstanceOuter.InstanceInner inner = outer.new InstanceInner();  // 주소.생성자
//		
//	}
//}
//class InstanceOuter extends Car{
//	int age = 24; // 바깥클래스의 멤버변수	
//	static int kor = 100; //바깥클래스의 스태틱변수
//	class InstanceInner extends Sonata{//바깥클래스의 스태틱변수  //멤버클래스!   //안쪽에 있는 클래스는 private이 된다.
//		int eng = 90;
////		static int mat = 70; // 안쪽 클래스는 static을 가질 수 없다.
//		public InstanceInner( ) { //안쪽 클래스의 생성자
//			System.out.println("안쪽 클래스가 방금 생성됐습니다."); 
//		}
//		public void display() {
//			
//			System.out.println(bgcolor);  //바깥쪽 클래스의 부모님도 접근가능하다. 
//			System.out.println(price);  //바깥쪽 클래스의 부모님도 접근가능하다. 
//		}//바깥쪽 접근 가능, 바깥쪽의 부모님도 접근가능, 나도 가능, 나의 부모도 가능. // 즉 4곳 클래스 다 접근가능.
//	
//	}
//	
//}
//
//class Car{
//	int price = 25_000_000; //Car클래스의 멤버변수
//}
//
//class Sonata{
//	String bgcolor = "Silver";	
//}
//









