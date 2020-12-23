import java.net.MalformedURLException;
import java.net.URL;

//�ڹ��� ���� P951

//URL - ���� �����Ϸ��� �ϴ� �ڿ��� ����͸� ��� ���� ���� �� �ʿ��� �ּ�

//URL�� 3���� ����
//1.MalformaedURLException�� �̿��Ͽ� �ùٸ� URL���� �˻��Ϸ���
//2.InputStream ���� (InputStream�� ���� ������� ũ�Ѹ� �Ϸ���)
//3.URLConnection ��ü ���� (write�ϱ� ���ؼ�, URLconnection�� ����� ���ؼ��� openconnection�� �ʿ�)


public class URLDemo {
	public static void main(String[] args) throws MalformedURLException {
		
		String url = "https://naver.com:443/index.html";
		URL myurl = new URL(url); //url�ּҸ� �ľ� �Ǵµ� �������� �� �����ؼ� naver.com�� �ϸ� MalformedURLException ���ܰ� �߻��� �� �ִ�.
		System.out.println(myurl.getPort()); //443, ���� ���� �ּҿ��� ��Ʈ��ȣ �� ���� -1�� ���´�.
		System.out.println(myurl.getDefaultPort()); //���� �ּҿ��� ��Ʈ��ȣ �� �ᵵ 443 ���´�. https������ ���� port��ȣ�� 443��� �̾ƿ´�.
	}
}



