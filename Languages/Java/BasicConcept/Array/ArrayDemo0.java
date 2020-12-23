//배열에 넣어서 최대값과 최소값 : 자바의 정석 p197 예제 5-6
import java.util.Scanner;
public class ArrayDemo0 {
	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int[] array = new int[10];
	for(int i = 0 ; i<array.length; i++) {
		array[i] = scan.nextInt();
	}  //입력끝

	int max = array[0], min = array[0];
	int i = 1; //초기식, max를 제일 앞(0)에 넣었으니까 1번과 비교하면 됨.
	while(i < array.length) { //조건
		if(max < array[i]) 
			max = array [i];
		if(min < array[i]) 
			min = array [i];
		i++; // 증감식 (무한 루프 돌면 안되기 때문에)
	}
	System.out.println("max = " + max + ", min =" + min);
}
}