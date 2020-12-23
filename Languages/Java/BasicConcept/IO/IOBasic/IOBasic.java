import java.io.IOException;
import java.io.InputStream;

public class IOBasic {
	public static void main(String[] args) {
		//ǥ����� : ���buffer -> Moniter, Console, Terminal, System.out(�ڹٿ���)
		//ǥ���Է� : keyboard -> �Է� Buffer, System.in(�ڹٿ���)
		//���ۿ��� moniter�� ��������, Ű���忡�� ���۷� ������ ���� OS�� �Ѵ�.
		//System.out, in �� �ý��� �������̴�. ��? �ڹٰ� �ϴ� ���� �ƴ϶� OS(IOS, ������, ������ �� ����)
		
		//�Ʒ��� �ڹ��� ���� �������� �Է� ����̾���. ����� Scanner(1.5���� ����) ��� ���� ���õ� ������� ����� ��.	
		
		InputStream is = System.in;  //InputStream�� �� ����� ������, System.in�� inputStream���� ��ȯ�ϴϱ� System.in�� ����
		//������ is�κ��� 1byte�� ����. �ѱ��� �⺻ 2����Ʈ�̹Ƿ� �ѱ��� �ȵȴ�.
		System.out.print("�����Ͻô� ������ : ");  
		String season = "";
		int number = 0;
		
		try {
			while(true) {
				number = is.read();
				if(number <0 || (char)number == '\n')break;
				season += (char)number;
			}
			System.out.println("season = " + season);
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	
		
	}
}
