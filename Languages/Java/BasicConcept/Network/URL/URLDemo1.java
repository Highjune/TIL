import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;


public class URLDemo1 {
	public static void main(String[] args) throws IOException {
		//네트워크 입력을 화면출력으로.
		//찾는 과정 : 네이버의 ip를 모르지만 hostname(www.naver.com)으로 쿼리를 날리면 hostname에 해당하는 ip를 알려주니까(hosts에 없으면 DNS에서),  
		//그 ip로 요청을 하는 것임. 그러면 그 ip의 끝이 빨대의 시작(네이버 웹서버). 끝이 JVM
		
		
		String url = "https://www.naver.com/index.html";
		URL myurl = new URL(url); //url주소를 쳐야 되는데 프로토콜 등 생략해서 naver.com만 하면 MalFormedURLException 예외가 발생할 수 있다.
	
		//네이버 페이지를 네이버 머신으로부터 당겨옴.(inputstream이 필요함) 
		//당겨오는 페이지가 https니까 tcp ip이고 그래서 게이트웨이를 넘어온다. 
		//회사밖의 것의 데이터를 불러올 때는 URL로 당겨오고 그러기 위해서 URL class가 필요
	
		InputStream is = myurl.openStream();//URL은 읽는 것만 가능하기 떄문에 openStream밖에 없다.(API)그래서 나가는 outputstream하려면 urlconnection 이용
		//https://naver.com/index.html의 페이지 소스를 한줄씩 들고옴. 많아서 한줄씩 읽어옴.  byte[] buffer = new byte[100]; 로 하면 100byte씩 읽으니 너무 오래 걸린다.
		//bufferedreader는 char기반이므로 문자방식. 
		BufferedReader br = new BufferedReader(
				new InputStreamReader(is)); //InputStreamReader는 Stream을 reader로 바꿔주는 것. Bridge class
		String line = null;
		while((line = br.readLine()) != null) { //한줄씩 읽어서 null이 안 나올때까지.
			System.out.println(line); //표준출력
		}
		br.close();
	} 
}
 


