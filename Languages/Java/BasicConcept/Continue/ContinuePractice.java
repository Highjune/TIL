//3배수 아닌 것들만 찍기
public class ContinuePractice {
	public static void main(String[] args) {
		for(int i=0 ; i<=10 ; i++) {
			if(i%3 == 0) 
				continue;
			System.out.println(i);  //continue는 이것을 뛰어넘고 다시 반복문으로 감
		}
	}
}
