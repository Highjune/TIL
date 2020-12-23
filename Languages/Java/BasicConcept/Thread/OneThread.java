
public class OneThread {
	public static void main(String[] args) {
		OneThread ot = new OneThread();
		ot.go();
		System.out.println(Thread.currentThread());
		
	}
	void go() {
		for(int i=0; i<20 ; i++) {
			System.out.println("go() i = " + i);
			
		}
	}
}
