import java.io.IOException;
import java.io.InputStream;

public class IOBasic1 {
	public static void main(String[] args) {
		//표준출력 : 출력buffer -> Moniter, Console, Terminal, System.out(자바에서)
		//표준입력 : keyboard -> 입력 Buffer, System.in(자바에서)
		//버퍼에서 moniter로 내보내고, 키보드에서 버퍼로 보내는 일은 OS가 한다.
		//System.out, in 은 시스템 독립적이다. 왜? 자바가 하는 것이 아니라 OS(IOS, 리눅스, 윈도우 등 뭐든)가 하는 것임.
		
		InputStream is = System.in;  
		System.out.println("좋아하시는 계절은? :");
		String season  = "";
		int number = 0;
		byte [] buffer = new byte[20];
		try {
			number = is.read(buffer); //루프 돌 필요X, 입력한 것이 다 buffer에 들어가니깐. read안에 byte배열을 써야만 한글 쓸 수 있다.
			season = new String(buffer, 0, number);
			System.out.println("season = " + season);
		} catch(IOException e) {
			System.out.println(e);
		}
		

		
		
		
		
		
		
		
		
		
		
	
		
	}
}

