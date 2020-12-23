import java.io.IOException;
import java.io.InputStream;

public class IOBasic {
	public static void main(String[] args) {
		//표준출력 : 출력buffer -> Moniter, Console, Terminal, System.out(자바에서)
		//표준입력 : keyboard -> 입력 Buffer, System.in(자바에서)
		//버퍼에서 moniter로 내보내고, 키보드에서 버퍼로 보내는 일은 OS가 한다.
		//System.out, in 은 시스템 독립적이다. 왜? 자바가 하는 것이 아니라 OS(IOS, 리눅스, 윈도우 등 뭐든)
		
		//아래는 자바의 가장 원시적인 입력 방법이었음. 현재는 Scanner(1.5버전 이후) 라는 제일 세련된 방법으로 변경된 것.	
		
		InputStream is = System.in;  //InputStream은 못 만들기 때문에, System.in이 inputStream형을 반환하니깐 System.in이 만듬
		//빨대인 is로부터 1byte만 가능. 한글은 기본 2바이트이므로 한글은 안된다.
		System.out.print("좋아하시는 계절은 : ");  
		String season = "";
		int number = 0;
		
		try {
			while(true) {
				number = is.read();
				if(number <0 || (char)number == '\n')break;
				season += (char)number;
			}
			System.out.println("season = " + season);
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	
		
	}
}
