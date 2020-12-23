선생님이 한 방법

import java.util.Scanner;

public class BMI_Teacher {	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);  // keyboard, standard input
		System.out.print("이름 : ");		String name = scan.nextLine();
		System.out.print("나이 : ");		int age= scan.nextInt();
		System.out.print("키 : ");		double height = scan.nextDouble();
		System.out.print("몸무게 : "); 	double weight = scan.nextDouble();
		
		Double result = weight / (height*height) * 10000;
		System.out.printf("%s님(%d세)의 BMI의 지수는 %.1f입니다.\n",
				name, age, result);
	
}
}


