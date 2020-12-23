import java.net.MalformedURLException;
import java.net.URL;

//자바의 정석 P951

//URL - 내가 접근하려고 하는 자원이 라우터를 벗어난 곳에 있을 때 필요한 주소

//URL의 3가지 역할
//1.MalformaedURLException을 이용하여 올바른 URL인지 검사하려고
//2.InputStream 생성 (InputStream을 통해 웹페이즈를 크롤링 하려고)
//3.URLConnection 객체 생성 (write하기 위해서, URLconnection을 만들기 위해서는 openconnection이 필요)


public class URLDemo {
	public static void main(String[] args) throws MalformedURLException {
		
		String url = "https://naver.com:443/index.html";
		URL myurl = new URL(url); //url주소를 쳐야 되는데 프로토콜 등 생략해서 naver.com만 하면 MalformedURLException 예외가 발생할 수 있다.
		System.out.println(myurl.getPort()); //443, 만약 위의 주소에서 포트번호 안 쓰면 -1이 나온다.
		System.out.println(myurl.getDefaultPort()); //위의 주소에서 포트번호 안 써도 443 나온다. https인지를 보고 port번호를 443라고 뽑아온다.
	}
}



