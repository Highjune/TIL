package practice;


public class SequencePlus {
	public static void main(String[] args) {

		int sumNum = sum(50);
		System.out.println(sumNum);
			
	}
	
	static int sum(int number) {
		int sum = 0;
		for(int i = 1; i <= number ; i++) {
			sum += i ;
		}
		return sum;
	}
	
}
