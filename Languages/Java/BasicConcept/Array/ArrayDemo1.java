//�Լ� �ִٰ� 0������ �ִ� �� �׸��ϰ� ���
import java.util.Scanner;

public class ArrayDemo1 {
public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int [] array = new int[100]; // 
	int start = 0;
	while(true) {						//0�� ������ �� �ִ´�.
		int su = scan.nextInt();
		if(su==0) break;
		array[start] = su;
		start++;
	}
	for(int i = 0 ; i < start ; i++) {
		System.out.printf("%d\t", array[i]);
		
	}
	System.out.println(array);
}
}







