import java.util.Scanner;

//�� �ڸ��� ��
public class WhilePractice2 {
	public static void main(String[] args) {
		int num=0, sum=0;
		System.out.print("���ڸ� �Է��ϼ���");
		
		Scanner scan = new Scanner(System.in);
		String tmp = scan.nextLine();
		num = Integer.parseInt(tmp);
		
		while(num!=0) {
			//num�� 10���� ���� �������� sum�� ����
			sum += num%10;
			System.out.printf("sum=%3d num=%d%n", sum, num);
			
			num /= 10; //  num = num / 10;
		}
		System.out.println("�� �ڸ����� �� : " + sum);	
		
	}
}
 