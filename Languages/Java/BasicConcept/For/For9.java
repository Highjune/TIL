/*
 * 1. 100이하의 자연수 중 짝수의 합 구하기
 * 2. 100이하의 자연수 중에서 4의 배수이면서 5의 배수가 아닌 값 출력하기
 * 3. 100이하의 자연수 중에서 4의 배수이면서 5의 배수인 값 출력하기
 * 4. 정수를 입력받아 factorial 구하기
 * 5. 정수 10개를 입력받아 그 합 구하기  
 * 
 */


//1. 100이하의 자연수 중 짝수의 합 구하기
/*
public class For9 {
	public static void main(String[] args) {	
		int sum = 0;
		for(int i=1; i<=100; i++)
			if(i%2 ==0 ) {
			sum = sum + i;
			}
		System.out.println(sum);
}
}
*/


//2. 100이하의 자연수 중에서 4의 배수이면서 5의 배수가 아닌 값 출력하기
/*
public class For9 {
	public static void main(String[] args) {	
		for(int i =0 ; i<=100 ; i++)
			if(i%4 ==0 && i%5 != 0) {
				System.out.println(i);				
			}
}
}
*/

//3. 100이하의 자연수 중에서 4의 배수이면서 5의 배수인 값 출력하기
/*
public class For9 {
	public static void main(String[] args) {	
		for(int i=0 ; i<=100 ; i++)
			if(i%4 ==0 && i%5 == 0) {
				System.out.println(i);				
			}
}
}

*/

//4. 정수를 입력받아 factorial 구하기
/*
import java.util.Scanner;
public class For9 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int result = 1;
		for(int i=1; i<=n ; i++) {
			result = result*i;
		}
		System.out.println(result);
						
	}
}
*/

//5. 정수 10개를 입력받아 그 합 구하기
//배열 안쓰고 풀기
/*
import java.util.Scanner;
public class For9 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int sum = 0;
		
		for(int i=1; i<=10; i++) {
			sum += scan.nextInt();
		}
		System.out.println(sum);
*/		
		
		
//배열 쓰고 풀기
						
//	}
//}




