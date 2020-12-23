import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Vector;


public class Init {
	private ObjectInputStream ois;
	
	
	public Init(String path) {
			File file = new File(path);
			
			try {
				if(file.exists()) {
					this.ois = new ObjectInputStream(new FileInputStream(file));
				} 
				else {
					file.createNewFile(); 
				}
			}catch(EOFException ex) {
				this.ois = null;
			}catch(IOException ex) {
				System.out.println(ex);
				ex.printStackTrace();
			}	
	}
	
	public Vector<Student>  init() {
		Object obj  = null;
		if(this.ois != null)
			try {
				obj = this.ois.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		if(ois != null &&  obj != null) {
			return (Vector<Student>)obj;
		}else {
			return new Vector<Student>(1, 1);
		}
	}
}


