import java.util.Scanner;
public class While1{
	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
		System.out.println("<<��뿡�� ���� �޽����� �Է��� �ּ���.>>");
		System.out.println("<<���� �׸� �����÷��� �׳� ����ġ����.>>");
	while(true) {
		System.out.print("���� �޽��� : "); 
		String msg = scan.nextLine();
		if(msg.length() == 0) break;
		System.out.println("������ �޽��� : " + msg);
	}
}
}