//내가 만든 방법

import java.util.Scanner;

public class BMI_Me {
	public static void main(String[] args) {
		
		String name;
		int age;
		double height;
		double weight;		
		String into;
		
		Scanner sc = new Scanner(System.in);  
		System.out.println("이름 : ");
		name = sc.next();
		
		System.out.println("나이 :");
		age = sc.nextInt();
		
		System.out.println("키(m) :");
		height = sc.nextDouble();
		
		System.out.println("몸무게(kg) :");
		weight = sc.nextDouble();
		
		System.out.printf("%s 님(%d세)의 BMI지수는 %f입니다.", name, age, weight/(height*height));
		
	
	}
}