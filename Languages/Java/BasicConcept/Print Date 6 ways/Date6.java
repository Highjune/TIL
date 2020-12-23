import java.util.Date;

//날짜를 표헌하는 방법6
//printf
//%t를 이용함. (java.formatter 에서 설명) cf) format함수만 나오면 formtter class에서 찾기
//%t뒤에 H, K, l, S 등을 붙이면 원하는 시간 분 등에 대한 양식을 붙일 수 있음
public class Date6 {
	public static void main(String[] args) {
//		System.out.printf("지금은 %tl시 %tM분 %tS초입니다.", new Date(), new Date(), new Date()); //이렇게 갯수를 맞춰도 되지만 아래와 같이 new Date() 1개만 쓸 수도 있다.
//		System.out.printf("지금은 %1$tl시 %1$tM분 %1$tS초입니다.", new Date()); //1$는 뒤에 파라미터 중에서 첫번째 것을 선택한다는 말. 대상을 1개만 넣어도 된다.
		
		
//		System.out.printf("지금은 %T", new Date());//대문자 T는 시, 분, 초를 세트로 다 갖고 있다.
		
		//위의 것을 String으로 바꾼 것
		String now = String.format("지금은 %T", new Date());
		System.out.println(now);
		
	}
}
