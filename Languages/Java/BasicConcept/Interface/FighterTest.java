abstract class unit{
	int x, y;
	abstract void move(int x, int y);
	void stop () {System.out.println("����ϴ�.");}
}

interface Fightable {//�������̽��� ��� �޼���� public abstract. ���ܾ��� 
	void move(int x, int y); //public abstract�� ������
	void attack(Fightable f); //public abstract�� ������
}

class Fighter extends unit implements Fightable {
	//���� �޼��忡 public������ ������ ����. �������̵� ��Ģ : ����(public)���� ���������ڰ� ������ ������ �ȵȴ�.
	public void move(int x, int y) {
		System.out.println("[" + x + "," + y + "]�� �̵�");
	} 
	public void attack(Fightable f) {
		System.out.println(f + "�� ����");
	}	
	
	Fightable getFightable() {
		Fighter f = new Fighter();
		return f; //(Fighter)f; ��. (Fighter)�� ����
	}
	
//	Fightable getFightable() {  //������ Fighter f �� ���� return�� (Fighter)f; �� �� �Ͱ� �����ϰ� ���ʿ� Fightable f �� ���� return f;�� �ϴ� �Ͱ� �Ȱ���.
//		Fightable f = new Fighter(); //Fightable f = (Fightable)new Fighter(); �� ����. �ڵ� ����ȯ �� ����.
//		return f; 
//	}
	
}

public class FighterTest {
	public static void main(String[] args) {
		Fighter f = new Fighter(); 
		f.move(100, 200); 		
		Fighter f2 = new Fighter();
		f.attack(f2);
//		f.attack(new Fighter()); //���� 2�ٰ� ���� �ǹ�
		
		//Fightable�� �ִ� move, attack�� ȣ�Ⱑ���ϴ�. �׷��� ft.stop()�� �ȵ�.
		Fightable ft = new Fighter();
		ft.move(100, 200);
		ft.attack(ft);  //Q)��� ����?
//		ft.stop();		//����
		
		//Unit�� �ִ� move. stop�� ȣ�Ⱑ��. �׷��� u.attack()�� �Ұ���
		unit u = new Fighter();
		u.move(100, 200);
//		u.attack(new Fighter()); //����
		u.stop();
	}
}

