import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.text.SimpleDateFormat;
import java.util.Date;

//TCP방식	
//보내는 쪽 (유저가 접근한 것을 받아서 보내는 것)
//서버는 client가 접속을 해야만 안다. 그래서 receivepacket이 있어야 한다. 
//user가 먼저 들어와야 들어온 packet을 받아서 그것을 뒤짚어서 (발신지->수신지) 전환. 들어온 packet을 뒤짚어야 나갈 수 있다.(들어와야만)
//웹은 채팅을 만들 수 없다. 왜냐하면 웹은 가만히 반응이 오기만을 기다리기 때문에 선 push 기능이 없다.  
//즉 가만히 있는데, 브라우저가 띄워지면서 facebook이 띄워지지 않는다. 

public class TimeServer {
	//socket의 역할은 받고 보내는 것의 역할밖에 안한다.(receive, send), 데이터는 packet안에 다 있다.	
	private DatagramSocket server;
	private DatagramPacket receivePacket, sendPacket;  //유저가들어와야 나감(현재시간)
	
	private TimeServer() throws IOException{
		this.server = new DatagramSocket(10000); //포트번호
		System.out.println("I'm ready...");
	}
	
	private void service() throws IOException {
		DatagramPacket receivePacket = null;
		DatagramPacket sendPacket = null;
		while(true) {  //기다리다가 client가 들어오면 받아서 그 때의 시간 만들고 byte배열 만들어서 발송
			byte[] buffer = new byte[2]; // user가 보낼 데이터를 없어서 받을 필요가 없으니 최소한의 크기만. //(클라이언트가 보낸 메시지 내용은 없지만 그 packet에 발신지 정보가 있어서 우리가 그것을 뒤집어서 보냄), 최소한의 배열만.
			receivePacket = new DatagramPacket(buffer, buffer.length); //받는 packet은 2개의 파라미터만 있으면 된다.
			this.server.receive(receivePacket);		
			String pattern = "hh:mm:ss";
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			String message = "Now is " + sdf.format(new Date()); //sdf.format()을 사용하면 string으로 리턴.
			sendPacket = new DatagramPacket(
					message.getBytes(),message.getBytes().length, 
					receivePacket.getAddress(), receivePacket.getPort()); //여기서 3, 4파라미터를 보면 받은 것으로부터 그 ip와 port를 알 수 있는 것임.(user에 대한 정보를 알기 위해서 받은 것임)
			this.server.send(sendPacket);
		}
	}
	
	public static void main(String[]args) throws IOException{
		new TimeServer().service();
	}
}
