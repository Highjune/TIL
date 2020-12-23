import java.io.Serializable;

//여러 product들을 가지고 있는 Arraylist를 한꺼번에 직렬화 (제품을 직렬화 X)

//스프링 가면 이것들을 POJO라고 함 (기본적으로 생성하는 것들)
// Plain Old Java Object 평범한 자바 객체 //생성자, 겟터 셋터, 생성자, tostring~
public class Product implements Serializable{
	private String name;
	/*transient*/private int price;  //transient넣는다면? 가격까지 다 넣은 것을 직렬화 후 역직렬화 하면 가격은 뜨지 않는
	
	public Product(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public String getName() { 
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "SerializationDemo [name=" + name + ", price=" + price + "]";
	}
	
}



