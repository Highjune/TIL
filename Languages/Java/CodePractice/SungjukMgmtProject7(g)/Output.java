import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;

public class Output {
	private Vector<Student> vector;
	private FileOutputStream fos; // file로 내보낼 거니까 FileOutPutStream. 
	
	public Output(Vector<Student> vector) { //생성자
		this.vector = vector;
		try { 		//생성자로서 위의 멤버변수(fos) 초기화
			this.fos = new FileOutputStream("C:/temp/result.txt", true); //모든 것을 한번에 내보내는 것이 아니라 학생마다 줄바꿔서 내보내야 되니까 append해야 되니까 true
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		} 
	}
	
	
//	한글을 바이트 배열로 바꾸고 그것을 내보내고 버퍼에 껴있을 수 있으니까 flush 해줘야 되고 매라인마다 줄바꿈 해줘야 된다.
//	프린터 라벨이 끝난 다음에 vector에서 한 학생씩 뽑아서 출력
	public void output() {
		try {
			this.printLabel();
			for(Student s : this.vector) {
				this.fos.write(s.toString().getBytes("UTF-8")); //toString()이 문자열이므로. 
				this.fos.write(10); //한 학생마다 찍고 줄 바꿔야 되니까 줄바꿈.
			}
			this.fos.flush();//학생들을 한꺼번에 flush. 사실 위에 for문에 넣어서 한명씩 flush해도 된다.
			System.out.println("File Save Success."); //이것이 찍힌다는 것은 exception이 발생하지 않았다는 말.  
		}catch(IOException ex) { //try 과정에서 exception발생하면 무조건 catch로 넘어온다.
			System.out.println(ex);
		}finally {
			try {
				this.fos.close(); //소멸자
			}catch(IOException ex) {}
		}
	}
	
	//학생결과데이터를 저장할 파일의 경로는 C:/temp/result.txt
	private void printLabel() throws IOException {
		this.fos.write("                <<쌍용고등학교 성적관리프로그램>>".getBytes("UTF-8")); //String("")을 getBytes로 바꾸는데 utf-8로 바꾼다. 그리고 이렇게 바꾼 바이트 배열을 버퍼에 write한다.
		this.fos.write(10); //줄바꿈
		this.fos.write("학번    이름    국어    영어    수학   총점   평균    평점".getBytes("UTF-8")); 
		this.fos.write(10);
		this.fos.write("------------------------------------------------".getBytes("UTF-8"));
		this.fos.write(10);
		this.fos.flush(); //위의 것들을 다 버퍼에 담았는데, 이것을 flush
	}
}


