
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
		System.out.println("                <<��ǰ�� �Ǹ� ���ͱ� �� ������ǥ>>");
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.println("��ǰ��            ����         �ǸŴܰ�         ���Դܰ�         ��۷�        ���ͱ�         ������");
		System.out.println("----------------------------------------------------------------------------------------");
	}
}
