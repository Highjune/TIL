import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;

public class Output {
	private Vector<Student> vector;
	private FileOutputStream fos;

	public Output(Vector<Student> vector) {
		this.vector = vector;		
		try {
			this.fos = new FileOutputStream("C:/temp/sungjukmgmt6.txt", true);
		}catch(IOException ex) {
			System.out.println("File not Found");
		}
	}
	
	public void output() {
		try {
			printlabel();
			for(Student s : this.vector) {
				this.fos.write(s.toString().getBytes("UTF-8"));			
				this.fos.write(10);
			}
				System.out.println("File save success");
				this.fos.flush();
		}catch(IOException ex) {
			System.out.println(ex);
		}finally {
			try {
				this.fos.close();
			}catch(IOException ex1) {
			}
		}
	}
	
	
	private void printlabel() throws IOException {
		this.fos.write("--------------sungjukmgmt6----------------".getBytes("UTF-8"));
		this.fos.write(10);
		this.fos.write("-----------------------------------------------".getBytes("UTF-8"));
		this.fos.write("code	name	kor	eng	mat	tot	avg	grade".getBytes("UTF-8"));
		this.fos.flush();
	}
}

