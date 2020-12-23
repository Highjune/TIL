import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

//Student class와 함께

public class SerializationDemo1 {
	public static void main(String[] args) throws IOException{
		String path = "C:/temp/student.ser";
		Student chulsu = new Student("2019-01", "김철수", 56, 78, 90);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
	
		oos.writeObject(chulsu); // Student클래스가 extends Serializable 안하면 에러난다. 그 안의 변수들은 primitive이므로 다 가능한데.
		System.out.println("Save Success");
		oos.close();
	
	}
}
