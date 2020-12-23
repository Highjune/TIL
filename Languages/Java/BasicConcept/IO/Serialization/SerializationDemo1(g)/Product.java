import java.io.Serializable;

//���� product���� ������ �ִ� Arraylist�� �Ѳ����� ����ȭ (��ǰ�� ����ȭ X)

//������ ���� �̰͵��� POJO��� �� (�⺻������ �����ϴ� �͵�)
// Plain Old Java Object ����� �ڹ� ��ü //������, ���� ����, ������, tostring~
public class Product implements Serializable{
	private String name;
	/*transient*/private int price;  //transient�ִ´ٸ�? ���ݱ��� �� ���� ���� ����ȭ �� ������ȭ �ϸ� ������ ���� �ʴ�
	
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



