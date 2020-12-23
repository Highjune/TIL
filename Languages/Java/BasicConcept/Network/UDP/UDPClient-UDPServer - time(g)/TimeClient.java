import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;



public class TimeClient {
	private DatagramSocket client;
	private DatagramPacket receivePacket, sendPacket;
		
	private TimeClient() throws IOException {
		client = new DatagramSocket(); //�� �� �ִ� �� �ƹ��ų� �ϳ��� ������ ����.(ex. JDBC���� ������ ��û�Ϸ��� �� ��)
		//�� ���� ��Ȯ�� ��� ��Ʈ��ȣ�� ������ �𸣴� ����(available�� �� �߿� �ϳ��� ������ ���̴�)
	}
	
	//�ڹٿ��� 1�ʰ����� ����� ����� ũ�� 2���� : Timer, Thread (���⼭�� Thread���)
	private void service() throws InterruptedException, UnknownHostException, IOException{
		byte[] buffer = new byte[512]; //������ Now is ��:��:�� �� �����ϱ� �˳��ϰ�.
		DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
		DatagramPacket sendPacket = 
				new DatagramPacket(buffer, buffer.length, InetAddress.getByName("localhost"), 10000);	
		for(int i = 0 ; i<=10; i++) {//�������� 10�� ��û
			Thread.sleep(1000); //���⼭ 1�� ���� ����. �� 1�ʸ� �����ϴ� exception : InterruptedException
			this.client.send(sendPacket); //�������� ���� ������ ������ ��Ŷ�� ����.
			this.client.receive(receivePacket); //������ ���� ��Ŷ�� �ٽ� ���� ��(�ð�)�ε� �װ��� ����. receive���� ���ڿ��� ����Ʈ �迭�� �ٲ�
			System.out.println(new String(buffer, 0, receivePacket.getLength())); //���۸� string���� �ٲٱ� ���ؼ�.
		}
	}
	
	public static void main(String[] args) throws IOException, InterruptedException{
		new TimeClient().service();
	}
}
