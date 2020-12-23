import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Init {    //������ : 0, �Ǽ��� : 0.0, boolean : false, char : �ΰ�, null ==> �׷��� ois�� null. �����͸� �о��� ���� null�� �ƴ� 
	//3���� ���̽�
	//1. ������ �־��µ� �����Ͱ� �ִ� ���(null�ƴ�)
	//2. ������ ������ => ����鼭 null  
	//3. ������ �ִµ� data�� ���� => null (this.ois = null) 
	
	private ObjectInputStream ois;
	
	public Init(String path) { //������(���⼭ �ϴ� ���� ����)
		File file = new File(path); //FileŬ���� ����� ������ �� ��ο� �������������� ���ؼ� �˰� �;. �׷��� �Ʒ����� �����Ѵٸ�~ ������Ѵٸ�~ ���� ������ �� ����.
		try {
			if(file.exists()) {  //������ �ִٸ� ������ȭ ����, �̹� �ѹ� �̻� ����ߴٸ�
				this.ois = new ObjectInputStream(new FileInputStream(file)); // ObjectInputStream�� EOFException �߻��ϴ� ����.
			}else {  //������ ���ٸ�, ���α׷��� ó�� ����ϴϱ� // ������ ���� ����� null�Է�.
				file.createNewFile(); // .ser����.
				this.ois = null; //
			}
		}catch(EOFException ex) {   //������ȭ�� ��, �����Ͱ� ���ٸ� null / -1�� �ƴ϶�, EOF �߻� /// EOFó�� ��� 3����. 1. write�� �����ϱ�. 2. write�� �� �� null�ֱ�. 3. null�ֱ�(���⼭�� init()�� ����  ���� �ϹǷ� ����ó�� null�ֱ�)
			this.ois = null;
		}catch(IOException ex) {
			System.out.println(ex);
		}
		
	}
	public ArrayList<Person> init() {
		ArrayList<Person> list = null;
		try {
			if(this.ois != null) { //null�� �ƴ϶�� ���� ois�� ����� �ִٴ� ��.(���ϵ� �־��� �����͵� �־��� ���) �ȿ� �����Ͱ� �����ϱ� readObject�� �о����.
				list = (ArrayList<Person>)this.ois.readObject(); //���� �����ڿ��� ���� ���뿡�� readOBject�� ���� ������ �о��. �׷��� �о���� ���� object�̹Ƿ� ��������ȯ(�� �θ��� object�� �ڽ����� ��������ȯ)
			}
		}catch(ClassNotFoundException | IOException ex) { // | �� or�ǹ� , 2���� catch�� ���� �ʱ� ����.
			System.out.println(ex);
		}
		if(list == null) list = new ArrayList<Person>(1);   
		return list; //���⼭ list��  null�� �ƴ� data�� �����ϵ���, null�̶�� 1�� ������༭ �ѱ��. list�� null�� �ɼ��� ����. insert���� this.list.add(Person)���� list�� null�̸� �ȵǹǷ�
	}
}
