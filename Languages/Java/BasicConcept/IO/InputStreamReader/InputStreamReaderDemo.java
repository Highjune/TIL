import java.io.*;

//inputStream --> Reader�� ��ȯ 
//�ڹ��� ���� p905
//
//���� �� ����(���ڱ�� ��Ʈ��, �ڹ��� ����p898) 
//https://www.youtube.com/watch?v=LVSnjQeXzUM&feature=youtu.be
 
public class InputStreamReaderDemo {
	public static void main(String[] args) throws IOException {
//��� �츮�� �̰͵��� �� �� �� ���̴�. Scanner��� ���� ����� �ֱ� ������.
//Scanner�� ���� ���� IOBasic�� InputStreamReader�� �־���.
//���� �ѱ��� �ȵƾ��µ�, �ѱ��� �ǰԲ� �츮�� Reader�� ��ȯ�߱� ������. ���� �ѱ��� �Ϸ��� byte�迭(IOBasic����) �� �̿��� ��ó��
	
		InputStream is = System.in; 
//������ �̷��� Ű���� �� ǥ������ ������ ���� ������ byte����̹Ƿ� �ѱ��� �������� ����Ʈ ����� ������ char�� �ٲ�� �ȴ�. �װ��� �ٷ� InputStreamReader. �׷��� �� performance�� ���� �ϱ� ���ؼ� BufferedReader�� ������ �װ��� ���ٷ� ���� �� �ִٴ� ��.
		InputStreamReader isr = new InputStreamReader(is);  //bridge class. byte�� ������ ���� char�� �ٲٰ� ���ش�.
		Reader reader = isr;
		BufferedReader br = new BufferedReader(reader);
		System.out.println("Name : ");
		String name = br.readLine();  //Buffered���� ��û ������ �޼�����. Scanner�� NextLine()��. �̰��� ������ ��Ե� ������ Buffered�� �Ϸ��� ��. �̰��� �̿��ϸ� �ѱ۵� �̿��� �� �ְ� ���پ� ������ parsing�� �ʿ䵵 ����.
		System.out.println("name = " + name);
		
		//�� ������ �ѹ��� �ϴ� ���� Scanner. 

		
		
	}
}



