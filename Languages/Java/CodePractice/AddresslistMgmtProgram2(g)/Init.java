import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Init {    
	private ObjectInputStream ois;
	private Socket socket; //������ ��û�� socket
	private ArrayList<Person> list;
	
	
	public Init() {
		DataOutputStream dos = null;
		try {
			this.socket = new Socket("localhost", 7777); //���� ã�ư�, socket������
			dos = new DataOutputStream(this.socket.getOutputStream());//���ڸ� ������ �ϴϱ� DataOutputStream(���ڸ� ������ ���ڸ� ���� �� ����)
			dos.writeInt(1); //�������� 1�� ������ ��. 
			/*
			 * Server�κ��� ������ ArrayList<Person>�� ������ȭ
			 */
			//������ �������� 1�� �������� ������ case:1�� �޾Ƽ� ��ü�� �����ϱ� ���⼭ �� ��ü�� �ޱ� ���� ObjectInputStream. ==> �� ��Ʈ��ũ�κ��� arraylist<person>�� �޴� ����.
			ObjectInputStream ois = new ObjectInputStream(this.socket.getInputStream());//ObjectInputStream�� ���� socket�� ����Ű�� �ִ�. 
			this.list = (ArrayList<Person>)ois.readObject(); //readObject�� socket���κ��� ��ü�� �о object�� return�ϴϱ� ������ ����ȯ. readObject : OjbectInputStream���� ��ü�� �о���δ�.
			//System.out.println(list.size());
		}catch(IOException ex) {
			ex.printStackTrace();
		}catch(ClassNotFoundException ex) {
			System.out.println(ex);
		}
	} 
	public ArrayList<Person> init() {
		return this.list;
	}
}
