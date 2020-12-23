import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

//ProductŬ������ �Բ�
//����ȭ�� ������ȭ
public class SerializationDemo{
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		ArrayList<Product> list = new ArrayList<Product> (); 
		//��ǰ���� �迭�� ���� �ʰ� connection�� ��� ������ ��� �𸣴ϱ�~
		//connection ���ٰ� �ְ� �� �� �� �����ϱ�. �迭�� ������ �͸� ����.
		Product ballpen = new Product("�𳪹̺���", 300); 	list.add(ballpen);
		Product keyboard = new Product("Ű����", 15000);	list.add(keyboard);
		//�̷��� ���� arraylist�� ����ȭ!
		
		ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream("C:/temp/list.ser"));  //����ȭ�� ���� DB�� ������ ������ ���� �� ��m���� File�� �������� ��!
		oos.writeObject(list); //����ȭ. Product�� ������� �� �Ǵµ�, Product�� �ϰ� �Ϸ��� product�� implementS serializable
		//�׸��� �� product�� ��� �ִ� ArrayList�� ����ȭ �����Ѱ�? Arraylist API���� serializable�����ߴٰ� �Ǿ�����.
		System.out.println("Save Success.");
		oos.close(); //�̰͸� ������FileOutputStream�� ������. �̷��� ���ļ� ���� �ϳ��� �ݾƵ� ��.
//==>�̷��� �ϸ� list.ser������ (�˾ƺ������� �۾��̱� ������) Arraylist�ȿ� ballpen, keyboard�� ����ִ� ä�� ~
		//�̷��� ����ȭ�� ���� �ʰ� �Ǹ�, �л� 12�� �����Ϸ��� �ϸ� 12���� ���ڵ带 �� �����, �й�, �̸�, ����, ���� , ���� ���� �÷� �� �־�� �Ǵµ�
		//����ȭ�� ���� �Ǹ� 1���� �÷��̸� �ȴ�.
			
		//������ȭ(������ ����ȭ �� ��)
		ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream("C:/temp/list.ser")); 
		Object obj = ois.readObject();  //readObject�� ClassNotFoundException �߻�
		ArrayList<Product> list1 = (ArrayList<Product>)obj; //obj�� ��������ȯ�ؼ� ����.
		for(Product p : list1) {
			System.out.println(p);
		}
		ois.close();
	}
}



