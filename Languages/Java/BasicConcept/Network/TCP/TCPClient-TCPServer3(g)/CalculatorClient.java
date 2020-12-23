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
	
	public CalculatorClient() { //�����ڴ� �ʿ��� �͵� ������ִ� ����
		this.scan = new Scanner(System.in); //�����ڷ� �������(scan) �ʱ�ȭ
		try {
			this.socket = new Socket("localhost", 8888); //������ ã�ư�
			System.out.println("Connection Success");
			InputStream is = this.socket.getInputStream(); //socket�� ���ؼ� inputsteram�ʱ�ȭ
			this.br = new BufferedReader(new InputStreamReader(is));
			OutputStream os = this.socket.getOutputStream(); //socket�� ���ؼ� outpustream�ʱ�ȭ (������ ��)
			this.pw = new PrintWriter(new OutputStreamWriter(os)); //outpustreamwriter - outputstream�� writer�� ��ȯ
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
				System.out.print("ù��° ���� : ");  int first = this.scan.nextInt();
				System.out.print("�ι�° ���� : ");  int second = this.scan.nextInt();
				System.out.print("������(+, -, x, /) : ");  String op = this.scan.next();
				//TODO : ������
			
				//TODO : �ޱ�
				String message = String.format("%d   %s    %d", first, op, second);
				this.pw.println(message); //��Ʈ��ũ�� ������. pw�� ���밡 ��Ʈ��ũ�� ����Ű�� �����ϱ�.
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
