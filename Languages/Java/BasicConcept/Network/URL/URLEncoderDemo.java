import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Scanner;

//�ѱ� - Unicode
//URL������ �ѱ��� �ȵǱ� ������ URLEncoderŬ������ �ʿ�
//���߿� �Խ��ǿ��� ����� �� ����. ���ڵ��Ǿ��ִ� �ۼ��� �̸��� �ٽ� �ǵ����� ��.


	//���ڵ�(�ѱ��� URL�� �°� ������)
//public class URLEncoderDemo {
//	public static void main(String[] args) throws UnsupportedEncodingException {
//		Scanner scan = new Scanner(System.in);
//		System.out.print("Encoding�� ���ڿ� : ");
//		String original = scan.nextLine(); //�ڹ�
//		
//		String encode = URLEncoder.encode(original, "UTF-8");   //�ι�° �Ķ���ʹ� ������ ���� characterset
//		System.out.println(original + " --> "  + encode);
//		
//	}
//}

	//���ڵ�(���ڵ� �� ���� �ٽ� �ǵ����� ��)
public class URLEncoderDemo {
	public static void main(String[] args) throws UnsupportedEncodingException {
		Scanner scan = new Scanner(System.in);
		System.out.print("Decoding�� ���ڿ� : ");
		String original = scan.nextLine(); //%EC%9E%90%EB%B0%94 (������ �ڹٷ� ���ڵ��� ���ڿ�)
		
		String decode = URLDecoder.decode(original, "UTF-8"); 
		System.out.println(original + " --> "  + decode);
		
	}
}

