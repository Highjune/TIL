package practice;

import java.io.FileWriter;
import java.io.Writer;

public class FileWriterExample1 {
	public static void main(String[] args) throws Exception{
		Writer writer = new FileWriter("D:\\tmep\\test1.txt");
		
		char[] array = {'j', 'u', 'n', 'e', '1', '2', '3'};
		
		writer.write(array);
//		writer.write(array, 2, 4); // array 배열의 2~4만 내보내는 것
		
		writer.flush();
		writer.close();
	}
}
