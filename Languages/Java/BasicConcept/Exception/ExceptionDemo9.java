/*
 * fianlly(p434)
 * 쓰는 법 3가지
 * 1. try ~ catch ~ finally (정석)
 * 2. try ~ catch
 * 3. try ~ finally
 * 위 3가지 다 가능.
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
			System.out.println("여기");//exception이 발생시켜도, 안 시켜도 항상!
		}
	}
}
