
//Syntax Error => Compile Error
//Symantec Error(�ǹ��� ������) => Runtime Error ==> Exception.  //������ ������ �ƴ�. 

//import java.util.Scanner;

//public class ExceptionDemo {
//	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		System.out.print("ù��° ���� : ");	
//		int first = scan.nextInt();
//		System.out.print("�ι��� ���� : ");
//		int second = scan.nextInt();
//		try {//exception�� ���ɼ��� �ִ� ���� try�� ����, �� ���� ��ü�ϴ� ���� catch
//			System.out.println(first / second);
//	}catch(Exception ex) {
//		System.out.println("����ó������");
//	}	
//	}
//}



//import java.util.Scanner;
//
//public class ExceptionDemo {
//	public static void main(String[] args) {
//
//		String str = "������";
//		System.out.println(str); //������
//		str = null;
//		System.out.println(str);  //null
//		
//		Car sonata = new Car(); 
//		sonata.price = 25_000_000;
//		System.out.println(sonata.price);
//		sonata = null;
//		System.out.println(sonata.price);		//NullPointerException
//	}	
//}
//
//class Car{
//	 int price;
//}
//��� ������ ������ �˰� �ʹٸ�, API �������� �� �θ� ����!. Runtimeexception �̶�� unchecked exception��. �� try catch �� �ᵵ ��






//import java.util.Scanner;
//
//public class ExceptionDemo {
//	public static void main(String[] args) {
//
//		Scanner scan = new Scanner(System.in);
//		System.out.println("���� � ������ ? ");
//		int size = scan.nextInt();
//		int [] array = new int[size];	
//		//�迭�� ��Ÿ�� �� �����. �׷��� ���� ������ -�� �Է��ϸ� ! runtime exeption�� �ڽ�. ����� compile�� �� ������ �߻����� �ʴ´�.
//		System.out.println("�氹�� : " + array.length);
//		
//	}	
//	}




import java.util.Scanner;

public class ExceptionDemo {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("������ ���� : ");
		String str = scan.next();// "4" --> 4 �� ����
		int su = Integer.parseInt(str);
		System.out.printf("su = %d\n", su);  //���� ������ �߸��� ���� ������? �׷��� ���� Hello�� ������??.... numberformat exception �̶�� ���.
		//�׷��� API���� numberformat ã�Ƽ� ���� ������ Runtimeexception �̰� �̰��� Unchecked exception �̴�. 
		//��, Runtimeexception �� �ڽİ� error�� �ڽ��� ��� �� Unchecked exception.
		
	}	
	}






