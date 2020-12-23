import java.io.*;

//inputStream --> Reader로 변환 
//자바의 정석 p905
//
//영상 꼭 참조(문자기반 스트림, 자바의 정석p898) 
//https://www.youtube.com/watch?v=LVSnjQeXzUM&feature=youtu.be
 
public class InputStreamReaderDemo {
	public static void main(String[] args) throws IOException {
//사실 우리는 이것들을 다 안 쓸 것이다. Scanner라는 좋은 기능이 있기 때문에.
//Scanner를 배우기 전에 IOBasic과 InputStreamReader가 있었다.
//원래 한글이 안됐었는데, 한글이 되게끔 우리가 Reader로 변환했기 때문에. 어제 한글을 하려면 byte배열(IOBasic에서) 을 이용한 것처럼
	
		InputStream is = System.in; 
//원리는 이렇게 키보드 등 표준으로 들어오는 것은 무조건 byte기반이므로 한글을 읽으려면 바이트 기반을 무조건 char로 바꿔야 된다. 그것이 바로 InputStreamReader. 그런데 그 performance를 좋게 하기 위해서 BufferedReader에 넣으면 그것을 한줄로 읽을 수 있다는 것.
		InputStreamReader isr = new InputStreamReader(is);  //bridge class. byte로 들어오는 것을 char로 바꾸게 해준다.
		Reader reader = isr;
		BufferedReader br = new BufferedReader(reader);
		System.out.println("Name : ");
		String name = br.readLine();  //Buffered에서 엄청 유용한 메서드임. Scanner의 NextLine()임. 이것을 쓰려고 어떻게든 위에서 Buffered를 하려고 함. 이것을 이용하면 한글도 이용할 수 있고 한줄씩 읽으니 parsing할 필요도 없다.
		System.out.println("name = " + name);
		
		//이 모든것을 한번에 하는 것이 Scanner. 

		
		
	}
}



