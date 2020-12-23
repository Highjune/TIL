import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FilterStreamDemo {
	public static void main(String[] args) throws IOException {
		DataOutputStream dos = 
				new DataOutputStream(new FileOutputStream("data.dat"));
		dos.writeInt(90);
		dos.writeDouble(89.5);
		dos.writeBoolean(true);
		dos.writeChar(65);
		dos.writeUTF("Hello");
		dos.writeUTF("�ȳ��ϼ���.");
		System.out.println("Save Success.");
		dos.close();
		
		DataInputStream dis  = 
				new DataInputStream(new FileInputStream("data.dat"));
//		System.out.printf("%b", dis.readBoolean()); ���� ���� ������ �����߱� ������ ������ ���Ѿ� �Ѵ�.
		System.out.printf("%d\n", dis.readInt());
		System.out.printf("%.1f\n", dis.readDouble());
		System.out.printf("%b\n", dis.readBoolean());
		System.out.printf("%c\n", dis.readChar());
		System.out.printf("%s\n", dis.readUTF());
		System.out.printf("%s\n", dis.readUTF());
		
		dis.close();	
	}
}





