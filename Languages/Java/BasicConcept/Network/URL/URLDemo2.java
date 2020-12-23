import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;


//https://youtu.be/RUMgMn-46xs 15�к��� 

public class URLDemo2 {
	public static void main(String[] args) throws IOException {
		//URLDemo1 ���� ���׷��̵�(ȭ������� �����������)
		//��Ʈ��ũ �Է��� �����������, �����̸��� naver.html
		
		
		String url = "https://spring.io/"; //������ ����
		URL myurl = new URL(url); 

		InputStream is = myurl.openStream();
		BufferedReader br = new BufferedReader(
				new InputStreamReader(is)); 
		String line = null;
		PrintWriter pw = new PrintWriter(new FileWriter("spring.html")); //������ ��. ������ ��ġ�� ���ٳ���.
		while((line = br.readLine()) != null) { 
			pw.println(line); 
		}
		System.out.println("File Save Success");
		br.close();
	} 
}
//����� ���� ������Ʈ refresh�ϸ� spring.html ������ �� �� �� �ִ�. ��Ŭ��- openwith web browser�� ���� �� �� �ִ�.




