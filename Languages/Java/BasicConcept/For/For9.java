/*
 * 1. 100������ �ڿ��� �� ¦���� �� ���ϱ�
 * 2. 100������ �ڿ��� �߿��� 4�� ����̸鼭 5�� ����� �ƴ� �� ����ϱ�
 * 3. 100������ �ڿ��� �߿��� 4�� ����̸鼭 5�� ����� �� ����ϱ�
 * 4. ������ �Է¹޾� factorial ���ϱ�
 * 5. ���� 10���� �Է¹޾� �� �� ���ϱ�  
 * 
 */


//1. 100������ �ڿ��� �� ¦���� �� ���ϱ�
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


//2. 100������ �ڿ��� �߿��� 4�� ����̸鼭 5�� ����� �ƴ� �� ����ϱ�
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

//3. 100������ �ڿ��� �߿��� 4�� ����̸鼭 5�� ����� �� ����ϱ�
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

//4. ������ �Է¹޾� factorial ���ϱ�
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

//5. ���� 10���� �Է¹޾� �� �� ���ϱ�
//�迭 �Ⱦ��� Ǯ��
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
		
		
//�迭 ���� Ǯ��
						
//	}
//}




