
public class CheckedException {
	public static void main(String[] args) {
		//Exception과 그 자손은 반드시 예외처리를 해줘야 한다.(필수)
		throw new Exception(); //컴파일 에러남. 컴파일 조차 안됨. 예외처리 필수
//		throw new RuntimeException(); //컴파일 성공. 단, 에러발생
	}
}
