//GenericDemo1Ŭ������ �Բ�.



public class Car<T> implements Comparable <Car> {  
	///Car�� comparable�� �ڽ��̾�� �ϴµ�, �׷����� compareTo�� �������ؾ� �ȴ�.
	private String name;
	private int price;
	public Car(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	@Override  //������ String�� ���ϴ� comparTo�� �������� ��. StringŬ�������� compareto�� �ִ�.
	public int compareTo(Car other) {  //interface�ϱ� public�� �����Ǿ� �ְ� �װ��� ������ �Ϸ��� public �翬�� ��� �ȴ�.
//		return this.name.compareTo(other.name); //���� �׳� �̷��� �ϸ� �Ǵµ� �츮�� �������� ���� �Ŵϱ� ������
		
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
