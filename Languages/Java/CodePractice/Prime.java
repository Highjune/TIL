// * 2. 2부터 50까지 소수(prime number)출력하기
//다시 보기

//선생님 답
public class Prime {
	public static void main(String[] args) {
		for(int i = 2; i <=50 ; i++){
			if(isPrime(i)) System.out.printf("%d\t", i);
				
			}
		}
	static boolean isPrime(int su) {
		int i;
		for(i = 2; i<su ;i++) {
			if(su%i == 0 )
				break; // 자기자신-1까지 중에서 자신을 나눌 수 있는 수가 있으면 -> true -> break 되어서 나감
			}
		if(i == su)return true;
		else return false;
			//
	}
	}
