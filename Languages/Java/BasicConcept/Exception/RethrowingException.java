
public class RethrowingException {
	public static void main(String[] args) {
		try {
			method1();
		} catch (Exception e) {
			System.out.println("Main�޼��忡�� ���ܰ� ó���Ǿ����ϴ�.");
		}
	}
	
	
	static void method1() throws Exception{
		try {
			throw new Exception();
		} catch (Exception e) {
			System.out.println("method1�޼��忡�� ���ܰ� ó���Ǿ����ϴ�");
			throw e; //�ٽ� ���ܸ� �߻���Ų��.
		}
	} 
}
