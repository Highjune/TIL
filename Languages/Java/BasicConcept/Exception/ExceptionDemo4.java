//�� ����


public class ExceptionDemo4 {
	public static void main(String[] args) {
		
		try {
//			System.out.println(5/2);
//			System.out.println("Hello");
			int[] array = {1, 2, 3};
			System.out.println(array[3]);
		} catch (ArithmeticException | NullPointerException | NegativeArraySizeException e) {  //�� 3���� ������ ���ƾ� �ȴ�. �θ� ������ �� �ȴ�. 
			System.out.println(e);
		} catch (RuntimeException e) {
			System.out.println(e);
		}
	}
}
	



