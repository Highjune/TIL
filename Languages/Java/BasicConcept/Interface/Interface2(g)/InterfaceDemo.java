//�ڹ��� ���� p381
//5. interface�� instantiation�� �� �� ����. �׷��� ���������� �����ؾ� �ȴ�.


public class InterfaceDemo {
	public static void main(String[] args) {
//		Weekable w = new Weekable(); // interface�� ������ �߻�Ŭ������ new�� �� ����. ���������� �ؾ� �ȴ�. ���� �Ʒ��� ����.
		Weekable w = new Week();
		w.set(Weekable.THU); //static�̹Ƿ� new�� �� �ʿ� ����, Ŭ���� �̸�! �Ǵ� �������̽� �̸�(Weekable.) �� ����
//				Weekable.FRI = 100; //�ȵȴ�. ��� ���� �ȵ�.
		System.out.println("������" + w.get() + "�����Դϴ�.");
	}
}
		

