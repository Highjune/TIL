import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//https://youtu.be/Ke2dMDljVBI  (TCP방식 그림설명 : 14분)- 자바의 정석 p961. 짧으니까 꼭 듣기

////https://youtu.be/Ke2dMDljVBI 뒷부분부터
//client로부터 받는 쪽
public class TcpServer {
	private ServerSocket server;
	
	public TcpServer() { //생성자
		try { //서버연결은 여기서 이루어진다.
			this.server = new ServerSocket(8888); //port번호를 알려줘야지 client가 찾아서 들어올 수 있다. 만약 다른 프로세서가 이 포트번호를 쓴다면 서버가 스타트하지 못한다.
			System.out.println("I'm ready");
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	private void service() { //받고 보내는 역할
		Socket client = null;
		try {
			while(true) {
				client = this.server.accept(); //클라이언트가 보낸 것을 aceept()할 때가지 무한루프 돈다. accept()의 리턴이 client형. 그리고 이 순간 바로 터널이 만들어진다.
				System.out.println(
						"[" + client.getInetAddress().getHostAddress() + "]으로부터 접속됨.");
			}
		}catch(IOException ex) {
			System.out.println(ex);
			System.out.println("Server Close.");
		}
	}
	
	public static void main(String[] args) {
		TcpServer server = new TcpServer();
		server.service();
	}
	
}
