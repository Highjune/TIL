import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;



public class TimeClient {
	private DatagramSocket client;
	private DatagramPacket receivePacket, sendPacket;
		
	private TimeClient() throws IOException {
		client = new DatagramSocket(); //쓸 수 있는 것 아무거나 하나를 보내는 것임.(ex. JDBC에서 영상을 시청하려고 할 때)
		//즉 나도 정확히 어느 포트번호를 쓰는지 모르는 것임(available한 것 중에 하나를 보내는 것이다)
	}
	
	//자바에서 1초간격을 만드는 방법은 크게 2가지 : Timer, Thread (여기서는 Thread사용)
	private void service() throws InterruptedException, UnknownHostException, IOException{
		byte[] buffer = new byte[512]; //서버가 Now is 시:분:초 를 보내니까 넉넉하게.
		DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
		DatagramPacket sendPacket = 
				new DatagramPacket(buffer, buffer.length, InetAddress.getByName("localhost"), 10000);	
		for(int i = 0 ; i<=10; i++) {//서버에게 10번 요청
			Thread.sleep(1000); //여기서 1초 쉬는 것임. 이 1초를 방해하는 exception : InterruptedException
			this.client.send(sendPacket); //서버에게 먼저 보내면 서버가 패킷을 받음.
			this.client.receive(receivePacket); //서버는 받은 패킷을 다시 보낼 것(시간)인데 그것을 받음. receive에서 문자열이 바이트 배열로 바뀜
			System.out.println(new String(buffer, 0, receivePacket.getLength())); //버퍼를 string으로 바꾸기 위해서.
		}
	}
	
	public static void main(String[] args) throws IOException, InterruptedException{
		new TimeClient().service();
	}
}
