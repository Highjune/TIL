//개발자가 자신의 코드를 검증하는 방법


public class AssertionDemo {
	public static void main(String[] args) {
		int sum = 0;
		int i = 0; //for문이 끝나도 i가 살아있도록 밖에 선언
		for(i = 1; i<=50 ; i++) {
			sum+=1;
		}
		
		assert (i == 51) : "루프 에러"; //i==51이면(위의 루프가 50번 돌았다는 말) 통과, 아니라면 메세지
		assert ( sum > 50 ) : "합계에 에러 발생";
		
		System.out.println("sum = " + sum);
		}
	}
//이클립에서 하는 방법 run  - run as - run configurations - arguments tab에 -ea 넣기 - run



