�������� �� ���

import java.util.Scanner;

public class BMI_Teacher {	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);  // keyboard, standard input
		System.out.print("�̸� : ");		String name = scan.nextLine();
		System.out.print("���� : ");		int age= scan.nextInt();
		System.out.print("Ű : ");		double height = scan.nextDouble();
		System.out.print("������ : "); 	double weight = scan.nextDouble();
		
		Double result = weight / (height*height) * 10000;
		System.out.printf("%s��(%d��)�� BMI�� ������ %.1f�Դϴ�.\n",
				name, age, result);
	
}
}


