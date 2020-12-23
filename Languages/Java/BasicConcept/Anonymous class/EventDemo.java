//anonymous class(자바의 정석 410) 와 local class를 어떻게 쓸지~
//event를 이용하여 ~ 
//

import java.awt.*; 
import java.awt.event.*; //1. import한다

public class EventDemo { //2. implements 한다.
	public static void main(String[] args) {
		Frame f = new Frame("나는 윈도우 프로그램");
		Button clickme = new Button("Click Me!!!");
		clickme.setBackground(Color.RED);
		clickme.addActionListener(new ActionListener() { // local class
			@Override
			public void actionPerformed(ActionEvent e) { //3. Override 한다.
				f.setBackground(Color.CYAN);
			}
		});   ////메서드 안에 클래스가 들어가고, 그 안에서 override하고 ~ .
		f.add(BorderLayout.NORTH, clickme);
		f.setBackground(Color.YELLOW);
		f.setSize(500, 400);
		f.setVisible(true);		
	};
}

