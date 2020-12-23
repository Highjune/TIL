//yield
public class ThreadDemo4 implements Runnable{
	public static void main(String[] args) {
		
		ThreadDemo4 td = new ThreadDemo4();
		Thread sujan = new Thread(td, "Sujan");
		Thread smith = new Thread(td, "Smith"); //�����尡 �� 3��, ����/sujan/smith
		sujan.start();
		smith.start();
	
	}
	
	@Override
	public void run() {
		for(int i=0; i<20 ;i++) {
			Thread.yield(); //�̰��� ������ sujan�� smith�� �������� ���� ���´�.�Ҷ����� �ٸ�
			System.out.println(Thread.currentThread().getName() + " : " + i); 
		}
	}
}