import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Save {
	private ArrayList<Person> list;
	private String path;
	public Save(ArrayList<Person> list, String path) {
		this.list = list;    this.path = path;
	}

	public void save() { //직렬화를 위해.(저장)
		try {
			ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream(path));
			oos.writeObject(this.list);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
}





