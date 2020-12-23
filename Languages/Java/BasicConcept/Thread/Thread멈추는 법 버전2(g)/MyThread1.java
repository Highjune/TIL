//Thread멈추는 방법 버전 2 : interrupt exception이용 


public class MyThread1 implements Runnable{

	private boolean flag = false;
	public void mystop() {
		this.flag = true;
	}
	
	
	@Override
	public void run() {
		// Thread가 해야할 일
		try {		
			while(true) {  ///이렇게 무한루프 돌고있는데, 메인에서 interrupt을 걸면!
				Thread.sleep(500);
				System.out.println("I'm alive.");
			}
		}catch(InterruptedException ex) {  //예외를 역이용하는것임. 위에서 예외가 발새아는 순간 바로 넘어오니까.
			System.out.println("I'm dead...ㅠㅠ");
		}	
	}	
}
	
