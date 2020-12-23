import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

/*
 * ArrayList<Person>을 Server로 직렬화 (네트워크로)
 */
public class Save {
	private ArrayList<Person> list;
	private ObjectOutputStream oos;
	private Socket client;
	
	public Save(ArrayList<Person> list) {//메인에서 arraylist를 받음.
		this.list = list;
		try { //네트워크로 파일을 내보내는 것
			this.client = new Socket("localhost", 7777);
			DataOutputStream dos = new DataOutputStream(this.client.getOutputStream());
			dos.writeInt(2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void save() {
		try {  
			ObjectOutputStream oos = new ObjectOutputStream(
					this.client.getOutputStream());
			oos.writeObject(this.list);//작업한 arraylist를 네트워크로 발송
			oos.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
}
