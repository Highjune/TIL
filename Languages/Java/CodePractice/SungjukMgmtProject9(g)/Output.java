import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Vector;

public class Output {
	private Vector<Student> vector;
	private ObjectOutputStream oos;
	
	public Output(Vector<Student> vector, String path) { //생성자임. Main에서 여지껏 계산까지 다 한 vector가 넘어오고~ 
		this.vector = vector;
		try {
			this.oos = new ObjectOutputStream(new FileOutputStream(path));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void output() {
		//this.printLabel(); //어차피 파일로 저장할 것이기 때문에 밑의 printLabel은 필요가 없다.
		try {
			this.oos.writeObject(this.vector);
			System.out.println("Save Success.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  //직렬화
	}
	private void printLabel() {
		System.out.println("            <<쌍용고등학교 성적관리프로그램>>");
		System.out.println("학번    이름    국어    영어    수학   총점   평균    평점");
		System.out.println("------------------------------------------------");
	}
}
