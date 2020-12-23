//sonata클래스의 부모


public class Car {
	private String name;
	public Car(String name) {
		this.name = name;
	}
	public String getName() {return this.name;} // PolymorphismDemo3 에서 써먹을려고
	
	public void repair() {
		System.out.println(this.name + "가 수리됐습니다.");
	}
}



