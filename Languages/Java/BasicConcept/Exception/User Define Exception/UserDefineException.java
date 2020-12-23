import java.util.Scanner;

//����� ������ exception p439  
/*
 * ����� ���� ����ó���� ����� ���
 * 1. Exception�� ������ �ڽ��ΰ�(������ �ڽ��̳Ŀ� ���� checked �ΰ� unchecked �ΰ� ���� �ٸ���)
 * 2. ������
 */

public class ExceptionDemo7 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		do {
			try {
				System.out.println("���� ���� : ");		
				int kor = scan.nextInt();
				if(scoreCheck(kor)) break;
				else throw new RuntimeException("������ �߸� �Է��ϼ̽��ϴ�.");
			}catch(RuntimeException ex) {
				System.out.println(ex.getMessage());
				
			}
		}while(true);  //�������� ����� ���� ������ ���ѷ���
	
	}
	
	static boolean scoreCheck(int jumsu) {
		if(jumsu >= 0 && jumsu <= 100) return true;
		else return false;	
	}
}

