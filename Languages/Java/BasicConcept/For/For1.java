import java.util.Scanner;

public class For1 {
	public static void main(String[] args) {
//		 ������ ���ϴ� ���ں��� �츮�� ���ϴ� ���ڱ��� ���ϱ�
		Scanner scan = new Scanner(System.in);
		System.out.print("�󸶺��� ���ұ��? : ");
		int start = scan.nextInt();
		System.out.print("�󸶱��� ���ұ��? : ");
		int last = scan.nextInt();
		int sum = 0; 
		for(int i=1 ; i<=last ; i++) {  
			sum +=i;
		}
		System.out.println(start + "1���� " + last  + "������ ���� " + sum);
	}
}