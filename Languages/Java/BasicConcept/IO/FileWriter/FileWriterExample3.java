package practice;

import java.io.FileWriter;
import java.io.Writer;

public class FileWriterExample3 {
	public static void main(String[] args) throws Exception {
		Writer writer = new FileWriter("D:\\temp\\test2.txt");
		
		String str = "ABCDEFGH";
		
		writer.write(str);
		
		writer.flush();
		writer.close();
	}
}
