import java.io.IOException;
import java.io.InputStream;

public class IOBasic1 {
	public static void main(String[] args) {
		//ǥ����� : ���buffer -> Moniter, Console, Terminal, System.out(�ڹٿ���)
		//ǥ���Է� : keyboard -> �Է� Buffer, System.in(�ڹٿ���)
		//���ۿ��� moniter�� ��������, Ű���忡�� ���۷� ������ ���� OS�� �Ѵ�.
		//System.out, in �� �ý��� �������̴�. ��? �ڹٰ� �ϴ� ���� �ƴ϶� OS(IOS, ������, ������ �� ����)�� �ϴ� ����.
		
		InputStream is = System.in;  
		System.out.println("�����Ͻô� ������? :");
		String season  = "";
		int number = 0;
		byte [] buffer = new byte[20];
		try {
			number = is.read(buffer); //���� �� �ʿ�X, �Է��� ���� �� buffer�� ���ϱ�. read�ȿ� byte�迭�� ��߸� �ѱ� �� �� �ִ�.
			season = new String(buffer, 0, number);
			System.out.println("season = " + season);
		} catch(IOException e) {
			System.out.println(e);
		}
		

		
		
		
		
		
		
		
		
		
		
	
		
	}
}

