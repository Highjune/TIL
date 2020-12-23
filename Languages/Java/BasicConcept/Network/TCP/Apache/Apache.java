import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//https://youtu.be/HPZj7gd434E 
//request or response packet�� ���� ����� �߿��� ����(�� ������ ����)

public class Apache {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(80); //80���� http�� ���
		
//		while(true) { //�����κ��� ���� ������ ������ ����. ���ѷ��� ���� �ִ� ����. �������� ó���ϱ� ���� �ݺ��̴�. 1�� ó���Ѵٰ� �ϸ� �ݺ��� �ʿ����.
//			Socket client = server.accept(); // Ŭ���̾�Ʈ�� �����ϴ� ������. �� �� Ŭ���̾�Ʈ�� socket�� ���� socket�� user�� ���������ν� ������ ������(ip, ��Ʈ��ȣ) ����
//			BufferedReader br = new BufferedReader(
//					new InputStreamReader(client.getInputStream()));
//			String line = null;
//			while((line = br.readLine()) != null) { //user�� ������ ������ �� �� ���� �����Ͱ� �ִ��� �𸣴ϱ� while�ݺ���. 
//				System.out.println(line); 
//			}
//		}  
	
		//������� �ϰ� ������ ��, �������� localhost:80(�� ������ ��û) ���� �������� ���´�. requestpacket�� header�� ù �ٿ� GET / HTTTP/1.1 �� ���´�. �⺻�� �� GET. �޼ҵ�� POST��� �ؾ� POST.
		//�̰����� ����, �츮�� naver, daum� ������ ������ naver, daum���� ������ �̷� �����(requestpacket)�� �����ٴ� ���� �� �� �ִ�.(���� �߿��� user-agent ����)
		//requestpacket���� accept��� ���� �ִµ� �̰��� �������� �޾Ƶ��� �� �ִ�(������ �� �ִ�) MIME Ÿ���� ���Ѵ�. �̰� �̿ܿ��� �� �ٿ�ްڴٴ� ��.
		//chrome�� firefox ���� localhost:80 ���� ���� �� �ٸ���.
		//���� localhost:80 ���� ���������� localhost/abc/test/index.html �̶�� �Ѵٸ� header�� ù �ٿ� ���(/localhost/abc/test/index.html)�� �̷��� ���� ��.
		//�� ������ �̷��� user�� ��û�� ��ο� �´� ������ ��������� �ȴ�. (�� ������ ����)
		//����� �ȿ� ȸ���� �����͵��� ������ ���� ����  / ����� �ۿ� ������ URL�� �����ؾ� �Ѵ�.(�� ����)
		//header���� ���� ������� body.  
		
		
		while(true) { //��������
			Socket client = server.accept();
			
//			BufferedReader br = new BufferedReader(
//					new InputStreamReader(client.getInputStream()));
//			String line = null;
//			while((line = br.readLine()) != null) {
//				System.out.println(line);
//			}
			
			File file = new File("index.html"); //�������忡�� �ϵ��ũ�� �ִ� index.html�� �����ִ� ��. �׷��� apache���� ���忡���� �Է��� ����(index.html) ����� ��Ʈ��ũ
			BufferedReader br = new BufferedReader(new FileReader(file)); //���Ϸ� �Է� ��
			PrintWriter pw = new PrintWriter(new BufferedWriter(
					new OutputStreamWriter(client.getOutputStream())));
			String line = null;
			while((line = br.readLine()) != null) {
				pw.println(line); // index.html�� ������� ���پ� �о �߼�.
				pw.flush();
			}
		}
//		server.close();
		
 
	}
}
//���⼭ ������ �� ���������� localhost:80 �̶�� ġ�� index.html�� ������ ���´�.





