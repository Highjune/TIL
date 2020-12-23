package test;

import java.awt.Toolkit;

// 1) Case that Only use Main Thread
// result is that 5 times "beep" sound first and print "띵" 5 times

public class BeepPrintExample {
	public static void main(String[] args) {
		Toolkit toolkit = Toolkit.getDefaultToolkit(); // get ToolKit Object
		for(int i = 0 ; i <5 ; i++) {
			toolkit.beep(); // generate "beep" sound
			try {
				// 0.5 seconds pause
				Thread.sleep(500); 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
		}
		for(int i = 0 ; i <5 ; i++) {
			System.out.println("띵");
			// 0.5 seconds pause
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
	}
}
