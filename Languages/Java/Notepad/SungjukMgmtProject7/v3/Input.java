import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

public class Input {
	private Vector<Student> vector;
	private FileInputStream fis;
	
	public Input(Vector<Student> vector) {
		this.vector = vector;
		try {
			this.fis = new FileInputStream("C:/temp/sungjuk.txt");
		} catch (FileNotFoundException e) {
			System.out.println("File not Found");
		}
	}
	
	public void input() {
		try {
		byte[] buffer = new byte[this.fis.available()];
		int max = this.fis.read(buffer);
		String str = new String(buffer, 0, max);
		StringTokenizer st = new StringTokenizer(str, "\n");
		String[] array = new String[st.countTokens()];
		for(int i=0; i<array.length ; i++) {
			array[i] = st.nextToken();
			Scanner scan = new Scanner(array[i]).useDelimiter("\\s+");
			Student student = new Student(scan.next(), scan.next(), scan.nextInt(), scan.nextInt(), scan.nextInt());
			this.vector.add(student);					
		}		
		}catch(IOException e) {
			System.out.println(e);
		}
	}
}



