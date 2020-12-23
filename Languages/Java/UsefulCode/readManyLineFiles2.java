package test;

import java.io.File;
import java.io.FileInputStream;

public class readManyLineFiles2 {
public static void main(String[] args) {
	
		//내용이 여러줄인 여러 텍스트 파일 읽어들이기
	
	
	//2. 버퍼 이용하기(바이퍼 단위로 파일 읽기)
	
			String dir_Path = "C:\\Users\\June\\Desktop\\test1";
			
			File[] files = new File(dir_Path).listFiles();

			String file_Path = null;
			FileInputStream fis = null;
			
			
			for(File file : files) {		
				file_Path =  dir_Path + "\\" + file.getName();
				
				try {
				
				fis = new FileInputStream(file_Path); // 파일 스트림 생성
				
				//버퍼 선언
				byte[] readBuffer = new byte[fis.available()]; // 해당 파일에 대해서 byte로 변환
				while(fis.read(readBuffer) != -1) { // 스트림이 끝에 도달하면 -1
					System.out.println(new String(readBuffer)); //출력
//					System.out.println(readBuffer); // 출력하면 주소 출력가 된다.
					System.out.println(); // 한 줄 띄우기
				}
				
				} catch (Exception e) {
					System.out.println("--실패--");
				}
			
			}

			
			
			
			
	}
}
