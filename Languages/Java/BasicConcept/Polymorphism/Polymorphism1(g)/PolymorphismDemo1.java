//������ ���� (��û ���� ����)
//�θ�(mammal) �� �ڽĵ�(dog, cat, american, korean)�� ���� ~
//��� ����� ����ų ���� runtime ��

import java.util.Scanner;
import javax.swing.JOptionPane;

public class PolymorphismDemo1 {
	public static void main(String[] args) {     //���ι� �ۼ�
		PolymorphismDemo1 pd = new PolymorphismDemo1();
		int choice = 0 ; //�������� �ʱ�ȭ, �ۿ� ������ ������ while���� ����Ǿ�� �Ǳ� ������
		while(true) {
			pd.showMenu();
			choice = pd.input();
			if(choice == 5) break;
			else if(choice > 5 || choice <1) {
				JOptionPane.showMessageDialog(null, "�߸��� �Է°� �Դϴ�.");
				continue; //
			}else {
				pd.output(choice);  //saysomething ó��
			}
		};
		
		
	}
	void showMenu(){	
		System.out.println("***Menu***");
		System.out.println("1. Dog");
		System.out.println("2. Cat");
		System.out.println("3. Korean");
		System.out.println("4. American");
		System.out.println("5. Exit");
	}
	
	int input(){ //�����ϰ� ��ȣ�� �� ���̴ϱ� ��ȯ�� ����
		Scanner scan = new Scanner(System.in);
		System.out.println("��� ���� ? :"); 
		int choice = scan.nextInt(); //�ް�
		return choice; //���� ��ȣ �Ѱ��ָ� ��
		
	} 
	void output(int choice){ //������ ��ȣ�� �ѱ�� �����ְ� ��
		Mammal m = null; //�θ��� ����, �׻� ���������� �ʱ�ȭ
		switch(choice) {
		case 1 : m = new Dog(); break;
		case 2 : m = new Cat(); break;
		case 3 : m = new Korean(); break;
		case 4 : m = new American(); break;
		}
		m.saySomething(); // ���� �ڽĵ�(dog, cat, korean, american) �� �´� �� �� ����.
		
		
	}
}
