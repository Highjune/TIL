import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
//한글이 잘 될까? 1byte씩 읽는 것은 한글처리가 안 된다. 미국애들은 고민X. 동양권 국가들의 고민임.
//


public class FileInputStreamDemo {
	public static void main(String[] args) {
		File file = new File("."); //.은 나의 위치
		System.out.println(file.getAbsolutePath());
//		
		
		FileInputStream fis = null;
		int number = 0;
		byte[] buffer = new byte[1024]; //
		try {
//			fis = new FileInputStream("D:\\Javahome\\0129\\src\\FileInputStreamDemo.java"); //절대 경로와 상대 경로.
			fis = new FileInputStream("src/FileInputStreamDemo.java"); //절대 경로와 상대 경로.
			while(true) {//for을 안 쓰는 이유는 몇 번 loop도는지 모르니까. while문으로
				number = fis.read(buffer);//()안에 아무것도 안 쓴 것은 byte로 밟는다는 것이니까. 
				if(number<0 ) break;
				System.out.print((char)number);
				//한 글자씩 찍어야 되니까 println못 씀
			}
		}catch(FileNotFoundException ex) {  //파일을 못 찾을 때 쓰는 것
			System.out.println("File Not Found");
		}catch (IOException e) { //read를 할 때 발생하는 exception
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}






