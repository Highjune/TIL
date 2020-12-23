import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;





public class FileInputStreamDemo {
	public static void main(String[] args) {
		//������ ª������ ����. ���ϵ��� �����ָ� ����.
		String path = "C:/temp/addresslist.txt"; //�ҷ��� ����, �����Է��̴ϱ� FileInputstream��� ��
		ArrayList<Member> list = getMember(path);
//		System.out.println(list.get(2)); //����ִ��� Ȯ��.
	}
	
	private static ArrayList<Member> getMember(String path){
	//������ ������ addresslist.txt, ������ ���� �Է¹���
		ArrayList<Member> list = null;
		try(FileInputStream fis = new FileInputStream(path)) { //try�ȿ� ��ü�����ϴ� ���� ������ ���� close()���� �ʾƵ� try���� ����� ���� �ڵ������� close()�� ȣ��ȴ�(�ڹ��� ���� p437)
			byte [] buffer = new byte[512]; //�ϳ��� �о���̴� ���� read, �������� �������� �ϴ� �� byte�迭��. Ư�� �ѱ��� �����ϱ� byte�迭
			//512�� �����Ӱ� ��Ƴ��� �ѹ��� �о���̴� ���̴ϱ� while�� �Ƚᵵ �ȴ�.
			int number = fis.read(buffer);  //�о���� ���� buffer�� �־��� �� �縸ŭ number
			String str = new String(buffer, 0, number); //byte�迭�� string���� �ٲٱ� ���ؼ� string������. �Ķ����1 - ����Ʈ�迭 / �Ķ����2 - ó������~ / �Ķ����3 - number�� // cf) String�� byte�� �ٲٷ��� getBytes
			StringTokenizer st = new StringTokenizer(str, "\n"); //���ͱ������� ¥�� (���⼭ ���� �ڸ� ���� ������ �� string���� �޴´�)
			String [] array = new String[st.countTokens()];
			list = new ArrayList<Member>(3);
			for(int i = 0 ; i < array.length ; i++) {
				array[i] = st.nextToken();   //array[0] = ������  24  aaa@aaa.com
				Scanner scan = new Scanner(array[i]).useDelimiter("\\s+"); //�����̽��� 1ĭ�̻� �� ��� �� �ڸ�.
				//useDelimiter�� ���Խ��� �� �� �ֱ⿡ StringTokenizer���� �� ���ϴ�. STringTokenizer�� ��Ȯ�ϰ� �� ĭ ������� � ���ؼ� �˾ƾ� �Ѵ�.
				Member member = new Member(scan.next(), scan.nextInt(), scan.next());  //next, nextint, next�� ���� ����(������) ����(24) ����(@����~)
				list.add(member);
			}
				// System.out.println(array[2]); �̷��� ���� �� ��° �濡 ���� �ִ��� �� �� �ִ�. ������ 44 ccc@ccc.com
		} catch (FileNotFoundException ex) {
			System.out.println("File Not Found");
		} catch(IOException ex) {
			System.out.println(ex);
		}
		return list;
	}
}
