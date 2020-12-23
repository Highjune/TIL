import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;

public class Output{
	private Vector<Student>vector;
	private FileOutputStream fos;
	
	public Output(Vector<Student> vector) {
		this.vector = vector;
		try {
			fos = new FileOutputStream("C:/temp/SungjukMgmtProject6test", true);
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		}
	}
	
	public void output() {
		this.printlabel();
		for(student s : )
		
		
	}
	
	
	private void printlabel(){
		try {
			this.fos.write("            <<성적관리프로젝트6>>            ".getBytes("UTF-8"));
			this.fos.write(10);
			this.fos.write("---------------------------------------------".getBytes("UTF-8"));
			this.fos.write("학번	이름	국어	영어	수학	총점	평균	등급".getBytes("UTF-8"));		
		}catch(IOException e) {
			System.out.println(e);
		}
	}
	
}





