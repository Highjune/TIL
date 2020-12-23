//PersonŬ������ �����ϴ� Student�� Employee

//�׻�!! ���� ó���� Ű����� ������ modifier��!! public/private/protected �� �ϳ�

public abstract class Person {

	private String name, address; //Q�� name, address�� ������ �� ?=> �������� �����.��
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
		
	@Override//�� ����ȭ��.
	public abstract String toString();  //�޼ҵ� ���� -> ������!�� �׸��� �ڽ��� ������ ��������� �ȴ�. 
	
	
}


