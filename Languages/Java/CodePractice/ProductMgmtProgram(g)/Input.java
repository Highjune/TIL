import java.util.Scanner;

public class Input {
	private Scanner scan;
	
	public Input() {
		this.scan = new Scanner(System.in);
	}
	
	public Product input() {
		System.out.print("상품명 : ");   String name = this.scan.next();
		System.out.print("수량 : ");      int qty = this.scan.nextInt();
		System.out.print("판매단가 : ");      int salemoney = this.scan.nextInt();
		System.out.print("매입단가 : ");      int buymoney = this.scan.nextInt();
		System.out.print("운송료 : ");      int fee = this.scan.nextInt();
		Product p = new Product(name, qty, salemoney, buymoney, fee);
		return p;
	}
}
