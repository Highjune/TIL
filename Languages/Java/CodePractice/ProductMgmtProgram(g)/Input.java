import java.util.Scanner;

public class Input {
	private Scanner scan;
	
	public Input() {
		this.scan = new Scanner(System.in);
	}
	
	public Product input() {
		System.out.print("��ǰ�� : ");   String name = this.scan.next();
		System.out.print("���� : ");      int qty = this.scan.nextInt();
		System.out.print("�ǸŴܰ� : ");      int salemoney = this.scan.nextInt();
		System.out.print("���Դܰ� : ");      int buymoney = this.scan.nextInt();
		System.out.print("��۷� : ");      int fee = this.scan.nextInt();
		Product p = new Product(name, qty, salemoney, buymoney, fee);
		return p;
	}
}
