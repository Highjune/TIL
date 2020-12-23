import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;

public class Output {
	private Vector<Student> vector;
	private FileOutputStream fos;
	
	public Output(Vector<Student> vector) {
		this.vector = vector;
		try {
		fos = new FileOutputStream("C:/temp/sungjukmgmt6result.txt", true);
		} catch (IOException e) {
			System.out.println("File not found");
		}
	}
	
	public void output() {		
		try {
			printlabel();
			this.fos.write(10);
		for(Student s : this.vector) {
			
			this.fos.write(s.toString().getBytes("UTF-8"));
			this.fos.write(10);		
		}
			this.fos.flush();
			System.out.println("File Save Success");
		}catch(IOException e) {
			System.out.println("File save failed");			
		}finally {
			try {
				this.fos.close();		
			}catch(IOException e) {}
		}
	}	
	
	private void printlabel() throws IOException {
		this.fos.write(10);
		this.fos.write("-----------성적관리프로젝트6--------------".getBytes("UTF-8"));
		this.fos.write(10);
		this.fos.write("-------------------------------------".getBytes("UTF-8"));
		this.fos.write(10);
		this.fos.write("kor	eng	mat	tot	avg	grade".getBytes("UTF-8"));
	}
}



