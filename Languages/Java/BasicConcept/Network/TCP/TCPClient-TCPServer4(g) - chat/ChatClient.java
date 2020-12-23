import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	private Socket socket;
	private PrintWriter pw;
	private BufferedReader br;
	private Scanner scan;
	
	public ChatClient() throws IOException{
//		this.socket = new Socket("211.63.89.134", 9999); //다른 곳 보낼려면
		this.socket = new Socket("localhost", 9999); //서버의 ip와 포트번호. ip와 포트번호를 가진 서버에게 ping을 날린다.
		this.pw = new PrintWriter(
					new BufferedWriter(
						new OutputStreamWriter(this.socket.getOutputStream())));
		this.br = new BufferedReader(
					new InputStreamReader(this.socket.getInputStream()));
		this.scan = new Scanner(System.in);
		System.out.print("대화명 : ");
		this.pw.println(this.scan.next());     //대화명 전송
		this.pw.flush();
		this.scan.nextLine();   //enter key 날리자.
	}
	private void service() {
		try {
			while(true) {
				System.out.print("Input message to send to server >> ");
				String message = this.scan.nextLine();
				if(message == null || message.equals("bye")) {
					this.pw.println("bye");     //메시지 전송
					this.pw.flush();
					break;
				}
				this.pw.println(message);     //메시지 전송
				this.pw.flush();
				message = this.br.readLine();
				System.out.println("[Server] >> " + message);
			}
			System.out.println("Connection is disconnected.");
		}catch(IOException ex) {
			System.out.println(ex);
		}finally {
			try {
				if(this.socket != null) this.socket.close();
			} catch (IOException e) {}
		}
	}
	public static void main(String[] args) {
		try {
			new ChatClient().service();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
