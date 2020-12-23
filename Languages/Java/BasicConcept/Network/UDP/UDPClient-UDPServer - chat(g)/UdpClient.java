import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;


public class UdpClient {
	private DatagramSocket socket;
	private UdpClient() { //���� access modifier�� ���� default��(���� package������ ������ �� �ִ� ��)
		try {
			this.socket = new DatagramSocket();//���� machine�� ���� port�̱� ������ �Ķ���� �� �ᵵ �ȴ�.
			//client�� ������ ��(ex. ��۱��� ���� ��û�� �Ϳ� ���� ���� �ٽ� ������ ��) ��Ʈ��ȣ ���� X. available�� �� �� ���ٴ� ��.(�������� ��Ʈ��ȣ �� �ƹ��ų�) 
			//�̰��� �ٷ� ������ ȣ���� �� TCP�� �ٸ� ���̴�. 
			//tcp : tcp�� socket�� �ݵ�� �� ������ ���� ����Ǿ� �ְ� �޴� �ִ� ��Ʈ��ȣ�� �����, ������ �ִ� �޴� ���� ip, ��Ʈ��ȣ�� �˾ƾ� �Ѵ�.
			//udp : socket�� send�� �Ѵ�. ������ ������ �����鸶�� navigation(ip, ��Ʈ��ȣ)�� �� ���� ������ �ֱ� ������ socket�� ���� ���̱� ������ ���� ip, port�� �ʿ����.
			//�� socket���� �ּ� ���������ִ� ������ ������ packet���� �ּҸ� ������ ������ �����̴�.
		} catch (SocketException e) {
			System.out.println(e);
		}
	}
	
	//send�� ����
	private void service() { 
		String message = "���� �� ���� ��⳪";
		DatagramPacket sendPacket = null;
		try {
			sendPacket = new DatagramPacket( //������ datagrampacket�� ������(�ּҵ� �ʿ�)
					
				//�Ķ����1 - string�� ����Ʈ�迭�� �ٲٱ�, �Ķ����2 - ����Ʈ�迭�� �ٲ� ���� ������, �Ķ����3 - ip, �Ķ����4-��Ʈ��ȣ  
//				message.getBytes(), message.getBytes().length, InetAddress.getByName("211.63.89.141"), 9999); //�������� IP�� �����̰� ������ ��Ʈ��ȣ9999 
//				message.getBytes(), message.getBytes().length, InetAddress.getByName("localhost"), 8888); //�� ������(localhost)����.
				message.getBytes(), message.getBytes().length, InetAddress.getByName("211.63.89.142"), 8888); //�� ������(���� ip)����. getByName�� hostname����.
				this.socket.send(sendPacket);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		new UdpClient().service();
	}
	
	
}
