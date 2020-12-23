import java.util.Scanner;
import java.util.Calendar;

public class BMIUpgrade {	
	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();
		int current_year = now.get(Calendar.YEAR);
		
		Scanner scan = new Scanner(System.in);  // keyboard, standard input
		System.out.print("�̸� : ");		String name = scan.nextLine();
		System.out.print("����⵵ : ")	;	int born_year= scan.nextInt();
		int age = current_year-born_year +1;
		System.out.print("Ű : ");		double height = scan.nextDouble();
		System.out.print("������ : "); 	double weight = scan.nextDouble();
			
		Double bmi = weight / (height*height) * 10000;
		String result = (bmi >=40) ? "����" :
			(bmi >= 35 && bmi < 40)? "�ߵ ��" :
				(bmi >= 30 && bmi < 35)? "�浵 ��" :
					(bmi >= 25 && bmi < 30)? "��ü��" :
						(bmi >= 18.5 && bmi < 25)? "����" : "��ü��";
		
		System.out.printf("%s��(%d��) : %.1f(%s)", name, age, bmi, result);
			
		
}
}



