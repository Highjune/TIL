//yield
public class ThreadDemo4 implements Runnable{
	public static void main(String[] args) {
		
		ThreadDemo4 td = new ThreadDemo4();
		Thread sujan = new Thread(td, "Sujan");
		Thread smith = new Thread(td, "Smith"); //쓰레드가 총 3개, 메인/sujan/smith
		sujan.start();
		smith.start();
	
	}
	
	@Override
	public void run() {
		for(int i=0; i<20 ;i++) {
			Thread.yield(); //이것이 없으면 sujan과 smith가 랜덤으로 섞여 나온다.할때마다 다름
			System.out.println(Thread.currentThread().getName() + " : " + i); 
		}
	}
}