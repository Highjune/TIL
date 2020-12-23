import java.util.Calendar;

public class Member implements Comparable<Member> {
	private String name, address, gender;
	private int age;
	private Calendar birthday;
	
	public Member(String name, String address, Calendar birthday, int age, String gender) {
		this.name = name;
		this.address = address;
		this.birthday = birthday;
		this.age = age;
		this.gender = gender;
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

	public Calendar getBirthday() {
		return birthday;
	}

	public void setBirthday(Calendar birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", address=" + address + ", birthday=" + birthday + ", gender=" + gender
				+ ", age=" + age + "]";
	}

	@Override
	public int compareTo(Member other) {
		return this.age - other.age;
	};
	
	
}
