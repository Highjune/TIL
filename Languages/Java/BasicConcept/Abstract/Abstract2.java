
//////////////
//�߻�޼ҵ�
//�޼ҵ�- > �߻� �޼ҵ尡 �Ǹ� �ڽ��� ���� Ŭ������ �ݵ�� �߻��� �ɼ��ۿ� ����.
//API�߿��� ��� Ŭ������ �߻��̶��, �ϴ� �� Ŭ������ new�� �� �����, �� �ڽ��� ���ؼ� new�� ������ �Ѵ�.
//�׸��� �ڽ��� ������ �ִ� 100���� �޼ҵ� �߿� 1������ �߻��̶�� �ڽŵ� �߻��� �Ǿ�� �Ѵ�.


public class Abstract2 {
	public static void main(String[] args) {
		Birds buz = new Sparow(); //Birds�� �߻��̹Ƿ� new�� �� ����� ������ �� Birds�� �ڽ��� ���ؼ� �����.
		buz.display();
		
	}
}

abstract class Birds{   //���� display()�տ� abstract�� �پ��� ������ �߻�޼ҵ带 �����ϴ� Ŭ������ �ݵ�� abstract�� �پ�� �Ǽ� �ٴ´�.
	int numOfWings = 2;
	public abstract void display(); //�޼ҵ忡���� {}�� ���� ���� �߻�޼ҵ� ��� �Ѵ�. ��, �����ΰ� �����Ƿ�
}

class Sparow extends Birds{
	//�θ��� �޼ҵ尡 �߻�޼ҵ�� �ڽ��� �ݵ��!! ������ �ؾ� �ȴ�.�������̵��� ���ϸ� �ȵȴ�.
	public void display() {
		System.out.println("�ڽĿ��� ��������.");  //
	}
}




