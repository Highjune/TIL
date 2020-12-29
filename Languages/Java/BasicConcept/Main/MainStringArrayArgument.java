package practice;

public class MainStringArrayArgument {
	public static void main(String[] args) {
		if(args.length!=2) { //if numbers of input data is under two
			System.out.println("값의 수가 부족합니다.");
			// forced exit program
			System.exit(0);
		}
		String strNum1 = args[0];
		String strNum2 = args[1];
		
		int num1 = Integer.parseInt(strNum1);
		int num2 = Integer.parseInt(strNum2);
		
		int result = num1 + num2;
		System.out.println(num1 + " + " + num2 + " = " + result);
	}
}
