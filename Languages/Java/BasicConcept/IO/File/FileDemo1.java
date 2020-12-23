import java.io.File;
import java.text.SimpleDateFormat; //printf�� ������ ������ �� ���⼭ ó��.
import java.util.Date;

//Ž���� �����(cmdâ���� dir ��ɾ� �Է½� ��µǴ� ���¸� ��ȯ�ϱ� ����)
public class FileDemo1 {
	public static void main(String[] args) {
//		String path = "src/FileDemo.java";
//		File file = new File(path);
//		long last = file.lastModified(); //���������� file�� ������ �ð�. long���·� ���´�.(epochŸ��) �ڹٴ� ���� �ð��� �� long���̴�. (unix���� �ð�) 1970�� 1�� 1�� 0�� 0�� 0�� ��������. miliseconds������. 
//		System.out.println(new Date(last)); // Ȳ���� long Ÿ�� �ð��� �� �����ڿ� ������ �츮�� ���ϴ� �ð� ���´�.
		
//		String pattern = "������ yyyy�� MM�� dd�� aa hh�� mm�� ss���Դϴ�."; //���ϴ� ���� ������ �ȴ�.
//		SimpleDateFormat sdf = new SimpleDateFormat();
//		System.out.println(sdf.format(new Date()));
		
		//C����̺��� ��� ������(cmdâ���� dir ���� �� ������ ����, ��ϰ� ����)
		String path = "C:/"; //c����̺꿡 �ִ� �͵�(����, ���丮)�� cmd�� dir���� �� ������ ��������.
		File fileObj = new File(path); 
		File [] array = fileObj.listFiles(); //string���� list�� ������ �߰��� <DIR>�� �������� ���丮���� �Լ��� Ȯ�ε��� ���ϴ� File �迭�� ����
		for(File f : array) {
			long last = f.lastModified(); //������ �����ð�.
			String pattern = "yyyy-MM-dd\taa hh:mm"; //2020-03-06  ���� 03:56 ����
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			System.out.print(sdf.format(new Date(last)));
			if(f.isDirectory()) System.out.print("<DIR>\t\t");  //���丮�� DIR�� ���, 
			else if(f.isFile())	System.out.printf("%,d\t", f.length()); //���丮 �ƴϰ� �����̸� ������ ����� ��´�.
			System.out.println(f.getName());
		}
	} 
} 

