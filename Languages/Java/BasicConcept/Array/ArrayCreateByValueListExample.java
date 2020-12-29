package practice;

public class ArrayCreateByValueListExample {
	public static void main(String[] args) {
		int[] scores;
//		scores = {83, 90, 87}; // cannot. compile error 
		scores = new int[] {83, 90, 87};
		int sum1 = 0;
		for(int i = 0; i<3; i++) {
			sum1 += scores[i];
		}
		System.out.println("총합 : " + sum1);
		
		int sum2 = add(new int[] {83, 90, 97});
		System.out.println("총합 : " + sum1);
		System.out.println();
	}
	
	public static int add(int[] scores) {
		int sum = 0;
		for(int i = 0 ; i <3; i++) {
			sum += scores[i];
		}
		return sum;
	}
}
