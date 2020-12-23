import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Init {    //정수형 : 0, 실수형 : 0.0, boolean : false, char : 널값, null ==> 그래서 ois는 null. 데이터를 읽었을 때만 null이 아님 
	//3가지 케이스
	//1. 파일이 있었는데 데이터가 있는 경우(null아님)
	//2. 파일이 없었음 => 만들면서 null  
	//3. 파일이 있는데 data가 없음 => null (this.ois = null) 
	
	private ObjectInputStream ois;
	
	public Init(String path) { //생성자(여기서 하는 일이 많음)
		File file = new File(path); //File클래스 만드는 이유는 이 경로에 파일존재유무에 대해서 알고 싶어서. 그래서 아래에서 존재한다면~ 존재안한다면~ 으로 나눠서 한 거임.
		try {
			if(file.exists()) {  //파일이 있다면 역직렬화 수행, 이미 한번 이상 사용했다면
				this.ois = new ObjectInputStream(new FileInputStream(file)); // ObjectInputStream이 EOFException 발생하는 거임.
			}else {  //파일이 없다면, 프로그램을 처음 사용하니까 // 없으면 파일 만들고 null입력.
				file.createNewFile(); // .ser만듬.
				this.ois = null; //
			}
		}catch(EOFException ex) {   //역직렬화할 때, 데이터가 없다면 null / -1이 아니라, EOF 발생 /// EOF처리 방법 3가지. 1. write를 먼저하기. 2. write를 할 떄 null주기. 3. null주기(여기서는 init()을 제일  먼저 하므로 여기처럼 null주기)
			this.ois = null;
		}catch(IOException ex) {
			System.out.println(ex);
		}
		
	}
	public ArrayList<Person> init() {
		ArrayList<Person> list = null;
		try {
			if(this.ois != null) { //null이 아니라는 것은 ois가 제대로 있다는 것.(파일도 있었고 데이터도 있었던 경우) 안에 데이터가 있으니깐 readObject로 읽어들임.
				list = (ArrayList<Person>)this.ois.readObject(); //위의 생성자에서 만든 빨대에서 readOBject를 통해 데이터 읽어옴. 그런데 읽어오는 것이 object이므로 강제형변환(즉 부모인 object를 자식으로 강제형변환)
			}
		}catch(ClassNotFoundException | IOException ex) { // | 는 or의미 , 2개의 catch를 쓰지 않기 위해.
			System.out.println(ex);
		}
		if(list == null) list = new ArrayList<Person>(1);   
		return list; //여기서 list는  null이 아닌 data를 리턴하든지, null이라면 1을 만들어줘서 넘기기. list는 null이 될수가 없다. insert에서 this.list.add(Person)에서 list가 null이면 안되므로
	}
}
