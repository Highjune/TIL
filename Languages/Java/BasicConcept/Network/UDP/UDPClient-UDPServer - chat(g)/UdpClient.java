import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;


public class UdpClient {
	private DatagramSocket socket;
	private UdpClient() { //만약 access modifier안 쓰면 default임(현재 package에서만 접근할 수 있는 것)
		try {
			this.socket = new DatagramSocket();//나의 machine에 대한 port이기 때문에 파라미터 안 써도 된다.
			//client는 수신할 떄(ex. 방송국에 영상 요청한 것에 대한 것을 다시 수신할 때) 포트번호 따로 X. available한 것 다 쓴다는 말.(수만개의 포트번호 중 아무거나) 
			//이것이 바로 서버를 호출할 때 TCP와 다른 점이다. 
			//tcp : tcp의 socket은 반드시 양 끝단이 서로 연결되어 있고 받는 애는 포트번호만 써놓고, 보내는 애는 받는 애의 ip, 포트번호를 알아야 한다.
			//udp : socket은 send만 한다. 실제로 나가는 버스들마다 navigation(ip, 포트번호)를 다 각각 가지고 있기 때문에 socket은 나의 것이기 때문에 따로 ip, port가 필요없다.
			//이 socket에서 주소 지정안해주는 이유는 나가는 packet들이 주소를 가지고 나가기 떄문이다.
		} catch (SocketException e) {
			System.out.println(e);
		}
	}
	
	//send로 보냄
	private void service() { 
		String message = "밥은 잘 묵고 댕기나";
		DatagramPacket sendPacket = null;
		try {
			sendPacket = new DatagramPacket( //나가는 datagrampacket의 생성자(주소도 필요)
					
				//파라미터1 - string을 바이트배열로 바꾸기, 파라미터2 - 바이트배열로 바꾼 것의 사이즈, 파라미터3 - ip, 파라미터4-포트번호  
//				message.getBytes(), message.getBytes().length, InetAddress.getByName("211.63.89.141"), 9999); //선문이의 IP와 선문이가 설정한 포트번호9999 
//				message.getBytes(), message.getBytes().length, InetAddress.getByName("localhost"), 8888); //나 스스로(localhost)한테.
				message.getBytes(), message.getBytes().length, InetAddress.getByName("211.63.89.142"), 8888); //나 스스로(나의 ip)한테. getByName은 hostname으로.
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
