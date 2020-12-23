
public class UncheckedException {
	public static void main(String[] args) {
		//RuntimeException과 그 자손은 예외처리를 해주지 않아도 컴파일 된다(선택)
		throw new RuntimeException(); //예외처리가 필수적이지 않다. 컴파일은 되지만 실행시 에러
	}
}
