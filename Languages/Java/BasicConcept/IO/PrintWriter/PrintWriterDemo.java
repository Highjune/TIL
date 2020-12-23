import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

import javax.swing.JFileChooser;

//표준입력을 다른 파일로 저장하시오.
//읽어들이는 방식은 stream방식, 저장하는 방식은 writer(char방식) 으로 하는 것.
//printWriter가 byte기반, char기반 포함 제일 마지막 단계
//https://youtu.be/C-Z6fmnrQI8 
//(짤린부분) https://youtu.be/9tZKi1Xo6gQ 3분
//(짤린부분) https://youtu.be/Huva8AjAObo 13분

///결론!!! ***input은 BufferedReader 쓰자는 것. output은 PrintWriter 쓰자는 것. ***

public class PrintWriterDemo {
	public static void main(String[] args) throws IOException {
		System.out.println("저장하고 싶은 문장들을 입력하세요. 마지막에는 숫자 0을 넣으세요.");
		JFileChooser jc = new JFileChooser("C:/temp");
		jc.showSaveDialog(null); //showSaveDialog하면 저장하는 것 뜨고, showopenDialog하면 그냥 열기뜬다. 	//	()은 parent부분인데 gui의 소속을 얘기하는 건데 우리는 그냥 null
		int choice = jc.showSaveDialog(null);
		String path = null;
		if(choice == JFileChooser.APPROVE_OPTION) {  //저장버튼을 눌렀다면임. 취소는 cancel~ 
			path = jc.getSelectedFile().getAbsolutePath(); //절대경로. user가 선택한 저장위치
		}
		InputStream is = System.in; //InputStream은 추상클래스이기 때문에 new를 못써서 이런식으로밖에 객체생성을 못한다.system.in => 키보드(표준입력)
		InputStreamReader isr = new InputStreamReader(is); //우리는 한글을 읽어야 되기 때문에 InputStream만으로 안된다. 그래서 Reader가 필요함.char필요하기 때문에
		BufferedReader br = new BufferedReader(isr); //엔터단위로 읽을 것이고, 라인으로 읽어야 하기에 BufferedReader로 읽는다. //특징 2가지 : 한글가능, 라인단위로 읽기 가능
		//여기까지가 읽어들이는 것 다 한것임.
		
		
//		FileWriter fw = new FileWriter(path, true);
//		Writer writer = fw; 
		//밑의 3줄보다 더 간편한 방법임(위의 2줄이) ////사실 이런 모든 방법을 다 쓰지 않는다. 지금은 생성자로 서로 엮는 연습을 하는 것일뿐, 실제로는 ***딱 2줄이면 된다. BufferedReader와 PrintWriter 2개면 된다.****
		FileOutputStream fos = new FileOutputStream(path, true); //파일로 내보내는 것.화면이 아니라 파일임.
		OutputStream os = fos;  //"너는 밥은 먹고 다니니"는 컴퓨터 안에서 char인데 이것을 byte로 내보내기 위해 outputstream
		OutputStreamWriter osw = new OutputStreamWriter(os);
		
		PrintWriter pw = new PrintWriter(osw, true); // 한글을 쓰기 위해 PrintWriter. printf로 내보내는 곳이 화면이 아니라 file이라서 위에서 file. 매개변수 두번째것은 autoflush임 . printf()가능,  한글가능
		//printf는 printStream에도 있고 printwriter에도 있다.
		//나중에 jsp에서 PrintWriter또 나온다. printStream말고 PrintWriter이유는 웹에서 영어뿐 아니라 한글 등 다 가능해야 되기 때문에.
		while(true) {
			String str = br.readLine();
			if(str.equals("0"))break;
			pw.printf("%s\n", str);
		}
		
		System.out.println("Save Success");
		
		br.close();		//여는 것들의 반대순서로 닫으면 된다. 그런데 위에서 InputStream is ~ 부터 3줄 ~~ new BufferedReader(isr)를 한줄에 줄이면 br.close()하나면 된다. BufferedRedaer 만 닫으면 된다.
		isr.close(); 
		is.close(); 
		//여기까지가 읽어들이는 것 다 한 것임.
	
		pw.close();
		osw.close();
		os.close();
		fos.close(); //Writer도 사실 한줄로 표현하면 pw.close()하나면 됨. 나머지는 얘한테 속해있는 애들이고 한줄로 바꿀 수 있다.
	}
}