/*
 * 프로그램이 처음 실행되면 C:/temp/sungjuklist.ser 파일이 없기 때문에 새 파일을 생성한다.
 * 만일 있다면 EOFException이 발생하거나 정상적으로 역직렬화를 하거나 한다.
 */

/*
 * 직렬화에서 EOFException이 자주 발생함. 발생하는 이유는 객체가 없을 때 null이나 -1을 return 하지 않고 EOFException을 발생시킨다.
 * 처리방법 : 1번과 2번을 하거나(직렬화를 먼저 해놨거나) /// 3번을 하거나 
 * 1) writeObject() 를 먼저하거나 2)writeObject()의 제일 마지막에 null을 하거나 
 *             3)EOFException을 발생시키면 된다. 
 *             (아래에서는 3번처리)
 */


import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Vector;

public class Init {
	private ObjectInputStream ois; //처음에 페이지가 로딩되면 어느 곳에 있는 ~~.ser파일을 읽어와야 되니까(안에 있는 vector)
	
	public Init(String path) {
		File file = new File(path); 
		try {
			if(file.exists()) {  //해당 파일이 있다면 true(한번이라도 이전에 프로그램을 실행했다면 있는 것임. 이전에 저장되었을 것이 있을 것이므로)
				this.ois = new ObjectInputStream(new FileInputStream(file)); //있으면 가져오는 것임.
			}else {  //파일이 없다면 --> 처음 프로그램을 실행했다면 파일 새로 만듬.
				file.createNewFile();
			} //EEOFException이 자식이므로 부모보다 위에서 잡자!(아래 catch문)
		}catch(EOFException ex) {  //파일은 있지만 비어있다면 발생. (위에서 ObjectInputStream에서 End OF File Exception 발생)// 매개변수인 FileInputstrem는 File이 있는지 없는지만 판단하는 것이기 때문에 따로 X
			this.ois = null; //이것이 null이면 밑의 init()에서 null에 걸림.
		}catch(IOException ex) {
			System.out.println(ex); //user에게는 이 메시지 보여주면 됨 (배포할 때는 이것만~)
			ex.printStackTrace(); //이렇게 찍어주면 편함(개발자 입장에서는 오류 메시지를 찍어내는 것이 편함)
		}
	}
	
	public Vector<Student> init(){ //작업할 파일을 열어서 그 안에 있는 Vector를 역직렬화해서 vector로 리턴해주는 것.
		Object obj = null;
		try {
			if(this.ois != null)	obj = this.ois.readObject();  //os가 null이 아니면 readObject로 역직렬화
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(ois != null && obj != null) { //ObjectInpuStream할 파일이 있고 그 안의 내용도 있다면(즉, 둘 다 null이 아니면)
			return (Vector<Student>)obj; //위에서 readObject로 읽었으니 Object니까 강제형변환해서 넘기고~
		} else {
			return new Vector<Student>(1,1); //없으며 새로 만들어서 넘김~
		}
	}
}






