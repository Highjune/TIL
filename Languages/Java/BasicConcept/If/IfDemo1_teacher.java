

import java.util.Scanner;
public class IfDemo1_teacher {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("�й� : "); 	String hakbun = scan.next();
		System.out.print("�̸� : "); 	String name = scan.next();  
		// scan.next ���� scan.nextline �� �ִ´ٸ� �й�: ~~ �ְ� �̸�: (����) �� �Ǿ� �Ѿ�� �ȴ�.
		System.out.print("���� : "); 	int kor = scan.nextInt();
		System.out.print("���� : "); 	int eng = scan.nextInt();
		System.out.print("���� : "); 	int mat = scan.nextInt();
		
		int tot = kor + eng + mat;		double avg = tot/3.;
		char grade;
		
		switch((int)(avg/10)) {
		case 10: /*grade = 'A'; break; */ // �̷��� �� �ᵵ �ȴ�. ������ 10�� ã���� �� ������ �׳� ������ �����ͼ� ���� �� Aã�� break �Ѵ�.
		case 9:	 grade = 'A'; break;
		case 8:	 grade = 'B'; break; 
		case 7:	 grade = 'C'; break;
		case 6:	 grade = 'D'; break;
		default : grade = 'F';
		/* �Ʒ�ó�� ���� case 5���ʹ� ������ ������ �̹Ƿ� dafault�� ���� ���� ���ϴ�.
		case 5:		
		case 4:
		case 3:
		case 2:
		case 1:
		case 0; grade = 'F'; break;  // ���� ���̴ϱ� break�� �ᵵ �ȴ�.
		 */
		
		System.out.printf("%s(%s)\t%d\t%d\t%d\t%d\t%.1f\t%c\n",
		name, hakbun, kor, eng, mat, tot, avg, grade);
	
		}
	}
}
		



//if������ �Ϸ��� ���� ��ó��
		
//		if(avg>=90) grade = 'A';
//		else if(avg >= 80) grade = 'B';
//		else if(avg >= 70) grade = 'C';
//		else if(avg >= 60) grade = 'D';
//		else grade = 'F';
//		System.out.printf("%s(%s)\t%d\t%d\t%d\t%d\t%.1f\t%c\n",
//				name, hakbun, kor, eng, mat, tot, avg, grade);
//		
	



