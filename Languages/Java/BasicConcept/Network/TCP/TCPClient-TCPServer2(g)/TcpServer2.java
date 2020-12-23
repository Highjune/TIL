import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;


//cmd 창에서 이것을 먼저 실행해야 된다. bin폴더까지 이동해서 java TcpServer2
public class TcpServer2 {
	private ServerSocket server;
	
	public TcpServer2() {
		try {
			this.server = new ServerSocket(8888);
			System.out.println("I'm ready.");
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	private void service() {
		Socket client = null;
		PrintWriter pw = null; //보내는 것(나가는 것).
		try {
			while(true) {
				client = this.server.accept(); //무한루프 돌면서 기다리다가 client가 들어오면 accpet으로 받아서 socket생성
				System.out.println(
						"[" + client.getInetAddress().getHostAddress() + "]으로부터 접속됨");//client로부터 온 socket이니까 그 client의 주소를 알고 있는 것임.
				OutputStream os = client.getOutputStream(); //나가는 라인을 socket(client)로부터 만들었다. 이 socket이 client로부터 온 소켓이니까 client의 주소를 알고 있으므로 getoutputstream으로 outputstream을 만듬.
				pw = new PrintWriter(new OutputStreamWriter(os)); //outputstreamwriter가 writer를 outputstream으로 바꿔준다. 통신은 byte로 하기 때문에
				String pattern = "yyyy-MM-dd aa hh:mm:ss.";
				SimpleDateFormat sdf = new SimpleDateFormat(pattern); //현재시간을 문자로
				String msg = sdf.format(new Date());
				pw.println(msg);    pw.flush();
				System.out.println("Sending Success.");
			}
		}catch(IOException ex) {
			System.out.println(ex);
			System.out.println("Server Close.");
		}
	}
	
	public static void main(String[] args) {
		TcpServer2 server = new TcpServer2();    server.service();
	}
	
}
