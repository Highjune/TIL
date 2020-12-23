package practice;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class FileOutputStreamExample2 {
	public static void main(String[] args) throws Exception {
		OutputStream os = new FileOutputStream("D:\\temp\\test2.db");
		
		byte[] array = {10, 20, 30, 40, 50};
		
		os.write(array); // entire
		os.write(array, 1, 3); // from array[1] ~ array[3]
		
		os.flush();
		os.close();
	}
}
