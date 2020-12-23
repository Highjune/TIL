import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

public class Input {
	private Vector <Student> vector;
	private FileInputStream fis;
	
	public Input(Vector<Student> vector) {
		this.vector = vector;
		try {
			fis = new FileInputStream("C:/temp/sungjuk.txt");
		}catch(IOException ex) {
			System.out.println("File Not Found");
		}
	}
	
	public void Input() {
		try {
			byte[] buffer = new byte[this.fis.available()];
			int quantity = this.fis.read(buffer);
			String st = new String(buffer, 0, quantity);
			StringTokenizer stt = new StringTokenizer(st, "\n");
			String[] array = new String[stt.countTokens()];
		
		for(int i = 0 ; i<array.length ; i++) {
			array[i] = stt.nextToken();
			Scanner scan = new Scanner(array[i]).useDelimiter("\\s+");
			Student student = new Student(scan.next(), scan.next(), scan.nextInt(), scan.nextInt(), scan.nextInt());
			this.vector.add(student);			
		}
			System.out.println("File Input Success");
		}catch(IOException ex) {
			System.out.println(ex);
		}
	}
	
}
