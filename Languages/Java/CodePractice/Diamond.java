//6. ���̾Ƹ�� ��� (�غ���)

import java.util.Scanner;
public class Diamond {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Ȧ���� �Է��ϼ��� : ");
		int su = scan.nextInt();
		int num = su / 2 + 1;
		System.out.printf("\n");

		for (int i = 1; i <= num; i++) {
			for (int j = num; j > i; j--) {
				System.out.printf(" ");
			}
			for (int k = 0; k < i; k++) {
				System.out.printf("* ");
			}
			System.out.printf("\n");
		}
		
		for (int i = 1 ; i < num ; i++){
			for (int j = 0; j < i ; j++) { 
				System.out.printf(" "); 
			} 
			for (int j = num - 1 ; j >= i ; j--) {
				System.out.print("* "); 
			}
			System.out.printf("\n");
		} 
	}
}
