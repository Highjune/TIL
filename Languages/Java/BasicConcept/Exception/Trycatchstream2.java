
//public class Trycatchstream2 {
//	public static void main(String[] args) {
//		System.out.println(1);
//		System.out.println(2);
//	try {
//		System.out.println(3);
//		System.out.println(0/0);
//		System.out.println(4);
//	} catch (ArithmeticException ae) {
//		if(ae instanceof ArithmeticException)
//		System.out.println("true");
//		System.out.println("ArithmeticException"); 
//	} catch (Exception e) { //ArithmeticException�� ������ ��� ���ܰ� ó���ȴ�. ��� ������ �����̴�)
//		System.out.println("Exception");
//	}
//		System.out.println(6);	
//	}
//}


//���ܸ� ���� ���ϸ� ������ ���ᰡ ��
public class Trycatchstream2 {
	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);
	try {
		System.out.println(3);
		System.out.println(args[0]); //ArrayIndexOutof~ Exception
		System.out.println(4);
	} catch (ArithmeticException ae) {
		if(ae instanceof ArithmeticException)
		System.out.println("true");
		System.out.println("ArithmeticException"); 
	}
		System.out.println(6);	
	}
}