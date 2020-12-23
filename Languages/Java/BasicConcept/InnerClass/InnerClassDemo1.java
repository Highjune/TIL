/*
 * static Inner Class
 * 1. Why ? Packaging 하려고 쓴다.  ex) 역삼동은 서울에서도 있지만 용인시 역삼동도 있기 때문에.
 * 2. How to create : 바깥 클래스의 주소가 필요하지 않다. 바깥클래스이름으로 접근
 * 3. Restricted Point : 바깥 클래스의 멤버변수와 멤버메소드 접근 불가 (왜? 나는 static이니까)
 * 
 */


public class InnerClassDemo1 {
	public static void main(String[] args) {
		int age = StaticOuter.age;
		StaticOuter.StaticInner inner = new StaticOuter.StaticInner();  //바깥쪽 클래스를 만들 필요 없다. 여기서 new는 StaticInner()를 위한 것.
	}
}


class StaticOuter{ //바깥쪽 모든 클래스에는 private도 안되고 static도 안 된다. 모든 클래스는 public과 아무것도 안 쓰는 것만 가능하다.
	static int age = 24;
	int kor = 100; // kor는 메모리에 올라가야만 접근가능하다. 그런데 메모리에 올라가려면 주소를 생성해야 되는데, 주소를 생성 안했기 때문에 접근이 안된다.
		static class StaticInner{ 
		//내부클래스일 때만 클래스에 static 딱 붙일 수 있다.
			int eng = 100;
			public void StaticInner() {System.out.println("방금 스택틱 객체가 생성됐습니다.");}
			public void display() {
//			System.out.println(age); // 바깥에 접근가능.
//			System.out.println(eng); // 멤버니까 접근 가능하다.
			}
		}
}	



