import javax.swing.JOptionPane; ///dialog 로 입력 받는 것. GUI로 하는 것



public class DialogGUI {
public static void main(String[] args) {
	/*
	String season = JOptionPane.showInputDialog("당신이 가장 좋아하시는 계절은?");  //그러나 무조건 string으로 받는다. 24를 입력해도 "24"로 입력받음
	JOptionPane.showMessageDialog(null, //null부분은 버튼을 어디다가 올릴 것인지임. 근데 우리는 설정 안하므로 null
			"귀하가 좋아하시는 계절은" + season + "이군요."); 
	*/
	
	// 계산기 입력하는 것 만들기
	
	String firstStr = JOptionPane.showInputDialog("첫번째 숫자 입력: ");
	int first = Integer.parseInt(firstStr); //글자("7")를 숫자(7)로 (연산을 위해 글자를 다 숫자로 바꾼다)
	String secondStr = JOptionPane.showInputDialog("두번째 숫자 입력: ");
	int second = Integer.parseInt(secondStr); //"5" --> 5
	String op = JOptionPane.showInputDialog("연산자(+, -, x, /, %) : ");
	
	switch(op) {
	case "+":
	case "-":  
		JOptionPane.showMessageDialog(null,
				first + "-" + second + "=" + (first-second));
		break;
	case "x":
	case "/":
	case "%":
		default: JOptionPane.showMessageDialog(null, "잘못된 연산자입니다");
	
	
	}
	
}

}
