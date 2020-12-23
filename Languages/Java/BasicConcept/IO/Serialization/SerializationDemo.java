import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;

//��� ��ü�� �� ����ȭ�� ������ ���� �ƴϴ�.
//2���� ���� �� �ϳ��� �����ؾ� �ȴ�
//1.primitiveŸ��(8����)�� ������ ����
//2.Serializable �ڽĸ� ���� (Serializable �������̽��� �����ϸ� ����)

public class SerializationDemo {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		//����ȭ - DateŬ���� ��ü�� ����ȭ�Ͽ� File�� �����ϱ�(���ڿ��� ������ ���� �ƴ�)
//		Date now = new Date(); //Date API���� Serializable�������̽� �����߱� ������ ����ȭ �����ϴ�
//		FileOutputStream fos = new FileOutputStream("C:temp/date.ser"); //���� ����ȭ�� �Ǵ� �͵��� .serȮ���ڷ� ���� ����.
//		ObjectOutputStream oos = new ObjectOutputStream(fos); //API���� OutputStream�� �ڽ� �� �� �� �����ϱ� FileOutputStream�� �� �� �ִ� ����.
//		oos.writeObject(now); //����ȭ�� ��ü(now)
//		System.out.println("Save Success.");
		
		//������ȭ - ������ ����ȭ�� ���� �о���� ��.
		ObjectInputStream ois = 
				new ObjectInputStream(new FileInputStream("C:/temp/date.ser"));
		Object obj = ois.readObject(); //������ �������� Date���µ� ���� ���� Date���� �𸣴ϱ� readObject�� �д� ����, �׸��� ��ü����ȯ �ȵǰų� ��ü�� �� ã�ڴٰ� �ϴ� Classnotfoudnexception �߻���Ŵ
		if(obj instanceof Date) { //�츮�� ��� Date���� �� �˰� ������ ����. �׷��� ���� ���� �� �װ��� ���� Ÿ���� Date���� �𸣹Ƿ�.
			Date before = (Date)obj; 
			System.out.println(before); // ==>���� ��ü�� �ƴ϶� ������ new Date()�� ���� �ð��� ���. ��ġ �����ؼ� ���� ��ó�� ����.
		}
		ois.close();

		
	}
}



