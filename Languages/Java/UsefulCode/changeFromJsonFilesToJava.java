package test;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class changeFromJsonFilesToJava {
	public static void main(String[] args) {
		//ObjectMapper 활용. 라이브러리 필요(스프링) - import com.fasterxml.jackson.databind.ObjectMapper;
		
		
		//C:\\Users\\June\\Desktop\\test
		
		String dir_Path = "C:\\Users\\June\\Desktop\\test"; // 여러 개의 json 파일들이 있는 상태. 
		
		File[] files = new File(dir_Path).listFiles();		
		
		String filePath = null;
		String jsonData = null;
		Scanner scan = null;
		
		for(File file : files) {
			filePath = dir_Path + "\\" + file.getName();
//			System.out.println(filePath); // 하나의 json 파일. C:\Users\June\Desktop\test\1239123.json
			
			scan = new Scanner(filePath);
			jsonData = scan.nextLine(); // dataType이 json형식으로 된 하나의 파일			
		
			//라이브러리 필요(일반 자바에서는 라이브러리 없어서 에러난다)
			ObjectMapper objectMapper = new ObjectMapper();
			
			//JSON 파일 1개를 map으로 바꿈
			HashMap<String, Object> jsonMap = objectMapper.readValue(jsonData, HashMap.class);
			
			//아래에서 형변환 하는 이유는 jsonMap에서 value가 Object라고 명시했기 때문이다. 
			HashMap<String, Object> firstMap = (HashMap<String, Object>) jsonMap.get("key"); //key로 값을 들고옴. 그런데 그 값이 또 하나의 firstMap이라는 map, 
		
		
		}
		
		
	}
}
