import java.util.Scanner;

//�������� ����(0���� ����)
public class ContinuePractice1 {
	public static void main(String[] args) {
		int menu = 0;
		int num = 0;
		
		Scanner scan = new Scanner(System.in);
		
		while(true) { //���ѷ���
			System.out.println("(1) square");
			System.out.println("(2) square root");
			System.out.println("(3) log");
			
			System.out.println("���ϴ� �޴�(1~3)�� �����ϼ���. (����:0)>");
			String tmp = scan.nextLine(); //ȭ�鿡�� �Է¹��� ������ tmp�� ����
			menu = Integer.parseInt(tmp); //���ڿ��� ���ڷ� ��ȯ
			
			if(menu==0) {
				System.out.println("���α׷��� �����մϴ�.");
				break;
			} else if (!(1 <= menu && menu <=3)) {
				System.out.println("�޴��� �߸� �����ϼ̽��ϴ�. (����� 0)");
				continue;
//			} else { //�̷��� �ص� ��.
//				System.out.println("�޴��� �߸� �����ϼ̽��ϴ�. (����� 0)");
//				continue;
			}
			System.out.println("�����Ͻ� �޴��� " + menu + "���Դϴ�.");
		}		
	}
}
