import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;

public class Output {
	private Vector<Student> vector;
	private FileOutputStream fos; // file�� ������ �Ŵϱ� FileOutPutStream. 
	
	public Output(Vector<Student> vector) { //������
		this.vector = vector;
		try { 		//�����ڷμ� ���� �������(fos) �ʱ�ȭ
			this.fos = new FileOutputStream("C:/temp/result.txt", true); //��� ���� �ѹ��� �������� ���� �ƴ϶� �л����� �ٹٲ㼭 �������� �Ǵϱ� append�ؾ� �Ǵϱ� true
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		} 
	}
	
	
//	�ѱ��� ����Ʈ �迭�� �ٲٰ� �װ��� �������� ���ۿ� ������ �� �����ϱ� flush ����� �ǰ� �Ŷ��θ��� �ٹٲ� ����� �ȴ�.
//	������ ���� ���� ������ vector���� �� �л��� �̾Ƽ� ���
	public void output() {
		try {
			this.printLabel();
			for(Student s : this.vector) {
				this.fos.write(s.toString().getBytes("UTF-8")); //toString()�� ���ڿ��̹Ƿ�. 
				this.fos.write(10); //�� �л����� ��� �� �ٲ�� �Ǵϱ� �ٹٲ�.
			}
			this.fos.flush();//�л����� �Ѳ����� flush. ��� ���� for���� �־ �Ѹ� flush�ص� �ȴ�.
			System.out.println("File Save Success."); //�̰��� �����ٴ� ���� exception�� �߻����� �ʾҴٴ� ��.  
		}catch(IOException ex) { //try �������� exception�߻��ϸ� ������ catch�� �Ѿ�´�.
			System.out.println(ex);
		}finally {
			try {
				this.fos.close(); //�Ҹ���
			}catch(IOException ex) {}
		}
	}
	
	//�л���������͸� ������ ������ ��δ� C:/temp/result.txt
	private void printLabel() throws IOException {
		this.fos.write("                <<�ֿ����б� �����������α׷�>>".getBytes("UTF-8")); //String("")�� getBytes�� �ٲٴµ� utf-8�� �ٲ۴�. �׸��� �̷��� �ٲ� ����Ʈ �迭�� ���ۿ� write�Ѵ�.
		this.fos.write(10); //�ٹٲ�
		this.fos.write("�й�    �̸�    ����    ����    ����   ����   ���    ����".getBytes("UTF-8")); 
		this.fos.write(10);
		this.fos.write("------------------------------------------------".getBytes("UTF-8"));
		this.fos.write(10);
		this.fos.flush(); //���� �͵��� �� ���ۿ� ��Ҵµ�, �̰��� flush
	}
}


