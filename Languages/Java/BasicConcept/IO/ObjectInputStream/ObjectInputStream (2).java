package practice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

public class ReadLineExample {
	public static void main(String[] args) throws Exception {
//		String path = null;
//		path = ReadLineExample.class.getResource("language.txt").getPath();
//		Reader reader = new FileReader(path);
		
		Reader reader = new FileReader(
				ReadLineExample.class.getResource("language.txt").getPath()
		);
		BufferedReader br = new BufferedReader(reader);
		
		//BufferedReader class offer readeLine() Method. it can read 1 line / 1 time.
		while(true){
			String data = br.readLine();
			if(data == null) break;
			System.out.println(data);
		}
		
		br.close();
		
	}
}
