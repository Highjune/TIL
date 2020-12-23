	//제일 먼저 만들어야 할 클래스
public class Product implements Comparable<Product>{
	//comparable의 자식이 되려면 반드시 재정의해야 할 함수 compareTo임
	//sort하고 싶으면 Comparable의 자식이 되어야 하고(compareto구현) sort에서는 Collections.sort()해주면 끝
	//이렇게 정렬하면 오히려 버블정렬, 셀렉션 정렬 같은 것들의 알고리즘으로 정렬하는 것보다 훨씬 더 쉽다.
	

	private String name;  //상품명
	private int qty, salemoney, buymoney, fee, sum; //수량, 판매단가, 매입단가, 운송비, 이익금
	private double rate; //이익률
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
	
	//원래 자주 써왔던 Override toString은 concatenation
	//근데 아래는 custom toString builder (직접 만드는 것임)
	@Override 
	public String toString() {  //수동으로 하나하나 만든 것임. 다른 방법으로 정의한 것임
		return String.format("%s\t%d\t%d\t%d\t%d\t%d\t%.2f",
				             name, qty, salemoney, buymoney, fee, sum, rate);
	}
	@Override
	public int compareTo(Product other) { //comparable의 자식이 되었기에 재정의하는 함수임
		return (int)(other.rate*100)-(int)(this.rate*100); //내림차순, rate는 double인데 리턴은 int여야하므로.
		//리턴값이 int인 이유는 부모가 그렇게 정의한 것이기 때문에 Override하는 입장에서는 어쩔수 없다.
	}
}
