import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient2 {
	private Socket socket;
	private BufferedReader br;
	
	public TcpClient2() {
		try {
			this.socket = new Socket("localhost", 8888); //서버로 연결하면 connection success가 뜰 것이고, 서버가 보내주는 시간을  밑에서 inputstream으로 받는다.
			System.out.println("Connection Success"); 
			//서버가 보내는 메시지(시간)을 받아야 하니까. inputstream 필요
			InputStream is = this.socket.getInputStream(); //socket이 서버에 대한 정보를 가지고 있으니 이것으로부터 inputstream만들어낸다. 
			this.br = new BufferedReader(new InputStreamReader(is));
		} catch (UnknownHostException e) {
			System.out.println("Host Not Found");
		} catch (IOException e) {
			System.out.println(e); 
		}
	}
	
	private void service() {
		try {
			String msg = this.br.readLine(); //서버로부터 받은 메시지
			System.out.println("[From Server] : " + msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new TcpClient2().service();
	}
}
