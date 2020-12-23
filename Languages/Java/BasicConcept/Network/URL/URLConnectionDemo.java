import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * https://youtu.be/5nh9ptUl5Nw
 * 
 * 
 * URL --> Read only(�� �������� �б⸸ ����)
 * URLConnection --> READ / Write �� �� ����(READ�� inputstream WRITE�� outputstream), �Ϲ� ������Ʈ��� write�� ���� ���̴�.
 * GET / HTTP / 1.1 HttpRequest Packet Header�� ù ��
 * HTTP/1.1 200 OK	HttpResponse Packet Header�� ù ��
 */

//URL�� 3���� ���� �� 3��°
//1.MalformaedURLException�� �̿��Ͽ� �ùٸ� URL���� �˻��Ϸ���
//2.InputStream ���� (InputStream�� ���� ������� ũ�Ѹ� �Ϸ���)
//3.URLConnection ��ü ���� (write�ϱ� ���ؼ�, URLconnection�� ����� ���ؼ��� openconnection�� �ʿ�)

//Get


public class URLConnectionDemo {
	public static void main(String[] args) throws IOException {
		URL url = new URL("https://www.naver.com/");
		URLConnection conn = url.openConnection(); 
		//URLConnection�� �߻�Ŭ������ new�� ����. �ݵ�� URL�� ���ؼ� ���� �� �ִ�. �� �� openConnection() �Ǵ� openConnection(Proxy proxy)�� ��� (URL�� ���� ���� ��)
		//proxy���� - �ȿ��� ������ ������ ���� ���� ��(��ȭ���� �ۿ��� ������ ������ ���� ���� ��)
		HttpURLConnection urlConn = (HttpURLConnection)conn; //�θ��� URLConnection���� get/post���� ���ϴ� �޼ҵ尡 ��� �ڽ��� ������ ���� ����ȯ.
		urlConn.setRequestMethod("GET");
		urlConn.connect(); //���� naver������ ���� ����.
		
//		System.out.println("Content Type : " + urlConn.getContentType());	//text/html; charset=UTF-8 //header�� �ִ� ���� �� 1���� body�� ������ f12���� �� ���̴� ���� �� body��
//		System.out.println("������ ���� ��¥ : " + urlConn.getDate());  //long�� ��¥. => dateŬ������ �־�� �Ѵ�. //header�� �ִ� ���� �� 1����
//		InputStream is = urlConn.getInputStream(); //bufferdreader�� ����־ readline���� loop���Ƽ� �ϴ� ��������, ������ packet��  header�� �����ϴ� ���̱� ������ packet�� body���� ������ ����.
		
		Map<String, List<String>> map = urlConn.getHeaderFields(); //header�� ������ ��ũ�� �� ������. 
		Set<String> keys = map.keySet(); //key�� ��ũ�� �� ������.
//		System.out.println(keys); //key������ �� �� �� �ִ�.
		
		//�����͸� ��ũ�� �̴� ���� ũ�� 2����(iterator, enumeration). iterator�� �޼��� 3��(remove, hasnext, next), enumeration�� �޼��� 2��(nextelement, hasmoreelement)
		//iterator�� 2���� Ư¡. (1.�޼��� �̸� ����. 2.remove�ִٴ� ��)
		Iterator<String> iters = keys.iterator(); 
		while(iters.hasNext()) {
			String key = iters.next();
			System.out.print(key + " --> ");//-->���� key���� , ������ key�� �߿��� naver Server�� �˰� ������ urlConn.getHeaderField("Server") 
			System.out.println(urlConn.getHeaderField(key));
		}
	
//		urlConn.disconnect();
		

}
}

