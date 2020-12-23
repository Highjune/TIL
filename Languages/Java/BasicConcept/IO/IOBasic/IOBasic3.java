/*
 * String => byte array : API의 String에 가면 getBytes() 가 있다
 * byte array => String : String 생성자, new String(byte [] buffer, int off, int length) 
 */

import java.io.IOException;
import java.io.OutputStream;

public class IOBasic3 {
	public static void main(String[] args) {
//		PrintStream ps = System.out; //System.out의 타입이 Printstream임.
		OutputStream os = System.out; //PrintStream의 할아버지가 oututsteam이다 그래서 후손은 조상의 모습으로 형변환 가능
		String str ="너 밥은 먹고 다니니";
		byte[] buffer = str.getBytes();
//		for(int i = 0; i <buffer.length ; i++)
//			System.out.print(buffer[i] +",");
//		String str = "너 밥은 먹고 다니니?";  // 이걸(너 밥은~ -> string)  바이트 배열로 만들어야 된다. (또는 byte배열을 String으로 만드는 방법)
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
