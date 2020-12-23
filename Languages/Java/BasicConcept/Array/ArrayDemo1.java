//게속 넣다가 0나오면 넣는 것 그만하고 출력
import java.util.Scanner;

public class ArrayDemo1 {
public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int [] array = new int[100]; // 
	int start = 0;
	while(true) {						//0들어갈 때까지 다 넣는다.
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







