//���� ���� ���

import java.util.Scanner;

public class BMI_Me {
	public static void main(String[] args) {
		
		String name;
		int age;
		double height;
		double weight;		
		String into;
		
		Scanner sc = new Scanner(System.in);  
		System.out.println("�̸� : ");
		name = sc.next();
		
		System.out.println("���� :");
		age = sc.nextInt();
		
		System.out.println("Ű(m) :");
		height = sc.nextDouble();
		
		System.out.println("������(kg) :");
		weight = sc.nextDouble();
		
		System.out.printf("%s ��(%d��)�� BMI������ %f�Դϴ�.", name, age, weight/(height*height));
		
	
	}
}