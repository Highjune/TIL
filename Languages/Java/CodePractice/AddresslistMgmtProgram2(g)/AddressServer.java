import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


//서버를 먼저 만들어야 된다. 서버가 받을 수 있는 타입을 만들어야 client가 보내기 때문.
//Client로부터 1: LOAD, 2:SAVE
public class AddressServer {
	private ServerSocket server;
	private AddressServer() throws IOException { //생성자
		server = new ServerSocket(7777);
		System.out.println("I'm waiting...");
	}
	
	private void service() throws IOException, ClassNotFoundException{
		while(true) { //클라이언트가 들어올 때마다 호출
			Socket client = this.server.accept(); //나의 서버에 user가 들어오는 순간 accept되고 client용 socket이 만들어짐. cf) client는 2번 들어온다. (로드과 마지막 세이브할 때)
			process(client); //여기서 처리하지 않고 process메서드로 보내버림.
		}
	} //여기서는 무한루프를 돌겠지만 한 클라이언트는 밑의 process에서 처리하고 끝.(socket exception발생을 막기 위해)
	
	
	private void process(Socket client) throws IOException, ClassNotFoundException {
		DataInputStream dis = new DataInputStream(client.getInputStream());//DataInputStream, DataOutputStream은 숫자를 숫자로, 정수는 정수로, 글자는 글자 등으로 그대로 읽기 위해서.  
		switch(dis.readInt()) { //여기서는 들어온 1을 1 그대로 읽으려고  DataInputstream.
			case 1:  //client가 file달라고 요청
				/*
				 * 자신의 하드디스크에 있는 파일을 역직렬화(하드디스크에서 .ser파일을 찾는다. 없으면 새로 만들고)한 후, 네트워크로 Client에게 보낼 때는 직렬화
				 */
				File readFile = new File("C:/temp/addresslist.ser"); 
				if(!readFile.exists())   readFile.createNewFile(); //만약 addresslist.ser파일이 없으면(처음 이 프로그램을 실행했을 시)
				ObjectInputStream ois = null; 
				if(readFile.length() == 0)  ois = null; //파일은 있는데 데이터는 없는 경우
				//역직렬화 : 하드디스크에 있는 객체를 불러온다.(이미 존재)
				else ois = new ObjectInputStream(new FileInputStream(readFile)); //파일도 있고 그 안에 데이터도 있는 경우
				ArrayList<Person> list = null;
				if(ois == null) list = new ArrayList<Person>(1);
				else list = (ArrayList<Person>)ois.readObject();
				
				//직렬화(네트워크로 보내야 하니까)
				ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
				oos.writeObject(list);//arraylist를 네트워크로 보냄.
				System.out.println("Client에게 발송 성공");    client.close();     break; //client.close()하는 이유는  client에게 발송하고 끊어야지 socket exception방지하려고.
				//실제로 한 client가 하나의 서버에 계속 물려있으면(socket 열린 상태로 계속) 부담스럽다. 그래서 하나 처리하고 끊고 다시~ 
				
			case 2:  //save하겠다는 말.(client에서 서버(여기)로 arrayList<person>보냄) => 네트워크로부터 전달해 온 것을 읽는 것
				/*
				 * Client로부터 역직렬화한 후 하드디스크로 직렬화
				 */
				//역직렬화(client가 보낸 arraylist를)
				ObjectInputStream ois1 = new ObjectInputStream(client.getInputStream()); //Object를 읽을 수 있는 readObject는 읽어들이는 종류 중에서 ObjectInputStream에만 있다.
				ArrayList<Person> list1 = (ArrayList<Person>)ois1.readObject();
				File saveFile = new File("C:/temp/addresslist.ser");
				//직렬화(하드디스크로)
				ObjectOutputStream oos1 = new ObjectOutputStream(
						new FileOutputStream(saveFile));
				oos1.writeObject(list1);    
				System.out.println("Save Success");    client.close();     
				break;
		}
	}
	public static void main(String[] args) {
		try {//이 Exception은 AddressServer생성자 만들어질 때 저기서 Throws로 던졌으니까 이쪽으로 넘어온 것이다. 그래서 여기서도 예외 던지면 조 그러니까 try catch 잡아주는 것.
			new AddressServer().service();
		}catch(IOException e) {
			e.printStackTrace(); //예외발생한 곳의 정확한 위치까지. (예외의 종류와 위치까지)
		}catch(ClassNotFoundException e) {
			System.out.println(e);
		}
	}
}
