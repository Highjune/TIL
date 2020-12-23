package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class readfilecontents {
	public static void main(String[] args) {
		
		try {
		
			String path = "C:\\Users\\June\\Desktop\\test\\20201005102716787.json";
			File file = new File(path);
			
			Scanner scan = new Scanner(file);
			
			while(scan.hasNextLine()) {
				System.out.println(scan.nextLine());
			}
		} catch (FileNotFoundException e) {
			
		}
		
		
	}
}
