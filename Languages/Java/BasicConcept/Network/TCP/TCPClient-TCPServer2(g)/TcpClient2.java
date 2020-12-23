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
			this.socket = new Socket("localhost", 8888); //������ �����ϸ� connection success�� �� ���̰�, ������ �����ִ� �ð���  �ؿ��� inputstream���� �޴´�.
			System.out.println("Connection Success"); 
			//������ ������ �޽���(�ð�)�� �޾ƾ� �ϴϱ�. inputstream �ʿ�
			InputStream is = this.socket.getInputStream(); //socket�� ������ ���� ������ ������ ������ �̰����κ��� inputstream������. 
			this.br = new BufferedReader(new InputStreamReader(is));
		} catch (UnknownHostException e) {
			System.out.println("Host Not Found");
		} catch (IOException e) {
			System.out.println(e); 
		}
	}
	
	private void service() {
		try {
			String msg = this.br.readLine(); //�����κ��� ���� �޽���
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
