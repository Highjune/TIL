import java.io.IOException;
import java.io.RandomAccessFile;

//https://www.youtube.com/watch?v=y76f87G27sU&feature=youtu.be
//CharUtility Ŭ������ ����
//1. ���ϴ� ��ġ�� Pointer �ڵ鸵 ����
//2. ���ü��� ����(read/write���ÿ� )

//public class RandomAccessFileDemo {
//	public static void main(String[] args) throws IOException{
//		RandomAccessFile raf = new RandomAccessFile("C:/temp/addresslist.txt", "r"); //�б�������(r). ���� ���� �ȵ�. addresslist.txt�� ����, �ѱ� �����ִ� ���̸� ������ ����.
//		
//		String line = null;
//		while((line = raf.readLine()) != null) {
////		//	System.out.println(line); //�̷��� �׳� ������ �ѱ۱���
//			System.out.println(CharUtility.entoutf8(line));  //CharUtilityŬ������ static�޼���� ���������ϱ�. �״�� ���� ��
//		}
//		
//		
//	}
//}


public class RandomAccessFileDemo {
	public static void main(String[] args) throws IOException{
		RandomAccessFile raf = new RandomAccessFile("C:/temp/usatoday.txt", "r"); //usatoday.txt�� ����θ� �� ��.
		
		long pos = raf.getFilePointer();  // 0��.
//		System.out.println(pos); //ó������ Pointer�� 0�̴�. 
//		raf.readLine(); //���� �а� ����.
//		pos = raf.getFilePointer();
//		System.out.println(pos); //�ٽ� Pointer�� Ȯ���ϸ� pointer�� 0�� �ƴ϶� ������ �ִ�. ������ŭ. length()�� �ִ�ġ.
		
		while(pos < raf.length()) { //Pointer�� ��ġ�� length()���� ���� ���� => length()�� ���� �� ������ ���̶� ���. �� ���� �����ϱ� �� ~ 
			System.out.println(raf.readLine());
			pos = raf.getFilePointer();
		}
		
	}
}




