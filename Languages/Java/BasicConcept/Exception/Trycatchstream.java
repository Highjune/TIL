
//예외가 발생하지 않은 경우
//public class Trycatchstream {
//	public static void main(String[] args) {
//		System.out.println(1);
//		try {
//			System.out.println(2);
//			System.out.println(3);
//		} catch (Exception e) {
//			System.out.println(4);
//		}
//		System.out.println(5);
//	}
//}

//예외가 발생한 경우
public class Trycatchstream {
	public static void main(String[] args) {
		System.out.println(1);
		try {
			System.out.println(0/0); //예외발생
			System.out.println(2);
		} catch (Exception e) {
			System.out.println(3);
		}
		System.out.println(4);
	}
}		

