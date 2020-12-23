import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;



//받는 쪽
public class UdpServer {
	private DatagramPacket packet;
	private DatagramSocket socket;
	
	public UdpServer() { //생성자
		try {
			this.socket = new DatagramSocket(8888); //서브니까 포트번호가 있어야 된다. 즉 8888로 열어놓는다는 말. client는 8888로 찾아올 것.
			System.out.println("I'm ready...");
		} catch (SocketException e) {
			e.printStackTrace();
		}	
	}
	
	//receive로 받음
	private void service() { //client를 받는 것 (받는 packet으로 받았다. 그 packet을 socket으로 receive한 것), receiver할 때는 처음에 512byte의 buffer로 만들어놨지만 receivepacket의 length만큼까지만 받음.
		DatagramPacket receivePacket;
		try { //유저가 보내는 데이터를 수신만
			byte[] buffer = new byte[512];
			//보내는 datagrampacket의 생성자
			receivePacket = new DatagramPacket(buffer, buffer.length); //파라미터 - byte배열로 받는 buffer와 그 갯수.  파라미터에 주소와 포트번호가 없으면 수신패킷, 발송패킷은 주소와 포트번호가 있어야 한다.(네비게이션처럼 주소가 있으면 나가는 패킷임)
			this.socket.receive(receivePacket);//receivePacket에서 받는다는 말. 그러면 받은 데이터가 DatagramPacket으로 들어간다.
			String message = new String(buffer, 0, receivePacket.getLength());//byte로 들어온 것을 String으로 바꾸는 것 - String생성자 // getLength는 딱 들어온 것만. 512로 준비를 했지만 10글자만 들어왔으면 딱 그 10글자만 해당되는 것이다.
			System.out.println("수신 메시지 : " + message);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		new UdpServer().service();     
	}
}