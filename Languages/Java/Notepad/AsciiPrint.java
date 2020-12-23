package practice;

public class AsciiPrint {
	public static void main(String[] args) {
		char ch = '!';
//		int number = ch;
//		System.out.println(number);
			
		for(int i = 0 ; i < 95; i++) {
//			System.out.printf("%c\t", ch++);
			System.out.print(ch++ + "\t");
		}
	}
}
