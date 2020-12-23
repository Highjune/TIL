import java.io.UnsupportedEncodingException;

//글씨깨질때마다 이렇게 만들어서 쓰면 된다. 유용함.
//인코딩할 때 우리가 charset 인코딩 디코딩을 쓴다.
//우리가 반드는 것임.
//영어의 charset - ISO8859_1  ex) txt저장할 때 ANSI로 하게 되면 ISO8859_1이란 말
//한글의 charset - KSC5601  (KS_C_5601-1987의 약어)
//인코딩을 변환할 때는 String 생성자를 쓴다.


public class CharUtility {
	public static String entoko(String en) { //영어를 한글로 
		String ko = null;
		try {
			ko = new String(en.getBytes("ISO8859_1"), "KSC5601"); //String(byte[] bytes, Charset charset) 생성자 쓰는 것임. 첫번째 파라미터는 getBytes로 byte[] 배열 얻어냄. 즉 english를 byte[]배열로 바꾸는 것.
		} catch (UnsupportedEncodingException e) {}
		return ko;
	}
	public static String kotoen(String ko) { //한글을 영어로 
		String en = null;
		try {
			en = new String(ko.getBytes("KSC5601"), "ISO8859_1");
		} catch (UnsupportedEncodingException e) {}
		return en;
	}
	public static String utf8toko(String utf8) {  //utf8을 한글로
		String ko = null;
		try {
			ko = new String(utf8.getBytes("UTF-8"), "KSC5601");
		} catch (UnsupportedEncodingException e) {}
		return ko;
	}
	public static String kotoutf8(String ko) {  //한글을 utf8로
		String utf8 = null;
		try {
			utf8 = new String(ko.getBytes("KSC5601"), "UTF-8");
		} catch (UnsupportedEncodingException e) {}
		return utf8;
	}
	public static String utf8toen(String utf8) { //utf8을 영어로
		String en = null;
		try {
			en = new String(utf8.getBytes("UTF-8"), "ISO8859_1");
		} catch (UnsupportedEncodingException e) {}
		return en;
	}
	public static String entoutf8(String en) { //영어를 utf8로
		String utf8 = null;
		try {
			utf8 = new String(en.getBytes("ISO8859_1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {}
		return utf8;
	}
}
