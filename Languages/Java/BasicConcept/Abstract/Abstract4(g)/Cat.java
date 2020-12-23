package test;

public class Cat extends Animal{
	public Cat() {
		this.kind = "포유류";
	}
	

	//부모클래스가 갖고 있는 추상메서드를 반드시 구현해야 한다.
	@Override
	public void sound() {
		System.out.println("냐옹");
	}

}
