package test;

public class Dog extends Animal{
	public Dog() {
		this.kind = "표유류";
	}
	
	//부모클래스가 갖고 있는 추상메서드를 반드시 구현해야 한다.
	@Override
	public void sound() {
		System.out.println("멍멍");
	}
}
