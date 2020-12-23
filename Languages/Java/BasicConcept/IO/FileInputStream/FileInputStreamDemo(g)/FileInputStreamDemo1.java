import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

//Member클래스와 함께

public class FileInputStreamDemo1 {
	public static void main(String[] args) throws IOException{ //필드에서 할 때는 이렇게 throws로 던지지 말고 밑에서 일일이 하나씩 다 잡아줘야 된다.
		ArrayList<Member> list = new ArrayList<Member>(3); //물론 늘어나긴 하는데, 처음값만 3개 준거임
		System.out.print("Data가 있는 파일 경로 : ");
		String path = new java.util.Scanner(System.in).nextLine(); //.까지 하면 주소가 만들어질 것이고, 그 주소에 대한 nextLine(). 
		//위처럼 하면 스캐너에 대한 주소 따로 안 만들어도 된다. 제일 위에 import도 따로 안해도 된다. 원래는 new Scanner(System.in)임. 
		FileInputStream fis = new FileInputStream(path);
		byte [] buffer = new byte[512]; 
		int number = 0;
		String data = null;
		while((number = fis.read(buffer)) > 0) { //read로 읽은 것을 buffer에 넣고 그 넣은 것의 갯수를 number에 넣었음. 0보다 많다는 것은 하나라도 더 옮길 데이터가 있다는 말
			data = new String(buffer, 0, number); //String생성자로 byte->String만듬
		}

		StringTokenizer st = new StringTokenizer(data, "\n"); //그냥 API임. StringTokenizer
		System.out.println(st.countTokens());
		fis.close(); //파일은 무조건 닫아야 한다.
	}
}




