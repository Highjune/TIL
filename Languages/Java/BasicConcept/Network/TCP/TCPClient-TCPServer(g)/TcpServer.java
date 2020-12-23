import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//https://youtu.be/Ke2dMDljVBI  (TCP��� �׸����� : 14��)- �ڹ��� ���� p961. ª���ϱ� �� ���

////https://youtu.be/Ke2dMDljVBI �޺κк���
//client�κ��� �޴� ��
public class TcpServer {
	private ServerSocket server;
	
	public TcpServer() { //������
		try { //���������� ���⼭ �̷������.
			this.server = new ServerSocket(8888); //port��ȣ�� �˷������ client�� ã�Ƽ� ���� �� �ִ�. ���� �ٸ� ���μ����� �� ��Ʈ��ȣ�� ���ٸ� ������ ��ŸƮ���� ���Ѵ�.
			System.out.println("I'm ready");
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	private void service() { //�ް� ������ ����
		Socket client = null;
		try {
			while(true) {
				client = this.server.accept(); //Ŭ���̾�Ʈ�� ���� ���� aceept()�� ������ ���ѷ��� ����. accept()�� ������ client��. �׸��� �� ���� �ٷ� �ͳ��� ���������.
				System.out.println(
						"[" + client.getInetAddress().getHostAddress() + "]���κ��� ���ӵ�.");
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
