import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


 
public class InputStreamReaderDemo1 {
	public static void main(String[] args) throws IOException {
		//���Ϸκ��� �д� �� 
		String path = "C:/temp/addresslist.txt";
		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);  
		//��ó�� ������ ��� �ͼ� BufferedReader�� �����ϱ� ���ʺ��� reader�� ����. char�� �д� ����. �ѱ��� ���� �� �ְ�, Ư�� readeLine()�� �־ ����
		
		while(true) {
			String line = br.readLine(); //���پ� �о line�� ����
			if(line ==null || line.length()==0)break;
			System.out.println(line);
			//�̷��� ���� ó���� ��������.�ѱ� ó�� ���� �� �ʿ����. bufferedreader�� ������ �� ������ ���� �� �����ϱ� �� byte�̷��͵� ���� �� �ʿ䵵 ����, Tokenizer �� �ʿ䵵 ����.
			//1��° ����� 
		
		}
	}
}



