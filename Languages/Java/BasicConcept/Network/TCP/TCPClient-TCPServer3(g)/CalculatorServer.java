import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorServer {
	private ServerSocket server;

	public CalculatorServer() {
		try {
			this.server = new ServerSocket(8888);
			System.out.println("I'm ready.");
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	private void service() {
		Socket client = null;
		try {
			while (true) {
				client = this.server.accept();//어떤 client가 보낸 것인지를 안다.
				System.out.println("[" + client.getInetAddress().getHostAddress() + "]으로부터 접속됨.");
				calc(client);
			}
		} catch (IOException ex) {
			try {
				this.server.close();
				System.out.println("Server Close.");
			} catch (IOException e) {
				System.out.println(ex);
			}
		}
	}

	private void calc(Socket socket) { // "5 + 7"
		PrintWriter pw = null;
		BufferedReader br = null;
		try {
			while (true) {
				InputStream is = socket.getInputStream();
				br = new BufferedReader(new InputStreamReader(is));
				String message = br.readLine(); // "5 + 7"

				Scanner scan = new Scanner(message).useDelimiter("\\s+"); 
				int first = scan.nextInt();
				String op = scan.next();
				int second = scan.nextInt();
				String result = null;
				switch (op) {
				case "+":
					result = String.valueOf(first + second); //숫자를 스트링으로 바꾸는 고급방법. cf) ""를 붙여서 쉽게 하는 방법도 있다.
					break;
				case "-":
					result = String.valueOf(first - second);
					break;
				case "x":
					result = String.valueOf(first * second);
					break;
				case "/":
					result = String.valueOf(first / second);
					break;
				}
				OutputStream os = socket.getOutputStream();
				pw = new PrintWriter(new OutputStreamWriter(os));
				pw.println(result);
				pw.flush();
				System.out.println("Sending Success.");
			}
		} catch (IOException ex) {
			try {
				socket.close();
				System.out.println("Client와의 연결 해제");
			} catch (IOException e) {}
		}
	}

	public static void main(String[] args) {
		CalculatorServer server = new CalculatorServer();
		server.service();
	}

}
