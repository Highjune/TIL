import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

//https://youtu.be/oVoYdgDfQQY
//https://youtu.be/bFycBKzBGvo
//https://youtu.be/yVx7NlngOQo(©�� �� �̾)
//https://youtu.be/Ke2dMDljVBI 8�� 55�ʱ���

//URLConnection�� URL�� ���ؼ� ����� ����ۿ� ����.
//POST���
//�д� �� �Ӹ� �ƴ϶� ������ ������ �͵� ����. (������ �Է��� �˻�� ������ ������ �͵� ����) = URLConnection�� ������
//�׷��� setDoOutput�޼��� true�� ������ڸ� output�� �ȴ�.


public class URLConnectionDemo {
	public static void main(String[] args) throws IOException{
		URL url = null;
		HttpURLConnection conn = null;
		String urlStr = "https://www.ahnlab.com/kr/site/product/productView.do?prodSeq=19"; // =19�� ������ 200(OK)�� ������ �� ���� Ȯ���Ѵ�. �׷��� ������ �ڵ忡��  V3 MObile Secruity�� ã�� �� �ִ�. �̰��� 19���� �ǹ��ϴ� ��.

		url = new URL(urlStr); //�˻��� �ܾ ���ڵ� �� �ͱ��� ������ urlstr�� ���� url
		conn = (HttpURLConnection)url.openConnection(); //openConnection�� �θ���̴ϱ� �ڽ��� ������ ��������ȯ (HttpURLConnection). setRequestMEthod�� �ڽĸ� ���� �����ϱ� ��������ȯ
		//�Խ�����  get��ľ��� �ȵȴ�. url�� ���̿� �Ѱ谡 �ֱ� ������. get�� ��ũ�ε������� ��. �Ϲ����� ��Ʈ��ũ ����� �� get���
		//POST�� �ݵ�� form���� ������ �ȴ�.(�����ϼ���). POST�� ��� ������� packet�� body�� �� �ִ´�.
		conn.setRequestMethod("POST"); 
		conn.setDoOutput(true);//����� ���ؼ� URLconnection�� ����Ѵٴ� ��. POST����� ���� �� �޼��� ó���� ����� �ȴ�. (API���� 5�� ���� �޼��尡 �ִµ� �ʿ��� ���� ����ؾ� �Ѵ�)
		OutputStream os = conn.getOutputStream();
		PrintWriter pw = new PrintWriter(
				new BufferedWriter(new OutputStreamWriter(os)));//�ڹ��� char����� �߼��� byte������� �ٲٴ� ���� bridgeclass�� OutptStreamWriter(��ſ����� byte�迭�� ���ϱ� �ٲ���� �ȴ�)
		//cf) ���� ���� byte�� char�� �ٲٴ� ���� InputstreamWriter(bridgeclass)
		//BufferedWriter�� �ִ� ������ ȿ���� �ø��� ����.
		//PrintWriter�� ���� ��(bufferd~, output~ �� ���� ��) ��ü�� ��Ա� ����.
		pw.println();
		pw.flush();
		
		InputStream is = conn.getInputStream();
		BufferedReader br = null;
		String line = null;
		if(conn.getResponseCode() == 200) {
			br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
		}else {
			System.out.println("���� ����");
		}
		conn.disconnect();
	}
}






