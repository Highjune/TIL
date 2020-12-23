package test;

import java.awt.Toolkit;

// 2) use working thread including main thread
public class BeepPrintExample2 {
	public static void main(String[] args) {
		/*
		 * 	Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				@Override
				public void run() {
					Toolkit toolkit = Toolkit.getDefaultToolkit();
					for(int i = 0 ; i<5; i++) {
						toolkit.beep();
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		
		}
		Thread thread = new Thread(beepTask);
		 */
	
		Runnable beepTask = new BeepTask();
		Thread thread = new Thread(beepTask);
		thread.start(); // exceute run() method in BeepTask class
		
		for(int i = 0 ; i<5 ; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
