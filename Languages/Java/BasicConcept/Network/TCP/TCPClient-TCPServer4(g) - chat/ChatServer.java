import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


//���� ������ ���� �����带 ������ �Ѵ�. ���ÿ� �������� ���� �� �����ϱ� ������ �翬�� �����忩�� �Ѵ�.
//Ŭ���̾�Ʈ�� �����忩�� �Ѵ�. ��? ������ �޴� ���� ���ÿ� �Ϸ���. ������ �����͸� ������ �߿��� �ǽð����� �޾ƾ� �ϴϱ�.
//���� �����带 ������ �ʾ����ϱ� ������ �� ����� �׳� ���Ͼ������ �Ѵ�.

//tcp�����
public class ChatServer {
	private ServerSocket server; // 1:1�� ó���ϴ� TCP��Ŀ���, ������ ���� ������ �־�� �Ѵ�.

	public ChatServer() { //������(�ʱ�ȭ ����)
		try {
			this.server = new ServerSocket(9999); //���������� Ŭ���̾�Ʈ�� ���� �� �����ؾ� �� ��Ʈ��ȣ�̴�. ��Ʈ 9999��ȣ�� �� ����. ���� �̹� �����ִ�(ex.1521����Ŭ) ��ȣ�� ���� Address already in use ��� ������ ���.
			System.out.println("I'm waiting...");
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	private void service() {
		Socket client = null; //client�� ��ȭ�� socket
		BufferedReader br = null;
		PrintWriter pw = null;
		Scanner scan = new Scanner(System.in);
		try {
			while(true) { //���ѷ��� ���鼭 ������ ��ٸ��� ��.
				client = this.server.accept();//client���� �����ϴ� ���� �ٷ� accept() �ٷ� ���밡 ��������鼭 ����� ����(client���� �������� ��� ������, ���⼭�� �������� ����µ� �װ��� �ٷ� socket(client)
				//System.out.println("[" + client.getInetAddress().getHostName() + "] ���Ἲ��"); //client�� �ӽ��̸�.
				br = new BufferedReader(new InputStreamReader(client.getInputStream())); //�ޱ�. client.getInputStream()�� InputStream()�� �����.
				pw = new PrintWriter( //��������
						new BufferedWriter(
								new OutputStreamWriter(client.getOutputStream()))); //client.getOutputStream()�� OutputStream()�� �����.
				String userid = br.readLine();  //User ID
				System.out.println("[" + userid + "] ���� �湮�ϼ̽��ϴ�.");
				this.process(br, pw, userid, scan);
			}
		}catch(IOException ex) { //���� try �ȿ� �ִ� ���ѷ����� �� ���ٰ� ������ ���� �ߴܵǰ� �ٷ� catch�� �Ѿ�´�.
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





