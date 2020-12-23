//Person클래스를 참조하는 Student와 Employee

//항상!! 제일 처음의 키워드는 엑세스 modifier다!! public/private/protected 중 하나

public abstract class Person {

	private String name, address; //Q왜 name, address를 나눠서 씀 ?=> 선문한테 물어보기.툴
	private int age;
	
	Person(){};
	
	Person(String name, int age, String address){
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

//	@Override
//	public String toString() {
//		return "Person [name=" + name + ", address=" + address + ", age=" + age + "]";
//	}
//	
		
	@Override//의 강제화임.
	public abstract String toString();  //메소드 선언 -> 언젠가!는 그리고 자식이 무조건 재정의줘야 된다. 
	
	
}


