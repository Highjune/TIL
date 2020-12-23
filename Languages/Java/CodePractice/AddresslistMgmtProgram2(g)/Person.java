import java.io.Serializable;

public class Person implements Serializable {
	private int number;
	private String name, tel, address;
	
	public Person(int number, String name, String tel, String address) {
		this.number = number;
		this.name = name;
		this.tel = tel;
		this.address = address;
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Person [number=" + number + ", name=" + name + ", tel=" + tel + ", address=" + address + "]";
	}
}
