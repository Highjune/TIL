import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


 
public class InputStreamReaderDemo2 {
	public static void main(String[] args) throws IOException {
		//파일로부터 읽는 것 
		String path = "C:/temp/addresslist.txt";
		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);  
		//위처럼 파일을 들고 와서 BufferedReader에 넣으니까 애초부터 reader로 읽음. char로 읽는 것임. 한글을 읽을 수 있고, 특히 readeLine()이 있어서 유용
		
		String line = null; 
		while((line = br.readLine()) != null) {  //InputStreamReaderDemo1 파일을 이렇게 바꿈 무한루프를 이런식으로 바꾸면 무한루프에 대한 부담이 없어짐.
			System.out.println(line);
			//이렇게 파일 처리가 간단해짐.한글 처리 걱정 할 필요없음. bufferedreader에 넣으면 줄 단위로 읽을 수 있으니까 몇 byte이런것들 걱정 할 필요도 없고, Tokenizer 할 필요도 없다.
			//2번째 방법임
		
		}
	}
}



