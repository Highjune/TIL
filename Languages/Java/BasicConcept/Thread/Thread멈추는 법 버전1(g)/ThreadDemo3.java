
public class ThreadDemo3 {
	public static void main(String[] args) {
		MyThread mt = new MyThread();
		Thread t = new Thread(mt);
		try {
			Thread.sleep(2000);
		}catch(InterruptedException e) {}
		t.start(); //MyThread가인터페이스의 자식이니까 바로 start못하고 이런식으로~!
		System.out.println("Thread 실행중...");
		try {
			Thread.sleep(3000);
		}catch(InterruptedException e) {}
		System.out.println("Thread를 중지하겠습니다.");
		mt.mystop();
	}
}





