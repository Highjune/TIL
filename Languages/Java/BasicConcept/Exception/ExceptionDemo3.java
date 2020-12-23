
//에러메시지 출력하는 3가지 방법.

public class ExceptionDemo3 {
	public static void main(String[] args) {
		try {
			System.out.println(5/0); //이 오류는 arithmeticException을 던진다.
			// Exception이 발생하면 (arithmeticException)을 던진다.
		}catch(Exception ex) { //ex = new artihmeticException();  ex는 주소이다!!
//			System.out.println(ex.getMessage());   //1. 가장 두리뭉실하게 찍는 것 (user에게는 getMessage를 뿌리기)
//			System.out.println(ex);//2. ex.toString()으로 타입까지 찍기. 좀 더 디테일해짐.
			
			//3. 제일디테일하게
			ex.printStackTrace();			//3. 제일 디테일하게 라인까지 찍기 (개발자에게는 2, 3번을 해주기)
			
		}
	}
	
}





