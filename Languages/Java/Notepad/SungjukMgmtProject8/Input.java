import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.Vector;



public class Input {
	private Vector<Student> vector;
	private RandomAccessFile raf;
	
	public Input(Vector<Student> vector) {
		this.vector = vector;
		try {
			this.raf = new RandomAccessFile("sungjuk_utf8.csv", "r"); //Q) sungjuk_utf8.csv 파일의 위치는?  Q) 그리고 csv는 ,로 구분되지 않았는데?
		} catch (FileNotFoundException e) {
			System.out.println("File not Found");
		}
	}
	
	public void input() { 
		String line = null;
		try {
		while((line=this.raf.readLine()) != null) { 
				String str = CharUtility.entoutf8(line);  //Q) 왜 en -> utf8?
				Scanner scan = new Scanner(str).useDelimiter(",\\s+");
				Student stu = new Student(scan.next(), scan.next(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt());
				this.vector.addElement(stu);				
		}
		}catch(IOException e) {
			System.out.println(e);
		}
			
			
			}
		}
		
	
	