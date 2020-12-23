import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.text.SimpleDateFormat;
import java.util.Date;

//TCP���	
//������ �� (������ ������ ���� �޾Ƽ� ������ ��)
//������ client�� ������ �ؾ߸� �ȴ�. �׷��� receivepacket�� �־�� �Ѵ�. 
//user�� ���� ���;� ���� packet�� �޾Ƽ� �װ��� ��¤� (�߽���->������) ��ȯ. ���� packet�� ��¤��� ���� �� �ִ�.(���;߸�)
//���� ä���� ���� �� ����. �ֳ��ϸ� ���� ������ ������ ���⸸�� ��ٸ��� ������ �� push ����� ����.  
//�� ������ �ִµ�, �������� ������鼭 facebook�� ������� �ʴ´�. 

public class TimeServer {
	//socket�� ������ �ް� ������ ���� ���ҹۿ� ���Ѵ�.(receive, send), �����ʹ� packet�ȿ� �� �ִ�.	
	private DatagramSocket server;
	private DatagramPacket receivePacket, sendPacket;  //���������;� ����(����ð�)
	
	private TimeServer() throws IOException{
		this.server = new DatagramSocket(10000); //��Ʈ��ȣ
		System.out.println("I'm ready...");
	}
	
	private void service() throws IOException {
		DatagramPacket receivePacket = null;
		DatagramPacket sendPacket = null;
		while(true) {  //��ٸ��ٰ� client�� ������ �޾Ƽ� �� ���� �ð� ����� byte�迭 ���� �߼�
			byte[] buffer = new byte[2]; // user�� ���� �����͸� ��� ���� �ʿ䰡 ������ �ּ����� ũ�⸸. //(Ŭ���̾�Ʈ�� ���� �޽��� ������ ������ �� packet�� �߽��� ������ �־ �츮�� �װ��� ����� ����), �ּ����� �迭��.
			receivePacket = new DatagramPacket(buffer, buffer.length); //�޴� packet�� 2���� �Ķ���͸� ������ �ȴ�.
			this.server.receive(receivePacket);		
			String pattern = "hh:mm:ss";
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			String message = "Now is " + sdf.format(new Date()); //sdf.format()�� ����ϸ� string���� ����.
			sendPacket = new DatagramPacket(
					message.getBytes(),message.getBytes().length, 
					receivePacket.getAddress(), receivePacket.getPort()); //���⼭ 3, 4�Ķ���͸� ���� ���� �����κ��� �� ip�� port�� �� �� �ִ� ����.(user�� ���� ������ �˱� ���ؼ� ���� ����)
			this.server.send(sendPacket);
		}
	}
	
	public static void main(String[]args) throws IOException{
		new TimeServer().service();
	}
}
