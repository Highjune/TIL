import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Vector;

public class Output {
	private Vector<Student> vector;
	private ObjectOutputStream oos;
	
	public Output(Vector<Student> vector, String path) { //��������. Main���� ������ ������ �� �� vector�� �Ѿ����~ 
		this.vector = vector;
		try {
			this.oos = new ObjectOutputStream(new FileOutputStream(path));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void output() {
		//this.printLabel(); //������ ���Ϸ� ������ ���̱� ������ ���� printLabel�� �ʿ䰡 ����.
		try {
			this.oos.writeObject(this.vector);
			System.out.println("Save Success.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  //����ȭ
	}
	private void printLabel() {
		System.out.println("            <<�ֿ����б� �����������α׷�>>");
		System.out.println("�й�    �̸�    ����    ����    ����   ����   ���    ����");
		System.out.println("------------------------------------------------");
	}
}
