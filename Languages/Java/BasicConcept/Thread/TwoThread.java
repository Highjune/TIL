//������ ������ ������ �ƴѵ� ������ ���� ����
//�̰��� �������� ������
//���⼭ ������� �� 2����(�ϳ��� ����, �ٸ� �ϳ���(Thread-0)�̸��� ���� �ʾұ� ������ �̷��� ���)
//==> �׷��� �߿��� ���� tt.start()�� ���� ��������� �ұ��ϰ� ������ ���� ����.
//�� ������ ������ ������. (���ξ������ Thread-0 ������, �� 2�� �����尡 ���� ����). �׷��� �� ������ ������ �� ����
//�����带 �����Ѵٴ� ���� ���ξ����庸�� Thread-0�����带 ���� �����ٴ� ��.


public class TwoThread extends Thread{	
	public static void main(String[] args) {
		TwoThread tt = new TwoThread(); 
		tt.start();
		System.out.println(Thread.currentThread());
		
	}
	@Override
	public void run() {
		for(int i=0; i<20 ; i++) {	
			System.out.println(Thread.currentThread() + " = " + i);
			//
			
		}
	}
}
