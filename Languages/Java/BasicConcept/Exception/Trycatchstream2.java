
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
//	} catch (Exception e) { //ArithmeticException을 제외한 모든 예외가 처리된다. 모든 예외의 조상이니)
//		System.out.println("Exception");
//	}
//		System.out.println(6);	
//	}
//}


//예외를 잡지 못하면 비정상 종료가 됨
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