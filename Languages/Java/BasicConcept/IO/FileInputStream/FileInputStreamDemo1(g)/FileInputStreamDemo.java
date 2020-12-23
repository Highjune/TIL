import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

//addresslist.txt들고온 후 다시 공부하기

public class FileInputStreamDemo {
	public static void main(String[] args) {
		String path = "C:/temp/addresslist.txt";
		ArrayList<Member> list = getMember(path);
		System.out.println(list.get(2));
	}
	
	private static ArrayList<Member> getMember(String path){
		ArrayList<Member> list = null;
		try(FileInputStream fis = new FileInputStream(path)) {
			byte [] buffer = new byte[512];
			int number = fis.read(buffer);
			String str = new String(buffer, 0, number);
			StringTokenizer st = new StringTokenizer(str, "\n");
			String [] array = new String[st.countTokens()];
			list = new ArrayList<Member>(3);
			for(int i = 0 ; i < array.length ; i++) {
				array[i] = st.nextToken();   //array[0] = 한지민  24  aaa@aaa.com
				Scanner scan = new Scanner(array[i]).useDelimiter("\\s+"); //어떤 기준으로 자를지 결정
				Member member = new Member(scan.next(), scan.nextInt(), scan.next());  //next, nextint, next는 각각 글자(한지민) 정수(24) 글자(@메일~)
				list.add(member);
			}
				// System.out.println(array[2]); 이렇게 찍어보면 몇 번째 방에 뭐가 있는지 알 수 있다.
		} catch (FileNotFoundException ex) {
			System.out.println("File Not Found");
		} catch(IOException ex) {
			System.out.println(ex);
		}
		return list;
	}
}
