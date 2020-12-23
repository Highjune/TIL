//0200204 �ǽ�����
//���� : �������� URL�Է��� ������ ������ �̸��� �����ؼ� ����.html �� ���� �����ϴ� ��. ������ �̸��� host�̸��� �ȴ�.


//https://youtu.be/R87R5A2qtN0 22�к���
//https://youtu.be/rax0GrAWpBU
//https://youtu.be/r3UdAWt7hkA

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

//��Ʈ��ũ�κ��� read(�Է�), ���Ϸ� write(���)
//������ ���� ���ǿ� : BufferedReader(���پ� ���� �� �־ ����) / ������ ���� ���ǿ� : PrintWriter(servlet&jsp���� printwriter�� ����)
//DNS�� ���̹��� IP�� �˷��� ����, IP�ּҿ� �ִ� ������ �ӽ��� index.html�� �������� ã���� ����. index.html�� ����κ��� ���پ� ~

public class URLDemo {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("URL : ");
		String urlStr = scan.next(); // URL�� ������ ������ �����ϱ� next�ᵵ ��, //https://www.naver.com
		URL url = null; 		
//		��Ʈ��ũ�κ��� �о�� ��(READ) - ������ ����. //������ ������ URL. write�� ���Ϸ�.
		BufferedReader br = null; //BufferedReader / PrintWriter =>���� �а� �������� ���� ���ǿ�
		PrintWriter pw = null;
		String line, path = null; //���̹����� ���� �о�޾Ƽ� �ִ� ����
		int endIndex = urlStr.lastIndexOf("."); //17��°�� �ִ� https://www.naver.com �� �ι�° .
		String lastDomain = urlStr.substring(endIndex + 1); // com�� ���´�, com, edu, gov, org, kr, jp, de, uk, io, cn, ca ���� �ϳ�// �����ο��� �� �ڴ� ����.
		if(lastDomain.length() == 2 && !lastDomain.equals("io") && !lastDomain.equals("ai") && !lastDomain.equals("me")) {
			// ���� ������ kr, jp, de, uk, cn, ca, tv
			// https://www.sist.co.kr ���� sist���� �̾Ƴ���.
			int startIndex = urlStr.indexOf("."); //11 (0���� ��Ƹ���)
			int last = urlStr.indexOf(".", startIndex); //16(�ι�° 0), .�� ã�µ� ù��° . ���ķ� ã�ƶ� => 2��° .
			path = urlStr.substring(startIndex + 1, last); //sist
		}else {
//			// com, edu, gov, org
			path = urlStr.substring(urlStr.indexOf(".") + 1, endIndex);// naver  ó���� .���� ������ .���� (�������� ����x)
		}
		path += ".html";
		try {
			url = new URL(urlStr);
			br = new BufferedReader( //url�� openstream()�� ���ؼ� inputstream�� ����� bridgeclass(stream�� reader�� ��ȯ)�� InputstreamReader�� �־ Reader�� ���� BufferdReader�� ����
					new InputStreamReader(url.openStream(), "UTF-8"));  // naver�� utf-8�̴ϱ� utf-8�� �о�� ���ؼ� charset�� �ι�° �Ķ���ͷ� �־���.
			pw = new PrintWriter(new BufferedWriter(new FileWriter(path))); //�������� �͵� ���۸����� �������� �����ϱ� bufferdWriter�� ������.
			while((line = br.readLine()) != null) { // �� �о�� ������! null�̸� �� ���� ���̴ϱ� ��.
//				System.out.println(line);
				pw.println(line);
			} 
			System.out.println("Save Success.");
		}catch(MalformedURLException e) {
			System.out.println("URL is invalid."); //�������� ���԰� naver.com ���� �ȵȴ�. aaa://naver.com �ϸ� �������� �ʴ� ���������̶� �� ����. http://www.naver.com ó�� ����� ��� �ȴ�.
		}catch(IOException e) {
			System.out.println(e);
		}finally {
			try {
				br.close();
			} catch (IOException e) {}
		}
	}
}
