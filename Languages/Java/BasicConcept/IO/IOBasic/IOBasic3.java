/*
 * String => byte array : API�� String�� ���� getBytes() �� �ִ�
 * byte array => String : String ������, new String(byte [] buffer, int off, int length) 
 */

import java.io.IOException;
import java.io.OutputStream;

public class IOBasic3 {
	public static void main(String[] args) {
//		PrintStream ps = System.out; //System.out�� Ÿ���� Printstream��.
		OutputStream os = System.out; //PrintStream�� �Ҿƹ����� oututsteam�̴� �׷��� �ļ��� ������ ������� ����ȯ ����
		String str ="�� ���� �԰� �ٴϴ�";
		byte[] buffer = str.getBytes();
//		for(int i = 0; i <buffer.length ; i++)
//			System.out.print(buffer[i] +",");
//		String str = "�� ���� �԰� �ٴϴ�?";  // �̰�(�� ����~ -> string)  ����Ʈ �迭�� ������ �ȴ�. (�Ǵ� byte�迭�� String���� ����� ���)
		try {
			//os.write(65);
			os.write(buffer);
			os.flush();
		}catch (IOException e) {
			System.out.println(e);
		}
		
//		try {
//			os.write(65);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
	}
}
