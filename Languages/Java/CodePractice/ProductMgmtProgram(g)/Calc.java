
public class Calc {
	private Product p;   //member variable

	public Calc(Product p) {
		this.p = p;
	}
	
	public void calc() {
		int sale = this.p.getQty() * this.p.getSalemoney();  //�Ǹűݾ�
		int buy = this.p.getQty() * this.p.getBuymoney();   //���Աݾ�
		int total = sale - (buy + this.p.getFee());                //���ͱ�
		double rate = (double)total / buy * 100;                //���ͷ�
		this.p.setTotal(total);
		this.p.setRate(rate);
	}
	
}
