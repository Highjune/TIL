/*
 * 1+ (1+2) + (1+2+3) + ... + (1+2+ .. +50) 의 값은? 
 */

/////나의 답
//
//public class SequenceSum {
//	public static void main(String[] args) {
//		Sequence_Today_Test t = new Sequence_Today_Test();
//		int sum = t.calcsum(50);
//		System.out.println(sum);
//	
//	}
//
//int calcsum(int a) {
//		int sum = 0;
//		for(int i=1 ; i<=a ; i++) {
//			for(int j=1 ; j<=i ; j++) {
//				sum += j;						
//		}
//	}
//		int result = sum;
//		return result;
//}
//}
////////선생님 답변
public class SequenceSum{
	public static void main(String[] args) {
		int sum = 0;
		for (int i =1; i<=50 ; i++) {
			sum += add(i);
		}
		System.out.println("sum = " + sum);
	}
	static int add(int last) {
		int sum = 0;
		for(int i=0; i<=last ; i++) {
			sum+=i;
		}
		return sum;
	}
}








