import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;


//�׻� �̷��� ������ ���� ����, Student(ex), Main, Input, Output ���� �ϼ��ϰ� ���� ����� �Ǵ��� Ȯ�� �� calc sort�� ~ 
public class Output { //ȭ�������.
	private Vector<Student> vector;
	
	public Output(Vector<Student> vector) {
		this.vector = vector;
	}
	
	public void output() {
		this.printLabel();
		for(Student s : this.vector) {
			System.out.println(s.toString());
		}
	}
	private void printLabel() {
		System.out.println("                <<�ֿ����б� �����������α׷�>>");
		System.out.println("�й�    �̸�    ����    ����    ����   ����   ���    ����");
		System.out.println("------------------------------------------------");
	}
}
