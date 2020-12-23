package test;

import java.io.File;
import java.util.Scanner;

public class readOneLineFiles {
	public static void main(String[] args) {
		
		//파일 내용이 한 줄로 다 이루어져 있는 경우. ex) 한줄로 된 json 파일이나.
	
		String folderPath = "C:\\Users\\June\\Desktop\\test";
		
		//files 리스트 array만들기
		File[] files = new File(folderPath).listFiles();		
		
		//폴더 속 파일 리스트 확인
//		System.out.println(files); // 그냥 이렇게 toString호춯하면 [Ljava.io.File;@5f3a4b84 와 같은 주소값이 그냥 나올 뿐
		for(File file : files) { 
			
			System.out.println(file.getName()); // folderPath 안에 들어있는 파일 이름 출력들
//			438579348.json
//			123128472.json
//			934867349.json
//			129381294.json
//			129387123.json
		}
		
		int i = 1;
		String filePath = "";
		String jsonData = "";
		Scanner scan = null;
		
		for(File file : files) {
			filePath = folderPath + "\\" + file.getName(); // C:\\Users\\June\\Desktop\\test\\20201005102716787.json // 하나의 json파일
			
			scan= new Scanner(filePath); // 하나의 json 파일을 다 읽음
			
			jsonData = scan.nextLine(); // 
			
			System.out.println(i);
			System.out.println(jsonData);
			
			i++;			
			
		}			
		
	}
}
