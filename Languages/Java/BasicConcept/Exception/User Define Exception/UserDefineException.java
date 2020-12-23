import java.util.Scanner;

//사용자 정의형 exception p439  
/*
 * 사용자 정의 예외처리를 만드는 방법
 * 1. Exception이 누구의 자식인가(누구의 자식이냐에 따라 checked 인가 unchecked 인가 따라 다르다)
 * 2. 생성자
 */

public class ExceptionDemo7 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		do {
			try {
				System.out.println("국어 점수 : ");		
				int kor = scan.nextInt();
				if(scoreCheck(kor)) break;
				else throw new RuntimeException("점수를 잘못 입력하셨습니다.");
			}catch(RuntimeException ex) {
				System.out.println(ex.getMessage());
				
			}
		}while(true);  //국어점수 제대로 넣을 때까지 무한루프
	
	}
	
	static boolean scoreCheck(int jumsu) {
		if(jumsu >= 0 && jumsu <= 100) return true;
		else return false;	
	}
}

