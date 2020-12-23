
public class Output {
	private Product p;

	public Output(Product p) {
		this.p = p;
	}
	
	public void output() {
		printLabel();
		System.out.printf("%s\t%,d\t%,d\t%,d\t%,d\t%,d\t%.2f\n",
				this.p.getName(), p.getQty(), p.getSalemoney(), p.getBuymoney(),
				p.getFee(), p.getTotal(), p.getRate());
	}
	
	private void printLabel() {
		System.out.println("                <<상품별 판매 이익금 및 이익율표>>");
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.println("상품명            수량         판매단가         매입단가         운송료        이익금         이익율");
		System.out.println("----------------------------------------------------------------------------------------");
	}
}
