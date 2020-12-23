import java.io.UnsupportedEncodingException;

//�۾����������� �̷��� ���� ���� �ȴ�. ������.
//���ڵ��� �� �츮�� charset ���ڵ� ���ڵ��� ����.
//�츮�� �ݵ�� ����.
//������ charset - ISO8859_1  ex) txt������ �� ANSI�� �ϰ� �Ǹ� ISO8859_1�̶� ��
//�ѱ��� charset - KSC5601  (KS_C_5601-1987�� ���)
//���ڵ��� ��ȯ�� ���� String �����ڸ� ����.


public class CharUtility {
	public static String entoko(String en) { //��� �ѱ۷� 
		String ko = null;
		try {
			ko = new String(en.getBytes("ISO8859_1"), "KSC5601"); //String(byte[] bytes, Charset charset) ������ ���� ����. ù��° �Ķ���ʹ� getBytes�� byte[] �迭 ��. �� english�� byte[]�迭�� �ٲٴ� ��.
		} catch (UnsupportedEncodingException e) {}
		return ko;
	}
	public static String kotoen(String ko) { //�ѱ��� ����� 
		String en = null;
		try {
			en = new String(ko.getBytes("KSC5601"), "ISO8859_1");
		} catch (UnsupportedEncodingException e) {}
		return en;
	}
	public static String utf8toko(String utf8) {  //utf8�� �ѱ۷�
		String ko = null;
		try {
			ko = new String(utf8.getBytes("UTF-8"), "KSC5601");
		} catch (UnsupportedEncodingException e) {}
		return ko;
	}
	public static String kotoutf8(String ko) {  //�ѱ��� utf8��
		String utf8 = null;
		try {
			utf8 = new String(ko.getBytes("KSC5601"), "UTF-8");
		} catch (UnsupportedEncodingException e) {}
		return utf8;
	}
	public static String utf8toen(String utf8) { //utf8�� �����
		String en = null;
		try {
			en = new String(utf8.getBytes("UTF-8"), "ISO8859_1");
		} catch (UnsupportedEncodingException e) {}
		return en;
	}
	public static String entoutf8(String en) { //��� utf8��
		String utf8 = null;
		try {
			utf8 = new String(en.getBytes("ISO8859_1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {}
		return utf8;
	}
}
