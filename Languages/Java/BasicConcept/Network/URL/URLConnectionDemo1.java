import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

//https://youtu.be/oVoYdgDfQQY
//https://youtu.be/bFycBKzBGvo
//https://youtu.be/yVx7NlngOQo(짤린 것 이어서)
//https://youtu.be/Ke2dMDljVBI 8분 55초까지

//URLConnection은 URL을 통해서 만드는 방법밖에 없다.
//POST방식
//읽는 것 뿐만 아니라 웹으로 보내는 것도 같이. (유저가 입력한 검색어를 웹으로 보내는 것도 가능) = URLConnection의 좋은점
//그런데 setDoOutput메서드 true를 해줘야자만 output이 된다.


public class URLConnectionDemo {
	public static void main(String[] args) throws IOException{
		URL url = null;
		HttpURLConnection conn = null;
		String urlStr = "https://www.ahnlab.com/kr/site/product/productView.do?prodSeq=19"; // =19를 보내서 200(OK)잘 전달이 된 것을 확인한다. 그러면 찍혀진 코드에서  V3 MObile Secruity를 찾을 수 있다. 이것이 19번을 의미하는 것.

		url = new URL(urlStr); //검색한 단어가 인코딩 된 것까지 합쳐진 urlstr을 넣은 url
		conn = (HttpURLConnection)url.openConnection(); //openConnection은 부모것이니까 자식의 것으로 강제형변환 (HttpURLConnection). setRequestMEthod는 자식만 갖고 있으니까 강제형변환
		//게시판은  get방식쓰면 안된다. url의 길이에 한계가 있기 때문에. get은 링크로도보내도 됨. 일반적인 네트워크 통신은 다 get방식
		//POST는 반드시 form으로 보내야 된다.(단점일수도). POST는 모든 내용들을 packet의 body에 다 넣는다.
		conn.setRequestMethod("POST"); 
		conn.setDoOutput(true);//출력을 위해서 URLconnection을 사용한다는 말. POST방식일 때는 이 메서드 처리를 해줘야 된다. (API보면 5개 정도 메서드가 있는데 필요한 것을 사용해야 한다)
		OutputStream os = conn.getOutputStream();
		PrintWriter pw = new PrintWriter(
				new BufferedWriter(new OutputStreamWriter(os)));//자바의 char기반을 발송의 byte기반으로 바꾸는 것이 bridgeclass인 OutptStreamWriter(통신에서는 byte계열만 쓰니까 바꿔줘야 된다)
		//cf) 들어올 때는 byte를 char로 바꾸는 것이 InputstreamWriter(bridgeclass)
		//BufferedWriter에 넣는 이유는 효율을 올리기 위해.
		//PrintWriter는 만든 것(bufferd~, output~ 로 만든 것) 전체를 써먹기 위해.
		pw.println();
		pw.flush();
		
		InputStream is = conn.getInputStream();
		BufferedReader br = null;
		String line = null;
		if(conn.getResponseCode() == 200) {
			br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
		}else {
			System.out.println("연결 실패");
		}
		conn.disconnect();
	}
}






