import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
//�ѱ��� �� �ɱ�? 1byte�� �д� ���� �ѱ�ó���� �� �ȴ�. �̱��ֵ��� ���X. ����� �������� �����.
//


public class FileInputStreamDemo {
	public static void main(String[] args) {
		File file = new File("."); //.�� ���� ��ġ
		System.out.println(file.getAbsolutePath());
//		
		
		FileInputStream fis = null;
		int number = 0;
		byte[] buffer = new byte[1024]; //
		try {
//			fis = new FileInputStream("D:\\Javahome\\0129\\src\\FileInputStreamDemo.java"); //���� ��ο� ��� ���.
			fis = new FileInputStream("src/FileInputStreamDemo.java"); //���� ��ο� ��� ���.
			while(true) {//for�� �� ���� ������ �� �� loop������ �𸣴ϱ�. while������
				number = fis.read(buffer);//()�ȿ� �ƹ��͵� �� �� ���� byte�� ��´ٴ� ���̴ϱ�. 
				if(number<0 ) break;
				System.out.print((char)number);
				//�� ���ھ� ���� �Ǵϱ� println�� ��
			}
		}catch(FileNotFoundException ex) {  //������ �� ã�� �� ���� ��
			System.out.println("File Not Found");
		}catch (IOException e) { //read�� �� �� �߻��ϴ� exception
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






