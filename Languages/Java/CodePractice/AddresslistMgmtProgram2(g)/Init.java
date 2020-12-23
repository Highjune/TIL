import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Init {    
	private ObjectInputStream ois;
	private Socket socket; //서버에 요청할 socket
	private ArrayList<Person> list;
	
	
	public Init() {
		DataOutputStream dos = null;
		try {
			this.socket = new Socket("localhost", 7777); //서버 찾아감, socket연결함
			dos = new DataOutputStream(this.socket.getOutputStream());//숫자를 보내야 하니까 DataOutputStream(숫자를 보내고 숫자를 받을 수 있음)
			dos.writeInt(1); //서버에게 1번 보내는 것. 
			/*
			 * Server로부터 들어오는 ArrayList<Person>를 역직렬화
			 */
			//위에서 서버에게 1번 보냈으니 서버는 case:1로 받아서 객체를 보내니까 여기서 그 객체를 받기 위해 ObjectInputStream. ==> 즉 네트워크로부터 arraylist<person>을 받는 것임.
			ObjectInputStream ois = new ObjectInputStream(this.socket.getInputStream());//ObjectInputStream은 현재 socket을 가르키고 있다. 
			this.list = (ArrayList<Person>)ois.readObject(); //readObject가 socket으로부터 객체를 읽어서 object를 return하니까 강제로 형변환. readObject : OjbectInputStream으로 객체를 읽어들인다.
			//System.out.println(list.size());
		}catch(IOException ex) {
			ex.printStackTrace();
		}catch(ClassNotFoundException ex) {
			System.out.println(ex);
		}
	} 
	public ArrayList<Person> init() {
		return this.list;
	}
}
