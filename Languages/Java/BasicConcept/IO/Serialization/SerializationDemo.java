import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;

//모든 객체가 다 직렬화가 가능한 것은 아니다.
//2가지 조건 중 하나를 만족해야 된다
//1.primitive타입(8가지)은 무조건 가능
//2.Serializable 자식만 가능 (Serializable 인터페이스를 구현하면 가능)

public class SerializationDemo {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		//직렬화 - Date클래스 객체를 직렬화하여 File에 저장하기(문자열을 저장한 것이 아님)
//		Date now = new Date(); //Date API보면 Serializable인터페이스 구현했기 때문에 직렬화 가능하다
//		FileOutputStream fos = new FileOutputStream("C:temp/date.ser"); //보통 직렬화가 되는 것들은 .ser확장자로 많이 쓴다.
//		ObjectOutputStream oos = new ObjectOutputStream(fos); //API보면 OutputStream의 자식 다 쓸 수 있으니까 FileOutputStream을 쓸 수 있는 것임.
//		oos.writeObject(now); //직렬화할 객체(now)
//		System.out.println("Save Success.");
		
		//역직렬화 - 위에서 직렬화한 것을 읽어오는 것.
		ObjectInputStream ois = 
				new ObjectInputStream(new FileInputStream("C:/temp/date.ser"));
		Object obj = ois.readObject(); //위에서 나갈때는 Date였는데 들어올 때는 Date인지 모르니까 readObject로 읽는 것임, 그리고 객체형변환 안되거나 객체를 못 찾겠다고 하는 Classnotfoudnexception 발생시킴
		if(obj instanceof Date) { //우리는 사실 Date형인 것 알고도 돌리는 것임. 그런데 원래 받을 때 그것의 원래 타입이 Date인지 모르므로.
			Date before = (Date)obj; 
			System.out.println(before); // ==>지금 객체가 아니라 위에서 new Date()할 때의 시간이 뜬다. 마치 동면해서 들고온 것처럼 보임.
		}
		ois.close();

		
	}
}



