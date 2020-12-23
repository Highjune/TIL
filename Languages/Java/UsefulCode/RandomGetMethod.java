import java.util.*;

//자바의 정석 p503
public class RandomGetMEthod{
	public static void main(String[] args) {
		for(int i=0 ; i<10 ; i++)
			System.out.print(getRand(5, 10) + ",");
		
		System.out.println();
		
		int[] result = fillRand(new int[10], new int[] {2, 3, 7, 5});
		
		System.out.println(Arrays.toString(result));
} 
	


//////////////아래 함수 3개 유용

	//int[] fillRand(int[] arr, int from, int to) : 배열 arr을 from과 to범위의 랜덤의 값들로 채워서 반환
	public static int[] fillRand(int[] arr, int from, int to) {
		for(int i=0; i<arr.length; i++) 
			arr[i] = getRand(from, to);
		
		return arr;
	}
	
	//int[] fillRand(int[] arr, int[] data) : 배열 arr을 배열 data에 있는 값들로 랜덤으로 채워서 반환
	public static int[] fillRand(int[] arr, int[] data) {
		for(int i=0; i<arr.length; i++) 
			arr[i] = data[getRand(0, data.length-1)];
		return arr;
	}	

	//int getRand(int from, int to) : from가ㅗ to범위의 정수(int)값을 반환. from to 모두 범위에 포함.
	public static int getRand(int from, int to) {
		return (int) (Math.random() * (Math.abs(to-from)+1) ) 
					+ Math.min(from, to);
	}
}



