import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;

public class Output {
	private Vector<Student> vector;
	private FileOutputStream fos;
		
	public Output(Vector<Student> vector) {
		this.vector = vector;
		try {
			fos = new FileOutputStream("C:/temp/sungjukmgmt7.txt", true);
		}catch(IOException ex) {
			System.out.println(ex);
		}
	}
	
	public void output() {
		try {
			printlabel();
			for(Student s : this.vector) {
				this.fos.write(10);
				this.fos.write(s.toString().getBytes("UTF-8"));			
			}		
				 this.fos.flush();
				System.out.println("File Save Success");	
		}catch(IOException ex) {
				System.out.println("File Save Failure");
		}finally {
			try {
				this.fos.close();
			} catch (IOException e) {
				System.out.println(e);
			}
	}
}
	
	private void printlabel() throws IOException{
		this.fos.write(10);
		this.fos.write("------------------------이것은 라벨-----------------------------".getBytes("UTF-8"));
		this.fos.write(10);
		this.fos.write("------------------------이것은 성적관리프로젝트7------------------".getBytes("UTF-8"));
		this.fos.write(10);		
	}
	
}
