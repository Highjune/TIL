
//���ܰ� �߻����� ���� ���
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

//���ܰ� �߻��� ���
public class Trycatchstream {
	public static void main(String[] args) {
		System.out.println(1);
		try {
			System.out.println(0/0); //���ܹ߻�
			System.out.println(2);
		} catch (Exception e) {
			System.out.println(3);
		}
		System.out.println(4);
	}
}		

