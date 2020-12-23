//userdefined exception
public class MyException extends Exception {
	MyException(String msg) {	//문자열을 매개변수로 받는 생성자
		super(msg); //조상인 Exception클래스의 생성자를 호출한다.
	}
}
