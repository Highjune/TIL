//Thread���ߴ� ��� ���� 2 : interrupt exception�̿� 


public class MyThread1 implements Runnable{

	private boolean flag = false;
	public void mystop() {
		this.flag = true;
	}
	
	
	@Override
	public void run() {
		// Thread�� �ؾ��� ��
		try {		
			while(true) {  ///�̷��� ���ѷ��� �����ִµ�, ���ο��� interrupt�� �ɸ�!
				Thread.sleep(500);
				System.out.println("I'm alive.");
			}
		}catch(InterruptedException ex) {  //���ܸ� ���̿��ϴ°���. ������ ���ܰ� �߻��ƴ� ���� �ٷ� �Ѿ���ϱ�.
			System.out.println("I'm dead...�Ф�");
		}	
	}	
}
	
