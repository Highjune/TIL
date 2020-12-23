import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


//원래 서버는 여러 쓰레드를 돌려야 한다. 동시에 여러명이 들어올 수 있으니까 서버는 당연히 쓰레드여야 한다.
//클라이언트도 쓰레드여야 한다. 왜? 보내고 받는 것을 동시에 하려고. 서버에 데이터를 보내는 중에도 실시간으로 받아야 하니까.
//아직 쓰레드를 만들지 않았으니까 쓰레드 안 만들고 그냥 단일쓰레드로 한다.

//tcp방식임
public class ChatServer {
	private ServerSocket server; // 1:1로 처리하는 TCP방식에서, 서버는 서버 소켓이 있어야 한다.

	public ChatServer() { //생성자(초기화 역할)
		try {
			this.server = new ServerSocket(9999); //서버소켓은 클라이언트가 들어올 때 오픈해야 될 포트번호이다. 포트 9999번호를 연 것임. 만약 이미 쓰고있는(ex.1521오라클) 번호를 쓰면 Address already in use 라는 오류가 뜬다.
			System.out.println("I'm waiting...");
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	private void service() {
		Socket client = null; //client와 대화할 socket
		BufferedReader br = null;
		PrintWriter pw = null;
		Scanner scan = new Scanner(System.in);
		try {
			while(true) { //무한루프 돌면서 서버는 기다리는 중.
				client = this.server.accept();//client에서 접속하는 순간 바로 accept() 바로 빨대가 만들어지면서 통신이 연결(client에서 종이컵을 들고 왔으니, 여기서도 종이컵을 만드는데 그것이 바로 socket(client)
				//System.out.println("[" + client.getInetAddress().getHostName() + "] 연결성공"); //client의 머신이름.
				br = new BufferedReader(new InputStreamReader(client.getInputStream())); //받기. client.getInputStream()이 InputStream()을 만든다.
				pw = new PrintWriter( //내보내기
						new BufferedWriter(
								new OutputStreamWriter(client.getOutputStream()))); //client.getOutputStream()이 OutputStream()을 만든다.
				String userid = br.readLine();  //User ID
				System.out.println("[" + userid + "] 님이 방문하셨습니다.");
				this.process(br, pw, userid, scan);
			}
		}catch(IOException ex) { //위의 try 안에 있는 무한루프가 잘 돌다가 오류가 나면 중단되고 바로 catch로 넘어온다.
			System.out.println(ex);
		}finally {
			try {
				if(this.server != null) {
					System.out.println("Server is closed.");
					this.server.close();
				}
			} catch (IOException e) {}
		}
	}

	private void process(BufferedReader br, PrintWriter pw, String userid, Scanner scan){
		try {
			while(true) {
				String message = br.readLine();
				if(message.equals("bye")) break;
				System.out.println(userid + " >> " + message);
				System.out.print("Input message to send to client : ");
				message = scan.nextLine();
				pw.println(message);   pw.flush();
			}
			System.out.println("[" + userid + "] is closed.");
		}catch(IOException ex) {
			System.out.println(ex);
		}finally {
			
		}
	}
	public static void main(String[] args) {
		new ChatServer().service();
	}
}





