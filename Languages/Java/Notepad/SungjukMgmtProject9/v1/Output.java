import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Vector;

public class Output {
	private Vector<Student> vector;
	private ObjectOutputStream oos;
	
	public Output(Vector<Student> vector, String path) {
		this.vector = vector;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(path));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void output() {
		
		try {
			this.oos.writeObject(this.vector);
			System.out.println("File Save Success.");	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
}
