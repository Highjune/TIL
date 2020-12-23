import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser; //파일선택자

//파일로 내보내는 것
//https://youtu.be/mEiDmBH5vko
//https://youtu.be/FHLTe24UJrc 
//java.io.FileOutputStream api참고
//파일로 내보내는 것은 : 파일이 없으면 만들고 있으면 덮어쓴다. 덮어쓰지 않고 추가를 하려면 boolean append 파라미터를 갖고 있는 생성자에서 true 넣어주면 된다.
//cf) 파일을 읽어들일 때는 파일이 있으면 읽고, 없으면 에러

public class FileOutputStreamDemo {
	public static void main(String[] args) {
		//dialog로 path
		
		String path = null;
		JFileChooser chooser = new JFileChooser();
		int choice = chooser.showSaveDialog(null); //parent없으니까 null
		if(choice == JFileChooser.APPROVE_OPTION) { // dialog창에서 저장 버튼을 눌렀다면 
			path = chooser.getSelectedFile().getAbsolutePath(); //선택한 파일의 path를 뽑아오는 것
		}
		System.out.println(path);
//		String path = "C:/temp/message.dat";
		System.out.print("저장하고 싶은 메시지를 입력하세요. 입력이 끝나면 그냥 엔터키를 누르세요.");
		Scanner scan = new Scanner(System.in);
		try (FileOutputStream fos = new FileOutputStream(path, true)) {  //API보니 autocloseable가능, 파라미터 true는 같은 파일이 있어도 덮어쓰지 않고 추가하는 것임.
			while(true) {
				String msg = scan.nextLine(); //한줄씩 입력받은(표준입력인 키보드로부터 읽어받은 것들)
				if(msg == null || msg.length() == 0 )break; //그냥 엔터를 치면 (입력받은 내용들이 없다면)
				byte[] buffer = msg.getBytes("UTF-8"); //해당 charset으로 들고옴. getBytes(charset) // 바이트배열을 쓰면 한글도 가능
				fos.write(buffer);  
				fos.write(10); //엔터의 아스키코드 : 10, 내보내고 줄 바꿔야 하니깐.
				fos.flush(); //버퍼에 있는 것을 방출. flush를 안하면 빨대 안에 껴있는 것임. 
		}	
			
		  } catch(FileNotFoundException ex) {
			System.out.println("File Not Found");
		} catch (IOException e) {
			System.out.println();
		}		
	}
}
