import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;


//server로 보내는 쪽
public class TcpClient {
	private Socket socket;
	public TcpClient() { //생성자
		try { //서버주소와 port번호 . 만약 주소를 모르면 InetAddress(이름 알려주면 ip가르쳐줌) 한테 물어봐야 된다. 
			this.socket = new Socket("localhost", 8888); //localhost - 내가 나에게~, 서버(TcpServer에서)가 8888로 해놨으니깐 8888로.
				//localhost 말고 127.0.0.1로 해도 된다.
		} catch (UnknownHostException e) {
			System.out.println("Host Not Found");
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	private void service() {}
	
	public static void main(String[] args) {
		new TcpClient().service();
	}
}




