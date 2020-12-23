package practice;

import java.io.FileInputStream;
import java.io.InputStream;

public class FileInputStreamExample1 {
	public static void main(String[] args) throws Exception {
		InputStream is = new FileInputStream("D:\\temp\\note.txt");
		
		byte[] buffer = new byte[100];
		while(true) {
			// 배열길이만큼 읽기
			int readByteNum = is.read(buffer); 
			// 특정 배열만큼 읽기
//			int readByteNum1 = is.read(buffer, 2, 3); //buffer배열의 2~3 만큼만 읽음
			if(readByteNum == -1) break; 
			for(int i = 0 ; i < readByteNum; i++) {
				System.out.println(buffer[i]);
			}
		}
		is.close();
	}
}
