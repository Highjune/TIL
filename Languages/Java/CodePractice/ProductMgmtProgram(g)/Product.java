
public class Product {
	private String name;  //��ǰ��
	private int qty, salemoney, buymoney, fee, total;  //����, ���Դܰ�, �ǸŴܰ�, ��۷�, ���ͱ�
	private double rate;   //������
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
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
}
