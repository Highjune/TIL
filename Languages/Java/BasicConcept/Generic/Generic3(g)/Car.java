//GenericDemo1클래스와 함께.



public class Car<T> implements Comparable <Car> {  
	///Car는 comparable의 자식이어야 하는데, 그럴려면 compareTo를 재정의해야 된다.
	private String name;
	private int price;
	public Car(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	@Override  //원래는 String을 비교하는 comparTo를 재정의한 것. String클래스에는 compareto가 있다.
	public int compareTo(Car other) {  //interface니까 public이 생략되어 있고 그것을 재정의 하려면 public 당연히 써야 된다.
//		return this.name.compareTo(other.name); //원래 그냥 이렇게 하면 되는데 우리는 가격으로 비교할 거니깐 재정의
		
		if(this.price > other.price) return 1;  // "B" - "A"
		else if(this.price < other.price) return -1;  // "A" - "B"
		else return 0; // "A" - "A"

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
		return "Car [name=" + name + ", price=" + price + "]";
	}
}
