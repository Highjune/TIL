import java.io.IOException;
import java.io.RandomAccessFile;

//https://www.youtube.com/watch?v=y76f87G27sU&feature=youtu.be
//CharUtility 클래스와 같이
//1. 원하는 위치에 Pointer 핸들링 가능
//2. 동시성도 가능(read/write동시에 )

//public class RandomAccessFileDemo {
//	public static void main(String[] args) throws IOException{
//		RandomAccessFile raf = new RandomAccessFile("C:/temp/addresslist.txt", "r"); //읽기전용임(r). 쓰는 것은 안됨. addresslist.txt는 영어, 한글 섞여있는 것이면 적절한 파일.
//		
//		String line = null;
//		while((line = raf.readLine()) != null) {
////		//	System.out.println(line); //이렇게 그냥 읽으면 한글깨짐
//			System.out.println(CharUtility.entoutf8(line));  //CharUtility클래스에 static메서드로 만들어놨으니까. 그대로 쓰면 됨
//		}
//		
//		
//	}
//}


public class RandomAccessFileDemo {
	public static void main(String[] args) throws IOException{
		RandomAccessFile raf = new RandomAccessFile("C:/temp/usatoday.txt", "r"); //usatoday.txt는 영어로만 된 것.
		
		long pos = raf.getFilePointer();  // 0임.
//		System.out.println(pos); //처음에는 Pointer가 0이다. 
//		raf.readLine(); //한줄 읽고 나서.
//		pos = raf.getFilePointer();
//		System.out.println(pos); //다시 Pointer로 확인하면 pointer가 0이 아니라 움직여 있다. 읽은만큼. length()가 최대치.
		
		while(pos < raf.length()) { //Pointer의 위치가 length()보다 작을 동안 => length()란 말은 그 파일의 끝이란 얘기. 즉 끝에 도달하기 전 ~ 
			System.out.println(raf.readLine());
			pos = raf.getFilePointer();
		}
		
	}
}




