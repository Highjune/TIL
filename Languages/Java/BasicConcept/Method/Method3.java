import java.util.Scanner;

public class Method3 {
	public static void main(String[] args) {
		Method3 md = new Method3();
		int choice = md.showMenu();
		switch(choice) {
			case 1 :  md.add(5,  9); break;
			case 2 :  md.subtract(5,  9); break;
			case 3 :  md.multiply(5, 9); break;
			case 4 :  md.divide(5, 9);  break;
			case 5 :  md.moduls(5, 9); break;
		}
	}
	int showMenu(){
		System.out.println("******�ֿ� �޴���******");
		System.out.println("1 : ���ϱ�");
		System.out.println("2 : ����");
		System.out.println("3 : ���ϱ�");
		System.out.println("4 : ������");
		System.out.println("5 : ������");
		Scanner scan = new Scanner(System.in);
		System.out.print("��ȣ ���� : ");
		int choice = scan.nextInt();
		return choice;
	}
	void add(int a, int b){ 	
		System.out.println("called by add() : " + (a + b)); 
	}
	void subtract(int a, int b){ 
		System.out.println("called by subtract() : " + (a - b));
	}
	void multiply(int a, int b){ 
		System.out.println("called by multiply() : " + (a * b));
	}
	void divide(int a, int b){    
		System.out.println("called by divide() : " + (a / b));
	}
	void moduls(int a, int b){  
		System.out.println("called by moduls() : " + (a % b));
	}
}
