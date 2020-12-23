import java.io.IOException;
import java.io.RandomAccessFile;

//read와 write를 동시에.

//먼저 내보내고 그것을 읽는 것
public class RandomAccessFileDemo1 {
	public static void main(String[] args) throws IOException{
		String path = "C:/temp/raf.txt"; //이 파일로 내보내는 것.
		RandomAccessFile raf = new RandomAccessFile(path, "rw"); //rw - read와 write로 
		raf.writeBoolean(true);		
		raf.writeInt(90);
		raf.writeDouble(89.5);		
		raf.writeUTF("Hello");
		raf.writeUTF("안녕하세요"); //이렇게 쓰고 나면 포인터는 이까지 쓴 곳까지 이동되어있다.
		raf.seek((long)0); //이동된 포인터를 처음으로 이동시킨다. 읽기 위해.
		System.out.printf("%b\n", raf.readBoolean());
		System.out.printf("%b\n", raf.readInt());
		System.out.printf("%.1f\n", raf.readDouble());
		System.out.printf("%s\n", raf.readUTF());
		System.out.printf("%s\n", raf.readUTF());
//		
	}
}
