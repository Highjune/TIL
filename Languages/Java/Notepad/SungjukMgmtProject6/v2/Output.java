import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;

public class Output{
	private Vector<Student>vector;
	private FileOutputStream fos;
	
	public Output(Vector<Student> vector) {
		this.vector = vector;
		try {
			this.fos = new FileOutputStream("C:/temp/sungjuk6.txt", true);
		}catch(IOException ee) {
			System.out.println("File not found");
		}
	}
	
	public void output() {
		try {
			printlable();
			for(Student s : this.vector) {
				this.fos.write(s.toString().getBytes("UTF-8"));	
				this.fos.write(10);
			}
			System.out.println("File save Success");
		}catch(IOException e) {
			System.out.println(e);
		}finally {
			try {
				this.fos.close();
			}catch(IOException ex1) {
				System.out.println(ex1);
			}
		}
		
	}
	
	private void printlable() throws IOException {
		this.fos.write("------------------------------------------------".getBytes("UTF-8"));
		this.fos.write("-------------SungjukMgmtProject-----------".getBytes("UTF-8"));
		this.fos.write(10);
		this.fos.write("code	name	kor	eng	mat	tot	avg	grade".getBytes("UTF-8"));
		this.fos.write(10);
		this.fos.flush();
		
		
	}
		
	
	
	
}