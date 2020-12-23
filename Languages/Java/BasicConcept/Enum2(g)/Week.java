package practice;

public enum Week { // 열거 타입 이름. 관례) 첫 글자만 대문자
	// 열거 상수들 . 관례) 모두 대문자
	// 7개의 객체가 생성된다. 아래 열거 상수들(메소드 영역에 생성, 객체의 주소를 갖고 있음)은 힙 영역에 생성된 7가지 요일 객체의 주소를 갖고 있다.
	// 열거 상수는 객체를 가리킬 뿐 객체가 아니다.
	
	SUNDAY,
	MONDAY,
	TUESDAY,
	WEDNESDAY,
	THURSDAY,
	FRIDAY,
	SATURDAY,			
	
	//열거 상수가 여러 단어로 구성될 경우에는 단어 사이를 밑줄(_)로 연결하는 것이 관례
	LOGIN_SUCCESS, LOGIN_FAILED
	
}
