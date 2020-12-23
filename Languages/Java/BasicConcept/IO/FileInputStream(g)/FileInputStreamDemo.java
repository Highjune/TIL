import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;





public class FileInputStreamDemo {
	public static void main(String[] args) {
		//메인은 짧을수록 좋다. 할일들을 나눠주면 좋다.
		String path = "C:/temp/addresslist.txt"; //불러올 파일, 파일입력이니까 FileInputstream써야 됨
		ArrayList<Member> list = getMember(path);
//		System.out.println(list.get(2)); //들어있는지 확인.
	}
	
	private static ArrayList<Member> getMember(String path){
	//빨대의 시작은 addresslist.txt, 빨대의 끝은 입력버펴
		ArrayList<Member> list = null;
		try(FileInputStream fis = new FileInputStream(path)) { //try안에 객체생성하는 문장 넣으면 따로 close()하지 않아도 try블럭을 벗어나는 순간 자동적으로 close()가 호출된다(자바의 정석 p437)
			byte [] buffer = new byte[512]; //하나씩 읽어들이는 것이 read, 여러개씩 읽으려고 하는 것 byte배열로. 특히 한글이 있으니까 byte배열
			//512은 여유롭게 잡아놓고 한번에 읽어들이는 것이니까 while문 안써도 된다.
			int number = fis.read(buffer);  //읽어들인 것을 buffer에 넣었고 그 양만큼 number
			String str = new String(buffer, 0, number); //byte배열을 string으로 바꾸기 위해서 string생성자. 파라미터1 - 바이트배열 / 파라미터2 - 처음부터~ / 파라미터3 - number개 // cf) String을 byte로 바꾸려면 getBytes
			StringTokenizer st = new StringTokenizer(str, "\n"); //엔터기준으로 짜름 (여기서 각각 자른 것은 무조건 다 string으로 받는다)
			String [] array = new String[st.countTokens()];
			list = new ArrayList<Member>(3);
			for(int i = 0 ; i < array.length ; i++) {
				array[i] = st.nextToken();   //array[0] = 한지민  24  aaa@aaa.com
				Scanner scan = new Scanner(array[i]).useDelimiter("\\s+"); //스페이스바 1칸이상 된 경우 다 자름.
				//useDelimiter는 정규식을 쓸 수 있기에 StringTokenizer보다 더 편하다. STringTokenizer는 정확하게 몇 칸 띄웠는지 등에 대해서 알아야 한다.
				Member member = new Member(scan.next(), scan.nextInt(), scan.next());  //next, nextint, next는 각각 글자(한지민) 정수(24) 글자(@메일~)
				list.add(member);
			}
				// System.out.println(array[2]); 이렇게 찍어보면 몇 번째 방에 뭐가 있는지 알 수 있다. 박지민 44 ccc@ccc.com
		} catch (FileNotFoundException ex) {
			System.out.println("File Not Found");
		} catch(IOException ex) {
			System.out.println(ex);
		}
		return list;
	}
}
