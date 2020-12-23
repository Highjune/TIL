package test;

import java.awt.Toolkit;

public class BeepPrintExample4 {
	public static void main(String[] args) {
		Thread thread = new BeepThread();
		/*
		 * 	@Override
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
		 */
		thread.start();
		
		for(int i = 0 ; i<5 ; i++) {
			System.out.println("띵");
			try {
			Thread.sleep(500);
			} catch(Exception e) {
				
			}
		}
	}
}
