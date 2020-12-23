package test;

import java.awt.Toolkit;

public class SleepExample {
	public static void main(String[] args) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for(int i = 0 ; i<10; i++) {
			toolkit.beep();
				//move MainThread to "pause state" for 3 seconds.
				try { 
					Thread.sleep(3000);
				} catch(InterruptedException e) {}
		}
	}
}
