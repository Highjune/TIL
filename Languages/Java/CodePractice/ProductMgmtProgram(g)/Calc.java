
public class Calc {
	private Product p;   //member variable

	public Calc(Product p) {
		this.p = p;
	}
	
	public void calc() {
		int sale = this.p.getQty() * this.p.getSalemoney();  //판매금액
		int buy = this.p.getQty() * this.p.getBuymoney();   //매입금액
		int total = sale - (buy + this.p.getFee());                //이익금
		double rate = (double)total / buy * 100;                //이익률
		this.p.setTotal(total);
		this.p.setRate(rate);
	}
	
}
