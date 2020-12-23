package practice;

/*
 * 1+ (1+2) + (1+2+3) + ... + (1+2+ .. +50) 의 값은? 
 */

// 내가 푼 것
//public class SequenceSum {
//	public static void main(String[] args) {
//	
//		int sumNum = add(50);
//		System.out.println(sumNum);
//		
//	}
//	
//	static int add(int num) {
//		int sum = 0;
//		for(int i = 1; i <= num ; i++) {
//			for(int j=1 ; j<=i ; j++) {
//				sum += j;
//			}
//		}
//		return sum;
//	}
//}

// 선생님 답(한번 보고 직접 내가 만듬)
public class SequenceSum{
	public static void main(String[] args) {
	
		int total = 0;
		for(int i = 0 ; i <= 50 ; i++) {
			total += add(i);
		}
		System.out.println("total sum : " + total);
	}
	
	static int add(int num) {
		int sum = 0;
		for(int i = 1 ; i <= num ; i++) {
			sum += i;
		}
		return sum;
	}
	
}



















