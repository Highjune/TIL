import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;


public class URLDemo1 {
	public static void main(String[] args) throws IOException {
		//��Ʈ��ũ �Է��� ȭ���������.
		//ã�� ���� : ���̹��� ip�� ������ hostname(www.naver.com)���� ������ ������ hostname�� �ش��ϴ� ip�� �˷��ִϱ�(hosts�� ������ DNS����),  
		//�� ip�� ��û�� �ϴ� ����. �׷��� �� ip�� ���� ������ ����(���̹� ������). ���� JVM
		
		
		String url = "https://www.naver.com/index.html";
		URL myurl = new URL(url); //url�ּҸ� �ľ� �Ǵµ� �������� �� �����ؼ� naver.com�� �ϸ� MalFormedURLException ���ܰ� �߻��� �� �ִ�.
	
		//���̹� �������� ���̹� �ӽ����κ��� ��ܿ�.(inputstream�� �ʿ���) 
		//��ܿ��� �������� https�ϱ� tcp ip�̰� �׷��� ����Ʈ���̸� �Ѿ�´�. 
		//ȸ����� ���� �����͸� �ҷ��� ���� URL�� ��ܿ��� �׷��� ���ؼ� URL class�� �ʿ�
	
		InputStream is = myurl.openStream();//URL�� �д� �͸� �����ϱ� ������ openStream�ۿ� ����.(API)�׷��� ������ outputstream�Ϸ��� urlconnection �̿�
		//https://naver.com/index.html�� ������ �ҽ��� ���پ� ����. ���Ƽ� ���پ� �о��.  byte[] buffer = new byte[100]; �� �ϸ� 100byte�� ������ �ʹ� ���� �ɸ���.
		//bufferedreader�� char����̹Ƿ� ���ڹ��. 
		BufferedReader br = new BufferedReader(
				new InputStreamReader(is)); //InputStreamReader�� Stream�� reader�� �ٲ��ִ� ��. Bridge class
		String line = null;
		while((line = br.readLine()) != null) { //���پ� �о null�� �� ���ö�����.
			System.out.println(line); //ǥ�����
		}
		br.close();
	} 
}
 


