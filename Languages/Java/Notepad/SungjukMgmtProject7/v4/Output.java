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
			this.fos = new FileOutputStream("C:/temp/sungjukmgmt7result.txt", true);
		} catch (FileNotFoundException e) {
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
			System.out.println("File save Success");
		}catch(IOException e) {
			System.out.println("File save failed");
		}finally {
			try {
				this.fos.close();
			}catch(IOException ex) {}
		}
	}
	
	
	private void printlabel() throws IOException{
		this.fos.write(10);
		this.fos.write("---------------성적관리프로젝트7---------------".getBytes("UTF-8"));
		this.fos.write(10);
		this.fos.write("------------------------------------------".getBytes("UTF-8"));
		this.fos.write(10);
		this.fos.write("hakbun	name	kor	eng	mat	tot	avg	grade".getBytes("UTF-8"));
		
	}
}
