import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;


public class Input {
	private Scanner scan;
	private Vector<Student> vector;
	private FileInputStream fis; 
	
	public Input(Vector<Student> vector) {   //Constructor
		this.scan = new Scanner(System.in);
		this.vector = vector;
		try {
			this.fis = new FileInputStream("C:/temp/sungjuk.txt");
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		}
	}
	
	
	public void input() {
		try {
			byte[] buffer = new byte[this.fis.available()]; //available은 특정한 양을 잘 모를  사용, text파일에서 읽어들일 수 있는 양임. 그 양만큼만 한번에 읽어들여서 딱 만든다. 대신 추천하는 방법은x. 만약 파일이 엄청 크면 문제가 된다. 
			int number = this.fis.read(buffer);//buffer라고 하는 바이트 배열에 담았음.
			String str = new String(buffer, 0, number); //위에서 만든 바이트 배열을 string으로 만들 때 생성자를 쓴다. 파라미터(바이터배열, 처음, 몇개)
			StringTokenizer st = new StringTokenizer(str, "\n"); //전체가 3줄이니까 각 1줄이 countTokens가 된다.
			String [] array = new String[st.countTokens()]; //각 3줄의 방을 만든다.
			for(int i=0; i<array.length;i++) {
				array[i] = st.nextToken();  //array[0] = 2019-01	한지민	45 67 98
				Scanner scan = new Scanner(array[i]).useDelimiter("\\s+");
				Student student = new Student(scan.next(), scan.next(), scan.nextInt(), scan.nextInt(), scan.nextInt());
				this.vector.addElement(student);
		}
		
		}catch(IOException ex) {
			System.out.println(ex);
			 
		}
	}
}
