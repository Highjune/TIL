//�������� ���ڸ� �Է¹޾Ƽ� �� �� ���� ū���� ���� ���� ����ϱ�, ��, �Է� �� 0�� ������ ��
//ex) 3 2 -4 8 9 0
import java.util.Scanner;
public class Do1 {
	public static void main(String[] args) {

	Scanner scan = new Scanner(System.in);
	
	int num, max = 0, min = 0;
	while((num = scan.nextInt())!=0) {
		if(max < num) max = num;			
		if(min > num)  min = num;		
	}
	System.out.println("���� ū �� " + max);
	System.out.println("���� ���� �� " + min);
	}
}