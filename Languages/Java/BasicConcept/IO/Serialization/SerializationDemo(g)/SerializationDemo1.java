import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

//Student class�� �Բ�

public class SerializationDemo1 {
	public static void main(String[] args) throws IOException{
		String path = "C:/temp/student.ser";
		Student chulsu = new Student("2019-01", "��ö��", 56, 78, 90);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
	
		oos.writeObject(chulsu); // StudentŬ������ extends Serializable ���ϸ� ��������. �� ���� �������� primitive�̹Ƿ� �� �����ѵ�.
		System.out.println("Save Success");
		oos.close();
	
	}
}
