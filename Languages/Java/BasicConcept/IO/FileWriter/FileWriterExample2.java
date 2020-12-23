package practice;

import java.io.FileWriter;
import java.io.Writer;

public class FileWriterExample2 {
	public static void main(String[] args) throws Exception {
		Writer writer = new FileWriter("D:\\temp\\test2.txt");
		
		String str = "ABCDEFGHJI";
		
		writer.write(str);
		writer.write(str, 3, 5);
		
		writer.flush();
		writer.close();
	}
}
