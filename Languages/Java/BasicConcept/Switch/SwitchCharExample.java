package practice;

public class SwitchCharExample {
	public static void main(String[] args) {
		//알파벳 대소문자에 관계없이 동일하게 처리하도록 만든 switch문
		char grade = 'B';
		
		switch(grade) {
		case 'A' : // break 일부러 X
		case 'a' :
			System.out.println("우수 회원입니다.");
			break;
		case 'B' : // break 일부러 X
		case 'b' :
			System.out.println("일반 회원입니다.");
			break;
		default : 
			System.out.println("손님입니다.");
		}
	}
}
