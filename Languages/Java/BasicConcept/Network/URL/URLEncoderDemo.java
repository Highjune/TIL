import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Scanner;

//한글 - Unicode
//URL에서는 한글이 안되기 때문에 URLEncoder클래스가 필요
//나중에 게시판에서 써먹을 수 있음. 인코딩되어있는 작성자 이름을 다시 되돌려야 함.


	//인코딩(한글을 URL에 맞게 맞춰줌)
//public class URLEncoderDemo {
//	public static void main(String[] args) throws UnsupportedEncodingException {
//		Scanner scan = new Scanner(System.in);
//		System.out.print("Encoding할 문자열 : ");
//		String original = scan.nextLine(); //자바
//		
//		String encode = URLEncoder.encode(original, "UTF-8");   //두번째 파라미터는 원본에 대한 characterset
//		System.out.println(original + " --> "  + encode);
//		
//	}
//}

	//디코딩(인코딩 된 것을 다시 되돌리는 것)
public class URLEncoderDemo {
	public static void main(String[] args) throws UnsupportedEncodingException {
		Scanner scan = new Scanner(System.in);
		System.out.print("Decoding할 문자열 : ");
		String original = scan.nextLine(); //%EC%9E%90%EB%B0%94 (위에서 자바로 인코딩한 문자열)
		
		String decode = URLDecoder.decode(original, "UTF-8"); 
		System.out.println(original + " --> "  + decode);
		
	}
}

