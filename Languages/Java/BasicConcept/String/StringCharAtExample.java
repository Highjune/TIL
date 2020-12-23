package test;

public class StringCharAtExample {
	public static void main(String[] args) {
		String jumin_number = "790321-1675167";
		char sex_number = jumin_number.charAt(7);
		
		switch(sex_number) {
			case '1' : 
			case '3' :
				System.out.println("남자입니다.");
				break ;
			case '2' :
			case '4' :
				System.out.println("여자입니다.");
				break ; 				
		}
	}
}
