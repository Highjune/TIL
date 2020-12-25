package practice;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileExample {
	public static void main(String[] args) throws Exception {
		File dir = new File("C:/Temp/images");
		File dir1 = new File("C:/Temp/file1.txt");
		File dir2 = new File("C:/Temp/file2.txt");
		File dir3 = new File("C:/Temp/file3.txt");
		
		if(dir.exists() == false) {
			// if there is no files, make new directory
			dir.mkdirs();
		}
		if(dir1.exists() == false) {
			dir1.mkdirs();
		}
		if(dir2.exists() == false) {
			dir2.mkdirs();
		}
		if(dir3.exists() == false) {
			dir3.mkdirs();
		}
		
		File temp = new File("C:/Temp");
		File[] contents = temp.listFiles();
		
		System.out.println("시간\t\t\t형태\t\t\t이름");
		System.out.println("--------------------------------");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
		for(File file : contents) {
			System.out.println(sdf.format(new Date(file.lastModified())));
			if(file.isDirectory()) {
				System.out.println("\t<DIR>\t\t\t" + file.getName());
			} else {
				System.out.println("\t\t\t" + file.length() + "\t" + file.getName());
			}
			System.out.println();
		}
	}
}
