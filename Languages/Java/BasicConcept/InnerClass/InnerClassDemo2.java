/*
 * Local Inner Class 지역 내부 클래스
 * 1. Why?
 * 2. How to create : 속해있는 메소드가 실행되어야
 * 3. Restricted Point : 1) 메소드 안에서는 절차적. 차례적이다. 클래스 선언 후 생성해야. 2) 지역클래스에는 접근제한자(public, private, protected) 사용불가
 *///3) static 사용 불가 즉. 지역변수랑 다 똑같다. 
 /*단 원래 지역변수에는 abstract 못 붙이지만, 내부클래스에는 가능하다.
  * 4) static variable, static method를 소유불가
  * 
  */

public class InnerClassDemo2 {
	public static void main(String[] args) {
		int kor = 100;
		LocalOuterClass outer = new LocalOuterClass();
		outer.display();
	}
}


class LocalOuterClass{
	public void display() { //이 메서드가 열리면 순서대로 age = 50 먼저 수행되고 나서~!
		int age = 50; //local variable //지역변수에는 access modifier못 붙인다. 내부클래스도 마찬가지.
		class LocalInnerClass{//클래스를 메서드 안!(display()메서드 안에 있는 것임) = 지역클래스, 역시 메서드가 끝나면 사라짐.
			private int kor = 90;
			private static int eng = 100;
			private static void print() {
				System.out.println("나는 지역클래스의 메소드");
			}
		}
		
//		LocalInnerClass inner = new LocalInnerClass(); 		
//		class LocaInnerClass{}							//이렇게 쓰면 안된다. 순서가 잘못됨. 메서드는 절차적인데, LocalInnerClass를 읽기도 전에 new~주소를 생성할 수가 없다. 안 읽힌다.
		}
	}





