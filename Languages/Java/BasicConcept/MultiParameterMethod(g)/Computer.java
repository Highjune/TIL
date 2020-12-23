package practice;

//가변인자
//매개변수를 ...로 선언하게 되면 넘겨준 값의 수에 따라 자동으로 배열이 생성되고 매개값으로 사용된다. 
//배열타입이므로 배열을 직접 매개값으로 사용해도 된다.

public class Computer {
	int sum1(int[] values) {
		int sum = 0;
		for(int i = 0 ; i<values.length; i++) {
			sum+=values[i];
		}
		return sum;
	}
	
	int sum2(int ... values) {
		int sum = 0;
		for(int i = 0 ; i<values.length ; i++) {
			sum += values[i];
		}
		return sum;
	}
}
