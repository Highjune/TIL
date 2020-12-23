//순서가 메인이 먼저가 아닌데 메인을 먼저 찍음
//이것이 쓰레드의 원리임
//여기서 쓰레드는 총 2개다(하나는 메인, 다른 하나는(Thread-0)이름을 주지 않았기 때문에 이렇게 뜬다)
//==> 그런데 중요한 것은 tt.start()를 먼저 찍었음에도 불구하고 메인이 먼저 떴다.
//즉 메인이 무조건 먼저임. (메인쓰레드와 Thread-0 쓰레드, 이 2개 쓰레드가 서로 경쟁). 그러나 이 순서를 조작할 수 있음
//쓰레드를 조작한다는 것은 메인쓰레드보다 Thread-0쓰레드를 먼저 돌린다는 말.


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
