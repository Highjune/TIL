import java.util.Scanner;
import java.util.Calendar;

public class BMIUpgrade {	
	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();
		int current_year = now.get(Calendar.YEAR);
		
		Scanner scan = new Scanner(System.in);  // keyboard, standard input
		System.out.print("이름 : ");		String name = scan.nextLine();
		System.out.print("출생년도 : ")	;	int born_year= scan.nextInt();
		int age = current_year-born_year +1;
		System.out.print("키 : ");		double height = scan.nextDouble();
		System.out.print("몸무게 : "); 	double weight = scan.nextDouble();
			
		Double bmi = weight / (height*height) * 10000;
		String result = (bmi >=40) ? "고도비만" :
			(bmi >= 35 && bmi < 40)? "중등도 비만" :
				(bmi >= 30 && bmi < 35)? "경도 비만" :
					(bmi >= 25 && bmi < 30)? "과체중" :
						(bmi >= 18.5 && bmi < 25)? "정상" : "저체중";
		
		System.out.printf("%s님(%d세) : %.1f(%s)", name, age, bmi, result);
			
		
}
}



