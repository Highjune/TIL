import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;



//�޴� ��
public class UdpServer {
	private DatagramPacket packet;
	private DatagramSocket socket;
	
	public UdpServer() { //������
		try {
			this.socket = new DatagramSocket(8888); //����ϱ� ��Ʈ��ȣ�� �־�� �ȴ�. �� 8888�� ������´ٴ� ��. client�� 8888�� ã�ƿ� ��.
			System.out.println("I'm ready...");
		} catch (SocketException e) {
			e.printStackTrace();
		}	
	}
	
	//receive�� ����
	private void service() { //client�� �޴� �� (�޴� packet���� �޾Ҵ�. �� packet�� socket���� receive�� ��), receiver�� ���� ó���� 512byte�� buffer�� ���������� receivepacket�� length��ŭ������ ����.
		DatagramPacket receivePacket;
		try { //������ ������ �����͸� ���Ÿ�
			byte[] buffer = new byte[512];
			//������ datagrampacket�� ������
			receivePacket = new DatagramPacket(buffer, buffer.length); //�Ķ���� - byte�迭�� �޴� buffer�� �� ����.  �Ķ���Ϳ� �ּҿ� ��Ʈ��ȣ�� ������ ������Ŷ, �߼���Ŷ�� �ּҿ� ��Ʈ��ȣ�� �־�� �Ѵ�.(�׺���̼�ó�� �ּҰ� ������ ������ ��Ŷ��)
			this.socket.receive(receivePacket);//receivePacket���� �޴´ٴ� ��. �׷��� ���� �����Ͱ� DatagramPacket���� ����.
			String message = new String(buffer, 0, receivePacket.getLength());//byte�� ���� ���� String���� �ٲٴ� �� - String������ // getLength�� �� ���� �͸�. 512�� �غ� ������ 10���ڸ� �������� �� �� 10���ڸ� �ش�Ǵ� ���̴�.
			System.out.println("���� �޽��� : " + message);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		new UdpServer().service();     
	}
}