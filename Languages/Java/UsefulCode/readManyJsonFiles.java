package practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class readManyJsonFiles {
	public static void main(String[] args) {
		
		File[] files = new File("C:\\June\\Desktop\\JSON").listFiles();
		
//		for(File file : files) {
//			System.out.println(file.getName());			
//		}		
		
		String filepath = null;
		String jsondata = null;
		Scanner scan = null;
		
		int i = 1;
		
		for(File file : files) {
			filepath = "C:\\June\\Desktop\\JSON\\" + file.getName();
			
			File jsonFiles = new File(filepath);
			
				try {
					scan = new Scanner(jsonFiles);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			
			jsondata = scan.nextLine();
			
			System.out.println("================데이터 출력================");
			System.out.println(i);
			System.out.println(jsondata);
			i++;
		}	

	}
}
