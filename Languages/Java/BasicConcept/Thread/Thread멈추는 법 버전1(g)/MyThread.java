//Thread를 멈추는 법 : boolean변수 이용

//대신 이것의 단점은 메인함수에서 mystop을 부르고 나서 꼭 바로 멈추는 것이 아니다.
//만약 while문에서 if(this.flag) break; 위에 수백줄의 코드가 있다면 그것들이 다 실행되고 나서 if문이 실행되기 때문에 
//오래 걸린다
//그래서 버전2는 interrupt를 이용해서 해보자~!
 

public class MyThread implements Runnable{

	private boolean flag = false;
	public void mystop() {
		this.flag = true;
	}
	
	
	@Override
	public void run() {
		// Thread가 해야할 일
		while(true) {  //sleep을 0.5초씩 계속 돌리다가 if문이 참이면 while문이 끝나는데, 끝나게 하려면 위의 mystop을 호출하면 된다.
			try {
				Thread.sleep(500);
			}catch(InterruptedException ex) {}
			System.out.println("I'm alive.");
			if(this.flag) break;  
			
		}
		System.out.println("I'm dead...ㅠㅠ"); 	
	}
	

}
