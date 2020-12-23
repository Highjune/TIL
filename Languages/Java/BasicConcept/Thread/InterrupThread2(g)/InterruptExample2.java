package test;

public class InterruptExample2 {
	public static void main(String[] args) {
		Thread thread = new PrintThread2_1();
		thread.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
