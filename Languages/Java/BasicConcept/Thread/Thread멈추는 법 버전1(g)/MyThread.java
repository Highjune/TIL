//Thread�� ���ߴ� �� : boolean���� �̿�

//��� �̰��� ������ �����Լ����� mystop�� �θ��� ���� �� �ٷ� ���ߴ� ���� �ƴϴ�.
//���� while������ if(this.flag) break; ���� �������� �ڵ尡 �ִٸ� �װ͵��� �� ����ǰ� ���� if���� ����Ǳ� ������ 
//���� �ɸ���
//�׷��� ����2�� interrupt�� �̿��ؼ� �غ���~!
 

public class MyThread implements Runnable{

	private boolean flag = false;
	public void mystop() {
		this.flag = true;
	}
	
	
	@Override
	public void run() {
		// Thread�� �ؾ��� ��
		while(true) {  //sleep�� 0.5�ʾ� ��� �����ٰ� if���� ���̸� while���� �����µ�, ������ �Ϸ��� ���� mystop�� ȣ���ϸ� �ȴ�.
			try {
				Thread.sleep(500);
			}catch(InterruptedException ex) {}
			System.out.println("I'm alive.");
			if(this.flag) break;  
			
		}
		System.out.println("I'm dead...�Ф�"); 	
	}
	

}
