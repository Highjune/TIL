
//public class ExceptioinDemo2 {
//	public static void main(String[] args) {
//		try {
//			System.out.println(5/0);  //exception�� �߻��� ���� ������, �ؿ� ��ٸ��� catch���� ���������� ~ 
//		}catch(NullPointerException ex) {  //try ���� Ÿ�԰� catch() ���� Ÿ���� �¾ƾ� �ȴ�. �� ������ �� ��´�.
//			System.out.println("���Դϴ�.");
//		}catch(NumberFormatException ex) {
//			System.out.println("NumberFormatException");
//		}catch(NegativeArraySizeException ex) {
//			System.out.println("Array�� ����������");  //�̱��� 3������ exception�� �� �����. Ÿ���� �޶�. �� catch�� ���� ���ٰ� �ؼ� �� ���� �� X		
//		}catch(ArithmeticException ex) {   //���⼭ ����. �� ArithmeticException ���ܿ���. 
//			System.out.println("���� �����");
//		}
//	}
//}
//���ǻ���
////1. �������� catch block�� ����� �� �ݵ�� ���� ����� �ʿ� ����.
//2. �������� catch block�� ����� ���� �θ� �ڽİ��踦 ����ؾ� �Ѵ�.(������ �θ� ��ƹ����� �ؿ��� �� �����ϱ�.)
//���� �ڽ� Exception, �Ʒ��� �θ� Exception 
//�׷��� ��� ���踦 ���� �ȴ�

public class ExceptioinDemo2 {
	public static void main(String[] args) {
		try {
			System.out.println(5/0);  // NegativeArraySizeException�� ������
//		}catch(RuntimeException ex) { RuntimeExxception �� ���� �͵��� �θ��. �׷��� ���� �� �ʿ䰡 ����. //
		}catch(NullPointerException ex) {
			System.out.println("NullPointerException.");
		}catch(RuntimeException ex) {
			System.out.println("RuntimeException.");
		}catch(Exception ex) {
			System.out.println("Exception");  //	
		}
	}
}
