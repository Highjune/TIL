import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;


//https://youtu.be/RUMgMn-46xs 15분부터 

public class URLDemo2 {
	public static void main(String[] args) throws IOException {
		//URLDemo1 에서 업그레이드(화면출력을 파일출력으로)
		//네트워크 입력을 파일출력으로, 파일이름은 naver.html
		
		
		String url = "https://spring.io/"; //빨대의 시작
		URL myurl = new URL(url); 

		InputStream is = myurl.openStream();
		BufferedReader br = new BufferedReader(
				new InputStreamReader(is)); 
		String line = null;
		PrintWriter pw = new PrintWriter(new FileWriter("spring.html")); //빨대의 끝. 현재의 위치에 갖다놓음.
		while((line = br.readLine()) != null) { 
			pw.println(line); 
		}
		System.out.println("File Save Success");
		br.close();
	} 
}
//만들고 현재 프로젝트 refresh하면 spring.html 생성된 것 볼 수 있다. 우클릭- openwith web browser로 보면 볼 수 있다.




