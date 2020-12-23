package test;

public class StringIndexOfExample {
	public static void main(String[] args) {
		String bookName = "자바 프로그래밍";
		int location = bookName.indexOf("프로그래밍");
		System.out.println(location); //3
		
		if(bookName.indexOf("자바") != -1) {
			System.out.println("자바와 관련된 책이군요");
		} else {
			System.out.println("자바와 관련이 없는 책이군요"); //자바와 관련된 책이군요

		}
	}
}
