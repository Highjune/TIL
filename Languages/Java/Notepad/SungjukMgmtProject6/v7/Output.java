import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;

public class Output {
	private Vector<Student> vector;
	private FileOutputStream fos;
	
	public Output(Vector<Student> vector) {
		this.vector = vector;
		try {
			fos = new FileOutputStream("C:/temp/sungjuk720200621result.txt", true);
		}catch(IOException e) {
			System.out.println("File not Found");
		}
	}
		
	public void output() {
		try {
			printlabel();
			for(Student s : this.vector) {
				this.fos.write(10);
				this.fos.write(s.toString().getBytes("UTF-8"));
				this.fos.write(10);
			}
				System.out.println("File save success");
		}catch(IOException e) {
			System.out.println("File not Found");
		}finally {
			try {
				this.fos.close();
			}catch(IOException e) {}
		}
		
	}	
	
	private void printlabel() throws IOException {
		this.fos.write(10);
		this.fos.write("-----------------------------------------------------".getBytes("UTF-8"));
		this.fos.write(10);
		this.fos.write("---------------Sungjuk Mgmt--------------".getBytes("UTF-8"));
		this.fos.write(10);
		this.fos.write("hakbun	name	kor	eng	mat	tot	avg	grade".getBytes("UTF-8"));
	}
	
}
