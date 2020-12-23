
public class Member {
	private String name, email;
	private int age;
	public Member(String name, int age, String email) {
		this.name = name;
		this.age = age;
		this.email = email;
	
	
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Member [name=" + name + ", email=" + email + ", age=" + age + "]";
	}
	
	

}
