import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

public class Input{
	private Vector<Student> vector;
	private FileInputStream fis;
	private Scanner scan;
	
	public Input(Vector<Student> vector) {
		this.vector = vector;		
		try {
			this.fis = new FileInputStream("C:/temp/sungjuk.txt");
		}catch(IOException e) {
			System.out.println("File not found");
		}
	}
	
	public void input() {
		try {
			byte[] buffer = new byte[this.fis.available()];
			int number = this.fis.read(buffer);
			String str = new String(buffer, 0, number);
			StringTokenizer st = new StringTokenizer(str, "/n" );
			String[] array = new String[(st.countTokens())];
			for(int i = 0 ; i<array.length ; i++) {
				array[i] = st.nextToken();
				Scanner scan = new Scanner(array[i]).useDelimiter("\\s+");
				Student student = new Student(scan.next(), scan.next(), scan.nextInt(), scan.nextInt(), scan.nextInt());
				this.vector.addElement(student);
			}
			
		}catch(IOException e) {
			System.out.println(e);
		}	
		
		
	}
	
	
}

