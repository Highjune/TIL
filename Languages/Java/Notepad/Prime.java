package practice;

// 2~50 까지 소수(prime number) 출력하기
public class Prime {
	public static void main(String[] args) {
		
	for(int i = 2 ; i<=50 ; i++) {
		if(isPrimeNumber(i)) {
			System.out.print(i + "\t");
		}
			
	}
}	
	static boolean isPrimeNumber(int num) {
		int i;
		for(i=2 ; i<num ; i++) {
			if(num%i ==0) {
				break;
			}
		}
		if(i==num) {
			return true;
		} else {
			return false;
		}
	}	
}