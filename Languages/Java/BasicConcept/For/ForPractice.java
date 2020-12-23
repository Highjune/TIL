//무한루플
//public class ForPractice {
//	public static void main(String[] args) {
//		for(int i=10 ; 1>=1 ; i--) {
//			System.out.println(i);
//		}
//	}
//}


//public class ForPractice {
//	public static void main(String[] args) {
//		for(int i=1, j=10 ; i<=10 ; i++, j--) {
//			System.out.println("i=" + i +", j=" + j);
//		}
//	}
//}


//public class ForPractice {
//	public static void main(String[] args) {
//		for(int i=1 ; i<=10 ; i++) {
//		System.out.println(i);
//		}
//		System.out.println(i); //에러 for문을 벗어났기에
//	}
//}

//그래서 애초에 for문 밖에서 선언해주면 가능
//변수의 범위는 선언된 블럭의 끝까지.
//변수의 범위는 좁을수록 좋다. 에러가 났을 시 확인하기 편함

//public class ForPractice {
//	public static void main(String[] args) {
//		int i;
//		for(i=1 ; i<=10 ; i++) {
//			System.out.println(i);
//		}
//		System.out.println(i); //에러 for문을 벗어났기에
//	}
//}


//public class ForPractice {
//	public static void main(String[] args) {
//		int i=1;
//		//조건식을 생략하면, true로 간주되어 무한반복문이 됨
//		for(;true;) {
//			System.out.println(i);
//		}
//		System.out.println(i); //에러남. 위에서 무한반복이 되니깐 여기까지 도달하지 않아서 에러
//	}
//}

public class ForPractice {
	public static void main(String[] args) {
		int sum=0;
		for(int i=1 ; i<=5 ; i++) {
			sum += 1;			
		}
	}
}
