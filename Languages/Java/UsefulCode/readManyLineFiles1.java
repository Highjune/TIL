package test;

import java.io.File;
import java.io.FileReader;

public class readManyLineFiles1 {
public static void main(String[] args) {
	
		//내용이 여러줄인 여러 텍스트 파일 읽어들이기
		
//		1. character 단위로 읽어 들이기(성능때문에 비추천)
		
		String dir_Path = "C:\\Users\\June\\Desktop\\test1";
		
		File[] files= new File(dir_Path).listFiles();
		
		File file = null;
		String file_Path = null;
		
		for(File file1 : files) {

			file_Path = dir_Path + "\\" + file1.getName();	//  C:\\Users\\June\\Desktop\\test1\\june1.txt
			
			int contents = 1; 
			
			try {
				FileReader file_reader = new FileReader(file_Path);
				while((contents = file_reader.read()) != -1) { // stream의 끝에 도착하면 -1
					System.out.print((char)contents); // int를 char로 변환해서 읽음
				}
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
}
}
