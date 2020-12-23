
//처음 값, 나중 값 넣기
public class MethodDemo0 {
	public static void main(String[] args) {
	
//	MethodDemo0.calcSum();  //값 설정해놨는데 아무것도 안 넣으면 에러
	MethodDemo0.calcSum(50, 60);
		calcSum(1, 3);      //값으로 호출한다고 해서 call by value
		calcSum(20, 10);
	}

	static void calcSum(int start, int last) 	{       //int num = 50
		int sum = 0;
		for(int i=start ; i <=last ; i++) {
			sum += i;
		}
		System.out.println(start + "부터" + last + "까지의 합은" + sum + "입니다.");
	//	return; 이 생략되어 있음. return은 돌아가자라는 뜻. return뒤에 아무것도 없으니 void인 것. 
	//	return 뒤에 뭔가가 있으면 return 타입
	}
}
///////////////이러한 일련의 과정을 모듈화라고 한다.




