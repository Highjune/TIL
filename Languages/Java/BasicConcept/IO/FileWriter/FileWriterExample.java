package practice;

import java.io.FileWriter;
import java.io.Writer;

public class FileWriterExample {
	public static void main(String[] args) throws Exception {
		Writer writer = new FileWriter("D:\\temp\\test.txt");
		
		char a = 'A';
		char b = 'B';
		char c = 'C';
		
		writer.write(a);
		writer.write(b);
		writer.write(c);
		
		writer.flush();
		writer.close();
		
	}
}
