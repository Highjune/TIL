import java.io.IOException;
import java.io.RandomAccessFile;

//read�� write�� ���ÿ�.

//���� �������� �װ��� �д� ��
public class RandomAccessFileDemo1 {
	public static void main(String[] args) throws IOException{
		String path = "C:/temp/raf.txt"; //�� ���Ϸ� �������� ��.
		RandomAccessFile raf = new RandomAccessFile(path, "rw"); //rw - read�� write�� 
		raf.writeBoolean(true);		
		raf.writeInt(90);
		raf.writeDouble(89.5);		
		raf.writeUTF("Hello");
		raf.writeUTF("�ȳ��ϼ���"); //�̷��� ���� ���� �����ʹ� �̱��� �� ������ �̵��Ǿ��ִ�.
		raf.seek((long)0); //�̵��� �����͸� ó������ �̵���Ų��. �б� ����.
		System.out.printf("%b\n", raf.readBoolean());
		System.out.printf("%b\n", raf.readInt());
		System.out.printf("%.1f\n", raf.readDouble());
		System.out.printf("%s\n", raf.readUTF());
		System.out.printf("%s\n", raf.readUTF());
//		
	}
}
