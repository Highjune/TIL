

public class EnglishException extends RuntimeException {  //RuntimeException으로 사용자 정의하면 ~
	private String message;

	public EnglishException(String message) {
		super(message);
	}

}


