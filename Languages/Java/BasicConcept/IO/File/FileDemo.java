import java.io.File;
import java.io.IOException;
import java.util.Scanner;

//�ڹ��� ���� p915
public class FileDemo {
	public static void main(String[] args) throws IOException{
		//���(path)���� ����ϴ� ������(separator), windows������ \, �������� ���� /
//		System.out.println(File.separator);  //  \�� ����
		//%PATH% or %CLASSPATH%���� ����ϴ� ������(pathSepator)
//		System.out.println(File.pathSeparator); //  ;�� ����
		System.out.print("�а� ���� ������ ��� : ");
		Scanner scan = new Scanner(System.in);
		String path = scan.nextLine();  //������� ������ �������� ������ nextLine����
		File file = new File(path);
		if(file.exists())	{//user�� �Է��� ���(path)�� ������ ������ true. ������ false
			System.out.println("getPath() = " + file.getPath());
			System.out.println("getName() = " + file.getName());
			System.out.println("getAbsolutePath() = " + file.getAbsolutePath()); // exception�� ������ ��¥ �����δ� �ƴϴ�.
			System.out.println("getCanonicalPath() = " + file.getCanonicalPath()); //��¥ ������(exception�� ����)
		}else {
			System.out.println("Not Found");
		}
	}	
}

//�������� �� FileDemo.java�� �Է��ϸ� �ȵȴ�. �ֳ��ϸ� ���� �ִ� ������ġ(ex. 0131) �� ���� ������. �׷��� src/FileDemo.java�� ���� �ȴ�
//absolutepath�� canonicalpath�� �ٸ��� ������ �Ϸ���
//���� �� ��� : src/../../0131/src/FileDemo.java��� �ϸ� �ȴ�. Canonicalpath�� ���� �Դٰ��� �� ���� ���� �ʰ� �� �״�� �����θ� ��´�.