import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.Vector;

public class Input {
	private Vector<Student> vector;
	private RandomAccessFile raf; //읽기용으로 ~, 문젲모녀 출력은 화면출력이므로 Randomaccessfile로 출력은 X, 읽는것만.
	
	public Input(Vector<Student> vector) {   //Constructor
		this.vector = vector; //메인에서 vector 넘긴값으로 vector초기화 
		try {
			this.raf = new RandomAccessFile("sungjuk_utf8.csv", "r");  //raf초기화 // 생성자는 읽기모드이므로 r
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		}
	}
	
	public void input() { 
		String line = null;
		try { //readLine() API보면 throws IOException하니까. randomAccessFile은 한줄씩 readLine읽는다.
			while((line = this.raf.readLine()) != null) {//한줄씩 읽어서 line에 넣음//1101,     한송이,     78,     87,     83,     78
				String str = CharUtility.entoutf8(line); //randomaccess파일의 단점인 한글(일본, 중국어도 마찬가지)을 보완하기 위해 CharUtility로.
				Scanner scan = new Scanner(str).useDelimiter(",\\s+"); // ,\\s+ 의 의미는 ,뒤에 스페이스 1개 이상 있다. 정규식 표현의 일종.
				Student student = new Student(scan.next(), scan.next(), 
						scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt()); //1101, 한송이, 78, 87, 83, 78을 읽는 것임.
				this.vector.addElement(student);
			}
		} catch (IOException e) { //위에서 무한로프 돌다가 예외 발생하면 바로 stop후 catch로.
			System.out.println(e);
		}
	}
}



