import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


 
public class InputStreamReaderDemo2 {
	public static void main(String[] args) throws IOException {
		//���Ϸκ��� �д� �� 
		String path = "C:/temp/addresslist.txt";
		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);  
		//��ó�� ������ ��� �ͼ� BufferedReader�� �����ϱ� ���ʺ��� reader�� ����. char�� �д� ����. �ѱ��� ���� �� �ְ�, Ư�� readeLine()�� �־ ����
		
		String line = null; 
		while((line = br.readLine()) != null) {  //InputStreamReaderDemo1 ������ �̷��� �ٲ� ���ѷ����� �̷������� �ٲٸ� ���ѷ����� ���� �δ��� ������.
			System.out.println(line);
			//�̷��� ���� ó���� ��������.�ѱ� ó�� ���� �� �ʿ����. bufferedreader�� ������ �� ������ ���� �� �����ϱ� �� byte�̷��͵� ���� �� �ʿ䵵 ����, Tokenizer �� �ʿ䵵 ����.
			//2��° �����
		
		}
	}
}



