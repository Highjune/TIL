package practice;

import java.io.FileInputStream;
import java.io.InputStream;

public class FileInputStreamExample {
	public static void main(String[] args) throws Exception {
		InputStream is = new FileInputStream("D:\\temp\\note.txt");
		while(true) {
			int data = is.read(); //1byte씩 읽기
			if(data == -1) break;
			System.out.println(data);
		}
		is.close();
	}
}
