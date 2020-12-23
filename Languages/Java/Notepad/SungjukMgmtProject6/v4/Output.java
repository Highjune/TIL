import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;

public class Output {
	private Vector<Student> vector;
	private FileOutputStream fos;
	
	public Output(Vector<Student> vector) {
		this.vector = vector;
		try {
			this.fos = new FileOutputStream("C:/temp/result.txt", true);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");			
		}
	}
	
	public void output() {
		try {	
			this.printlabel();
			for(Student s : this.vector) {
				this.fos.write(s.toString().getBytes("UTF-8"));
				this.fos.write(10);
			}
				this.fos.flush();
				System.out.println("File Save Succees");
			
		} catch(IOException ex) {
			System.out.println(ex);
		} finally {
			try {
				this.fos.close();
			} catch (IOException e) {
				System.out.println(e);
			}
		}
	}
	
	private void printlabel() throws IOException {
		this.fos.write("----------------------------------".getBytes("UTF-8"));
		this.fos.write(10);
		this.fos.write("-----------SungjukMgmt6-----------".getBytes("UTF-8"));
		this.fos.write(10);
		this.fos.write("----------------------------------".getBytes("UTF-8"));
		this.fos.write(10);
		this.fos.write("kor	eng	mat	tot	avg	grade	".getBytes("UTF-8"));
	}	
	
}
