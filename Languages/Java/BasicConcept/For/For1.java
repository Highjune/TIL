import java.util.Scanner;

public class For1 {
	public static void main(String[] args) {
//		 유저가 원하는 숫자부터 우리가 원하는 숫자까지 더하기
		Scanner scan = new Scanner(System.in);
		System.out.print("얼마부터 더할까요? : ");
		int start = scan.nextInt();
		System.out.print("얼마까지 더할까요? : ");
		int last = scan.nextInt();
		int sum = 0; 
		for(int i=1 ; i<=last ; i++) {  
			sum +=i;
		}
		System.out.println(start + "1부터 " + last  + "까지의 합은 " + sum);
	}
}