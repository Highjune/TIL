import java.util.Scanner;

//1���� 100������ Ư�� �� �߿��� ���� ���� ������(up down)
public class DoWhile {
	public static void main(String[] args) {
		int input = 0, answer = 0;
		
		answer = (int)(Math.random()*100) + 1; //1~100������ ��
		Scanner scan = new Scanner(System.in);
		
		do {
			System.out.println("1���� 100������ ������ �Է��ϼ���");
			input = scan.nextInt();
			
			if(input > answer) {
				System.out.println("�� ���� ���� �ٽ� �õ��غ�����");
			} else if (input < answer) {
				System.out.println("�� ū ���� �ٽ� �õ��غ�����");
			}			
		}while(input!=answer);
		
		System.out.println("�����Դϴ�.");
		
	}
}
