import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;


//server�� ������ ��
public class TcpClient {
	private Socket socket;
	public TcpClient() { //������
		try { //�����ּҿ� port��ȣ . ���� �ּҸ� �𸣸� InetAddress(�̸� �˷��ָ� ip��������) ���� ������� �ȴ�. 
			this.socket = new Socket("localhost", 8888); //localhost - ���� ������~, ����(TcpServer����)�� 8888�� �س����ϱ� 8888��.
				//localhost ���� 127.0.0.1�� �ص� �ȴ�.
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




