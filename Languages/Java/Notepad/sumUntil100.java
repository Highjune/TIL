package test;

//1+2+.. 까지 더했을 때 100을 넘지 않은 정도까지의 합 
public class sumUntil100 {
	public static void main(String[] args) {
		int sum = 0;
		int i = 0 ;
		
		while(sum<=100) {
			System.out.printf("%d - %d%n", i, sum);
			sum += ++i;			
		}
		
	}
}
