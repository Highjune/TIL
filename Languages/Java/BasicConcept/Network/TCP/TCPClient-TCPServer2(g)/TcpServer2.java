import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;


//cmd â���� �̰��� ���� �����ؾ� �ȴ�. bin�������� �̵��ؼ� java TcpServer2
public class TcpServer2 {
	private ServerSocket server;
	
	public TcpServer2() {
		try {
			this.server = new ServerSocket(8888);
			System.out.println("I'm ready.");
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	private void service() {
		Socket client = null;
		PrintWriter pw = null; //������ ��(������ ��).
		try {
			while(true) {
				client = this.server.accept(); //���ѷ��� ���鼭 ��ٸ��ٰ� client�� ������ accpet���� �޾Ƽ� socket����
				System.out.println(
						"[" + client.getInetAddress().getHostAddress() + "]���κ��� ���ӵ�");//client�κ��� �� socket�̴ϱ� �� client�� �ּҸ� �˰� �ִ� ����.
				OutputStream os = client.getOutputStream(); //������ ������ socket(client)�κ��� �������. �� socket�� client�κ��� �� �����̴ϱ� client�� �ּҸ� �˰� �����Ƿ� getoutputstream���� outputstream�� ����.
				pw = new PrintWriter(new OutputStreamWriter(os)); //outputstreamwriter�� writer�� outputstream���� �ٲ��ش�. ����� byte�� �ϱ� ������
				String pattern = "yyyy-MM-dd aa hh:mm:ss.";
				SimpleDateFormat sdf = new SimpleDateFormat(pattern); //����ð��� ���ڷ�
				String msg = sdf.format(new Date());
				pw.println(msg);    pw.flush();
				System.out.println("Sending Success.");
			}
		}catch(IOException ex) {
			System.out.println(ex);
			System.out.println("Server Close.");
		}
	}
	
	public static void main(String[] args) {
		TcpServer2 server = new TcpServer2();    server.service();
	}
	
}
