import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class CalculatorClient {
	private Socket socket;
	private BufferedReader br;
	private PrintWriter pw;
	private Scanner scan;
	
	public CalculatorClient() { //생성자는 필요한 것들 만들어주는 역할
		this.scan = new Scanner(System.in); //생성자로 멤버변수(scan) 초기화
		try {
			this.socket = new Socket("localhost", 8888); //서버를 찾아감
			System.out.println("Connection Success");
			InputStream is = this.socket.getInputStream(); //socket을 통해서 inputsteram초기화
			this.br = new BufferedReader(new InputStreamReader(is));
			OutputStream os = this.socket.getOutputStream(); //socket을 통해서 outpustream초기화 (나가는 것)
			this.pw = new PrintWriter(new OutputStreamWriter(os)); //outpustreamwriter - outputstream을 writer로 변환
		} catch (UnknownHostException e) {
			System.out.println("Host Not Found");
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	private void service() {
		try {
			String y_n = null;
			do {
				System.out.print("첫번째 숫자 : ");  int first = this.scan.nextInt();
				System.out.print("두번째 숫자 : ");  int second = this.scan.nextInt();
				System.out.print("연산자(+, -, x, /) : ");  String op = this.scan.next();
				//TODO : 보내기
			
				//TODO : 받기
				String message = String.format("%d   %s    %d", first, op, second);
				this.pw.println(message); //네트워크로 내보냄. pw의 빨대가 네트워크를 가르키고 있으니까.
				this.pw.flush();
				message = this.br.readLine(); //"12"
				System.out.printf("%d %s %d = %s\n", first, op, second, message);
				System.out.print("Again(y/n) ? : ");
				y_n = this.scan.next();
			}while(y_n.toUpperCase().equals("Y"));
		}catch(IOException ex) {
			System.out.println(ex);
		}
	}
	public static void main(String[] args) {
		new CalculatorClient().service(); 
	}
}
