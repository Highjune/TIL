import java.util.Scanner;

public class OpDemo1 {
public static void main(String[] args) {
//���� ���ϴ� ���
//���� ����  //400�⸶�� �� �������� ���� or (4���� ����̸鼭 100�� ����� x)
	Scanner scan = new Scanner(System.in);
	System.out.print("Year : ");
	int year = scan.nextInt();
	
	String result = ((year % 400 == 0) || 
			(year%4 ==0 && year%100 !=0)) ? 
					"�����Դϴ�." : "������ �ƴմϴ�.";
	System.out.printf("%d���� %s\n", year, result);
	
}
}
