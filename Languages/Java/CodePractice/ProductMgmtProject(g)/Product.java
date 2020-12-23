	//���� ���� ������ �� Ŭ����
public class Product implements Comparable<Product>{
	//comparable�� �ڽ��� �Ƿ��� �ݵ�� �������ؾ� �� �Լ� compareTo��
	//sort�ϰ� ������ Comparable�� �ڽ��� �Ǿ�� �ϰ�(compareto����) sort������ Collections.sort()���ָ� ��
	//�̷��� �����ϸ� ������ ��������, ������ ���� ���� �͵��� �˰������� �����ϴ� �ͺ��� �ξ� �� ����.
	

	private String name;  //��ǰ��
	private int qty, salemoney, buymoney, fee, sum; //����, �ǸŴܰ�, ���Դܰ�, ��ۺ�, ���ͱ�
	private double rate; //���ͷ�
	public Product(String name, int qty, int salemoney, int buymoney, int fee) {
		this.name = name;
		this.qty = qty;
		this.salemoney = salemoney;
		this.buymoney = buymoney;
		this.fee = fee;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQty() {
		return qty;
	} 
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getSalemoney() {
		return salemoney;
	}
	public void setSalemoney(int salemoney) {
		this.salemoney = salemoney;
	}
	public int getBuymoney() {
		return buymoney;
	}
	public void setBuymoney(int buymoney) {
		this.buymoney = buymoney;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	
	//���� ���� ��Դ� Override toString�� concatenation
	//�ٵ� �Ʒ��� custom toString builder (���� ����� ����)
	@Override 
	public String toString() {  //�������� �ϳ��ϳ� ���� ����. �ٸ� ������� ������ ����
		return String.format("%s\t%d\t%d\t%d\t%d\t%d\t%.2f",
				             name, qty, salemoney, buymoney, fee, sum, rate);
	}
	@Override
	public int compareTo(Product other) { //comparable�� �ڽ��� �Ǿ��⿡ �������ϴ� �Լ���
		return (int)(other.rate*100)-(int)(this.rate*100); //��������, rate�� double�ε� ������ int�����ϹǷ�.
		//���ϰ��� int�� ������ �θ� �׷��� ������ ���̱� ������ Override�ϴ� ���忡���� ��¿�� ����.
	}
}
