//안 나옴


public class ExceptionDemo4 {
	public static void main(String[] args) {
		
		try {
//			System.out.println(5/2);
//			System.out.println("Hello");
			int[] array = {1, 2, 3};
			System.out.println(array[3]);
		} catch (ArithmeticException | NullPointerException | NegativeArraySizeException e) {  //이 3개의 레벨이 같아야 된다. 부모가 있으면 안 된다. 
			System.out.println(e);
		} catch (RuntimeException e) {
			System.out.println(e);
		}
	}
}
	



