import javax.swing.JOptionPane; ///dialog �� �Է� �޴� ��. GUI�� �ϴ� ��



public class DialogGUI {
public static void main(String[] args) {
	/*
	String season = JOptionPane.showInputDialog("����� ���� �����Ͻô� ������?");  //�׷��� ������ string���� �޴´�. 24�� �Է��ص� "24"�� �Է¹���
	JOptionPane.showMessageDialog(null, //null�κ��� ��ư�� ���ٰ� �ø� ��������. �ٵ� �츮�� ���� ���ϹǷ� null
			"���ϰ� �����Ͻô� ������" + season + "�̱���."); 
	*/
	
	// ���� �Է��ϴ� �� �����
	
	String firstStr = JOptionPane.showInputDialog("ù��° ���� �Է�: ");
	int first = Integer.parseInt(firstStr); //����("7")�� ����(7)�� (������ ���� ���ڸ� �� ���ڷ� �ٲ۴�)
	String secondStr = JOptionPane.showInputDialog("�ι�° ���� �Է�: ");
	int second = Integer.parseInt(secondStr); //"5" --> 5
	String op = JOptionPane.showInputDialog("������(+, -, x, /, %) : ");
	
	switch(op) {
	case "+":
	case "-":  
		JOptionPane.showMessageDialog(null,
				first + "-" + second + "=" + (first-second));
		break;
	case "x":
	case "/":
	case "%":
		default: JOptionPane.showMessageDialog(null, "�߸��� �������Դϴ�");
	
	
	}
	
}

}
