
public class ThreadDemo3 {
	public static void main(String[] args) {
		MyThread mt = new MyThread();
		Thread t = new Thread(mt);
		try {
			Thread.sleep(2000);
		}catch(InterruptedException e) {}
		t.start(); //MyThread���������̽��� �ڽ��̴ϱ� �ٷ� start���ϰ� �̷�������~!
		System.out.println("Thread ������...");
		try {
			Thread.sleep(3000);
		}catch(InterruptedException e) {}
		System.out.println("Thread�� �����ϰڽ��ϴ�.");
		mt.mystop();
	}
}





