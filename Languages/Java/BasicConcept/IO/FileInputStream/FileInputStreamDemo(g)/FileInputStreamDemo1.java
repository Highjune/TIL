import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

//MemberŬ������ �Բ�

public class FileInputStreamDemo1 {
	public static void main(String[] args) throws IOException{ //�ʵ忡�� �� ���� �̷��� throws�� ������ ���� �ؿ��� ������ �ϳ��� �� ������ �ȴ�.
		ArrayList<Member> list = new ArrayList<Member>(3); //���� �þ�� �ϴµ�, ó������ 3�� �ذ���
		System.out.print("Data�� �ִ� ���� ��� : ");
		String path = new java.util.Scanner(System.in).nextLine(); //.���� �ϸ� �ּҰ� ������� ���̰�, �� �ּҿ� ���� nextLine(). 
		//��ó�� �ϸ� ��ĳ�ʿ� ���� �ּ� ���� �� ���� �ȴ�. ���� ���� import�� ���� ���ص� �ȴ�. ������ new Scanner(System.in)��. 
		FileInputStream fis = new FileInputStream(path);
		byte [] buffer = new byte[512]; 
		int number = 0;
		String data = null;
		while((number = fis.read(buffer)) > 0) { //read�� ���� ���� buffer�� �ְ� �� ���� ���� ������ number�� �־���. 0���� ���ٴ� ���� �ϳ��� �� �ű� �����Ͱ� �ִٴ� ��
			data = new String(buffer, 0, number); //String�����ڷ� byte->String����
		}

		StringTokenizer st = new StringTokenizer(data, "\n"); //�׳� API��. StringTokenizer
		System.out.println(st.countTokens());
		fis.close(); //������ ������ �ݾƾ� �Ѵ�.
	}
}




