/*
 * Anonymous Inner Class
 * 1. Why? : 일회용 / 특정클래스의 멤버메소드 재정의
 * 2. how to create : 속해있는 메소드가 호출받을 때
 * 3. Restricted Point 
 * cf) 이름이 없는 것이 아니라 기존의 클래스를 재정의 하려고
 */


public class InnerClassDemo3 {
	public static void main(String[] args) {
//		jimin.display(); 여기 오면 에러남. 왜냐하면 메소드는 절차적이므로.
		Employee jimin = new Employee() {
			@Override
			public void display() {
				System.out.println("나는 자식 메소드");   //상속을 받지 않아도 재정의할 수 있다. 메소드 안에서 재정의되었기 때문에 지역클래스.
			}
		};  // 문장의 끝. 하나의 문장이다!!
		jimin.display();
	}
}


class Employee{
	public void display() {
		System.out.println("나는 부모 메소드");
	}
}

