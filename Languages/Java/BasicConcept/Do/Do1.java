//여러개의 숫자를 입력받아서 그 중 가장 큰수와 작은 수를 출력하기, 단, 입력 시 0이 들어오면 끝
//ex) 3 2 -4 8 9 0
import java.util.Scanner;
public class Do1 {
	public static void main(String[] args) {

	Scanner scan = new Scanner(System.in);
	
	int num, max = 0, min = 0;
	while((num = scan.nextInt())!=0) {
		if(max < num) max = num;			
		if(min > num)  min = num;		
	}
	System.out.println("가장 큰 값 " + max);
	System.out.println("가장 작은 값 " + min);
	}
}