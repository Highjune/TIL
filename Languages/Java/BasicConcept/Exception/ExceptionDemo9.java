/*
 * fianlly(p434)
 * ���� �� 3����
 * 1. try ~ catch ~ finally (����)
 * 2. try ~ catch
 * 3. try ~ finally
 * �� 3���� �� ����.
 * 
 * 
 * 
 */


public class ExceptionDemo5 {
	public static void main(String[] args) {
		try {
			System.out.println(5/2);
		}catch(Exception ex) {
			System.out.println(ex);
		}finally {
			System.out.println("����");//exception�� �߻����ѵ�, �� ���ѵ� �׻�!
		}
	}
}
