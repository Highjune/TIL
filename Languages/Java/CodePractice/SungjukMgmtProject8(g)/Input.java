import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.Vector;

public class Input {
	private Vector<Student> vector;
	private RandomAccessFile raf; //�б������ ~, ������� ����� ȭ������̹Ƿ� Randomaccessfile�� ����� X, �д°͸�.
	
	public Input(Vector<Student> vector) {   //Constructor
		this.vector = vector; //���ο��� vector �ѱ䰪���� vector�ʱ�ȭ 
		try {
			this.raf = new RandomAccessFile("sungjuk_utf8.csv", "r");  //raf�ʱ�ȭ // �����ڴ� �б����̹Ƿ� r
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		}
	}
	
	public void input() { 
		String line = null;
		try { //readLine() API���� throws IOException�ϴϱ�. randomAccessFile�� ���پ� readLine�д´�.
			while((line = this.raf.readLine()) != null) {//���پ� �о line�� ����//1101,     �Ѽ���,     78,     87,     83,     78
				String str = CharUtility.entoutf8(line); //randomaccess������ ������ �ѱ�(�Ϻ�, �߱�� ��������)�� �����ϱ� ���� CharUtility��.
				Scanner scan = new Scanner(str).useDelimiter(",\\s+"); // ,\\s+ �� �ǹ̴� ,�ڿ� �����̽� 1�� �̻� �ִ�. ���Խ� ǥ���� ����.
				Student student = new Student(scan.next(), scan.next(), 
						scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt()); //1101, �Ѽ���, 78, 87, 83, 78�� �д� ����.
				this.vector.addElement(student);
			}
		} catch (IOException e) { //������ ���ѷ��� ���ٰ� ���� �߻��ϸ� �ٷ� stop�� catch��.
			System.out.println(e);
		}
	}
}



