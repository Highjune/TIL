import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
//�ڹ��� ���� 886
//https://youtu.be/4oquHeKqdlk 9�к��� 
//DataInputStream, DataOutputStream
//8���� �⺻ �ڷ����� ������ �а� �� �� �ִٴ� ����!
//�� ���ڴ� ���� �״�� �ְ� ���� �� �ִ�.
//������Ʈ ������ new file�� data.dat �����ϰ� ����(src������ ����)
//byte��ݸ� �ȴ�. char����� �ȵȴ�. 

public class FilterStreamdemo {
	public static void main(String[] args) throws IOException {
		//data.dat���Ϸ� ��������
//		DataOutputStream dos = 
//				new DataOutputStream(new FileOutputStream("data.dat")); //�̷��� �ϸ� close()�ѹ��� �ᵵ �ȴ�.	
//		dos.writeInt(90);
//		dos.writeDouble(89.5);
//		dos.writeBoolean(true);
//		dos.writeChar(65);
//		dos.writeUTF("Hello");
//		dos.writeUTF("�ȳ��ϼ���");
//		System.out.println("Save Success");
//		dos.close();

		DataInputStream dis =
				new DataInputStream(new FileInputStream("data.dat"));
//		System.out.printf("%b", dis.readBoolean()); //���� ���� �������� �����߱� ������ Boolean���� ������ �ȵȴ�. 

		System.out.printf("%d\n", dis.readInt()); //���� ó���� 90�� �����߱� ������
		System.out.printf("%.1f\n", dis.readDouble()); //���� ó���� 90�� �����߱� ������
		System.out.printf("%b\n", dis.readBoolean()); //���� ó���� 90�� �����߱� ������
		System.out.printf("%c\n", dis.readChar()); //���� ó���� 90�� �����߱� ������
		System.out.printf("%s\n", dis.readUTF()); //���� ó���� 90�� �����߱� ������
		System.out.printf("%s\n", dis.readUTF()); //���� ó���� 90�� �����߱� ������
		
		dis.close();
		
	}
}
