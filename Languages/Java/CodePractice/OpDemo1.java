import java.util.Scanner;

public class OpDemo1 {
public static void main(String[] args) {
//윤년 구하는 방법
//윤년 조건  //400년마다 딱 떨어지면 윤년 or (4년의 배수이면서 100의 배수는 x)
	Scanner scan = new Scanner(System.in);
	System.out.print("Year : ");
	int year = scan.nextInt();
	
	String result = ((year % 400 == 0) || 
			(year%4 ==0 && year%100 !=0)) ? 
					"윤년입니다." : "윤년이 아닙니다.";
	System.out.printf("%d년은 %s\n", year, result);
	
}
}
