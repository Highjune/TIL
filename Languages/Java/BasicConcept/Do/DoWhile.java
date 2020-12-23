import java.util.Scanner;

//1부터 100까지의 특정 수 중에서 답이 맞을 때까지(up down)
public class DoWhile {
	public static void main(String[] args) {
		int input = 0, answer = 0;
		
		answer = (int)(Math.random()*100) + 1; //1~100사이의 수
		Scanner scan = new Scanner(System.in);
		
		do {
			System.out.println("1부터 100사이의 정수를 입력하세요");
			input = scan.nextInt();
			
			if(input > answer) {
				System.out.println("더 작은 수로 다시 시도해보세요");
			} else if (input < answer) {
				System.out.println("더 큰 수로 다시 시도해보세요");
			}			
		}while(input!=answer);
		
		System.out.println("정답입니다.");
		
	}
}
