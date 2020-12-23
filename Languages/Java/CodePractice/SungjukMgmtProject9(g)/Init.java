/*
 * ���α׷��� ó�� ����Ǹ� C:/temp/sungjuklist.ser ������ ���� ������ �� ������ �����Ѵ�.
 * ���� �ִٸ� EOFException�� �߻��ϰų� ���������� ������ȭ�� �ϰų� �Ѵ�.
 */

/*
 * ����ȭ���� EOFException�� ���� �߻���. �߻��ϴ� ������ ��ü�� ���� �� null�̳� -1�� return ���� �ʰ� EOFException�� �߻���Ų��.
 * ó����� : 1���� 2���� �ϰų�(����ȭ�� ���� �س��ų�) /// 3���� �ϰų� 
 * 1) writeObject() �� �����ϰų� 2)writeObject()�� ���� �������� null�� �ϰų� 
 *             3)EOFException�� �߻���Ű�� �ȴ�. 
 *             (�Ʒ������� 3��ó��)
 */


import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Vector;

public class Init {
	private ObjectInputStream ois; //ó���� �������� �ε��Ǹ� ��� ���� �ִ� ~~.ser������ �о�;� �Ǵϱ�(�ȿ� �ִ� vector)
	
	public Init(String path) {
		File file = new File(path); 
		try {
			if(file.exists()) {  //�ش� ������ �ִٸ� true(�ѹ��̶� ������ ���α׷��� �����ߴٸ� �ִ� ����. ������ ����Ǿ��� ���� ���� ���̹Ƿ�)
				this.ois = new ObjectInputStream(new FileInputStream(file)); //������ �������� ����.
			}else {  //������ ���ٸ� --> ó�� ���α׷��� �����ߴٸ� ���� ���� ����.
				file.createNewFile();
			} //EEOFException�� �ڽ��̹Ƿ� �θ𺸴� ������ ����!(�Ʒ� catch��)
		}catch(EOFException ex) {  //������ ������ ����ִٸ� �߻�. (������ ObjectInputStream���� End OF File Exception �߻�)// �Ű������� FileInputstrem�� File�� �ִ��� �������� �Ǵ��ϴ� ���̱� ������ ���� X
			this.ois = null; //�̰��� null�̸� ���� init()���� null�� �ɸ�.
		}catch(IOException ex) {
			System.out.println(ex); //user���Դ� �� �޽��� �����ָ� �� (������ ���� �̰͸�~)
			ex.printStackTrace(); //�̷��� ����ָ� ����(������ ���忡���� ���� �޽����� ���� ���� ����)
		}
	}
	
	public Vector<Student> init(){ //�۾��� ������ ��� �� �ȿ� �ִ� Vector�� ������ȭ�ؼ� vector�� �������ִ� ��.
		Object obj = null;
		try {
			if(this.ois != null)	obj = this.ois.readObject();  //os�� null�� �ƴϸ� readObject�� ������ȭ
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(ois != null && obj != null) { //ObjectInpuStream�� ������ �ְ� �� ���� ���뵵 �ִٸ�(��, �� �� null�� �ƴϸ�)
			return (Vector<Student>)obj; //������ readObject�� �о����� Object�ϱ� ��������ȯ�ؼ� �ѱ��~
		} else {
			return new Vector<Student>(1,1); //������ ���� ���� �ѱ�~
		}
	}
}






