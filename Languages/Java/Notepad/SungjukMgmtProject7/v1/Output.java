import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;

public class Output {
	private Vector<Student> vector;
	private FileOutputStream fis;
	
	public Output(Vector<Student> vector) {
		this.vector = vector;
		try {
			fis = new FileOutputStream("C:/temp/sungjuk7.txt", true);
			}catch(IOException e) {
			System.out.println("File not found");
		}
	}
	
	public void output() {
		try {
			printlabel();
			for(Student s : this.vector) {
				this.fis.write(s.toString().getBytes("UTF-8"));
				this.fis.write(10);
			}			
			this.fis.flush();
			System.out.println("File save success");
		}catch(IOException e) {
			System.out.println("File not found");
		}finally {
			try {
				this.fis.close();
			}catch(IOException ex) {
				
			}
			
		}
	}
	
	private void printlabel() throws IOException{
		this.fis.write("--------------------------------------------------------".getBytes("UTF-8"));
		this.fis.write(10);
		this.fis.write("--------------------sungjukmgmt7---------------------".getBytes("UTF-8"));
		this.fis.write(10);		
		this.fis.flush();
	}
	
}
