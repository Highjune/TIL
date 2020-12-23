import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


//������ ���� ������ �ȴ�. ������ ���� �� �ִ� Ÿ���� ������ client�� ������ ����.
//Client�κ��� 1: LOAD, 2:SAVE
public class AddressServer {
	private ServerSocket server;
	private AddressServer() throws IOException { //������
		server = new ServerSocket(7777);
		System.out.println("I'm waiting...");
	}
	
	private void service() throws IOException, ClassNotFoundException{
		while(true) { //Ŭ���̾�Ʈ�� ���� ������ ȣ��
			Socket client = this.server.accept(); //���� ������ user�� ������ ���� accept�ǰ� client�� socket�� �������. cf) client�� 2�� ���´�. (�ε�� ������ ���̺��� ��)
			process(client); //���⼭ ó������ �ʰ� process�޼���� ��������.
		}
	} //���⼭�� ���ѷ����� �������� �� Ŭ���̾�Ʈ�� ���� process���� ó���ϰ� ��.(socket exception�߻��� ���� ����)
	
	
	private void process(Socket client) throws IOException, ClassNotFoundException {
		DataInputStream dis = new DataInputStream(client.getInputStream());//DataInputStream, DataOutputStream�� ���ڸ� ���ڷ�, ������ ������, ���ڴ� ���� ������ �״�� �б� ���ؼ�.  
		switch(dis.readInt()) { //���⼭�� ���� 1�� 1 �״�� ��������  DataInputstream.
			case 1:  //client�� file�޶�� ��û
				/*
				 * �ڽ��� �ϵ��ũ�� �ִ� ������ ������ȭ(�ϵ��ũ���� .ser������ ã�´�. ������ ���� �����)�� ��, ��Ʈ��ũ�� Client���� ���� ���� ����ȭ
				 */
				File readFile = new File("C:/temp/addresslist.ser"); 
				if(!readFile.exists())   readFile.createNewFile(); //���� addresslist.ser������ ������(ó�� �� ���α׷��� �������� ��)
				ObjectInputStream ois = null; 
				if(readFile.length() == 0)  ois = null; //������ �ִµ� �����ʹ� ���� ���
				//������ȭ : �ϵ��ũ�� �ִ� ��ü�� �ҷ��´�.(�̹� ����)
				else ois = new ObjectInputStream(new FileInputStream(readFile)); //���ϵ� �ְ� �� �ȿ� �����͵� �ִ� ���
				ArrayList<Person> list = null;
				if(ois == null) list = new ArrayList<Person>(1);
				else list = (ArrayList<Person>)ois.readObject();
				
				//����ȭ(��Ʈ��ũ�� ������ �ϴϱ�)
				ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
				oos.writeObject(list);//arraylist�� ��Ʈ��ũ�� ����.
				System.out.println("Client���� �߼� ����");    client.close();     break; //client.close()�ϴ� ������  client���� �߼��ϰ� ������� socket exception�����Ϸ���.
				//������ �� client�� �ϳ��� ������ ��� ����������(socket ���� ���·� ���) �δ㽺����. �׷��� �ϳ� ó���ϰ� ���� �ٽ�~ 
				
			case 2:  //save�ϰڴٴ� ��.(client���� ����(����)�� arrayList<person>����) => ��Ʈ��ũ�κ��� ������ �� ���� �д� ��
				/*
				 * Client�κ��� ������ȭ�� �� �ϵ��ũ�� ����ȭ
				 */
				//������ȭ(client�� ���� arraylist��)
				ObjectInputStream ois1 = new ObjectInputStream(client.getInputStream()); //Object�� ���� �� �ִ� readObject�� �о���̴� ���� �߿��� ObjectInputStream���� �ִ�.
				ArrayList<Person> list1 = (ArrayList<Person>)ois1.readObject();
				File saveFile = new File("C:/temp/addresslist.ser");
				//����ȭ(�ϵ��ũ��)
				ObjectOutputStream oos1 = new ObjectOutputStream(
						new FileOutputStream(saveFile));
				oos1.writeObject(list1);    
				System.out.println("Save Success");    client.close();     
				break;
		}
	}
	public static void main(String[] args) {
		try {//�� Exception�� AddressServer������ ������� �� ���⼭ Throws�� �������ϱ� �������� �Ѿ�� ���̴�. �׷��� ���⼭�� ���� ������ �� �׷��ϱ� try catch ����ִ� ��.
			new AddressServer().service();
		}catch(IOException e) {
			e.printStackTrace(); //���ܹ߻��� ���� ��Ȯ�� ��ġ����. (������ ������ ��ġ����)
		}catch(ClassNotFoundException e) {
			System.out.println(e);
		}
	}
}
