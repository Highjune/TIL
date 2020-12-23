import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser; //���ϼ�����

//���Ϸ� �������� ��
//https://youtu.be/mEiDmBH5vko
//https://youtu.be/FHLTe24UJrc 
//java.io.FileOutputStream api����
//���Ϸ� �������� ���� : ������ ������ ����� ������ �����. ����� �ʰ� �߰��� �Ϸ��� boolean append �Ķ���͸� ���� �ִ� �����ڿ��� true �־��ָ� �ȴ�.
//cf) ������ �о���� ���� ������ ������ �а�, ������ ����

public class FileOutputStreamDemo {
	public static void main(String[] args) {
		//dialog�� path
		
		String path = null;
		JFileChooser chooser = new JFileChooser();
		int choice = chooser.showSaveDialog(null); //parent�����ϱ� null
		if(choice == JFileChooser.APPROVE_OPTION) { // dialogâ���� ���� ��ư�� �����ٸ� 
			path = chooser.getSelectedFile().getAbsolutePath(); //������ ������ path�� �̾ƿ��� ��
		}
		System.out.println(path);
//		String path = "C:/temp/message.dat";
		System.out.print("�����ϰ� ���� �޽����� �Է��ϼ���. �Է��� ������ �׳� ����Ű�� ��������.");
		Scanner scan = new Scanner(System.in);
		try (FileOutputStream fos = new FileOutputStream(path, true)) {  //API���� autocloseable����, �Ķ���� true�� ���� ������ �־ ����� �ʰ� �߰��ϴ� ����.
			while(true) {
				String msg = scan.nextLine(); //���پ� �Է¹���(ǥ���Է��� Ű����κ��� �о���� �͵�)
				if(msg == null || msg.length() == 0 )break; //�׳� ���͸� ġ�� (�Է¹��� ������� ���ٸ�)
				byte[] buffer = msg.getBytes("UTF-8"); //�ش� charset���� ����. getBytes(charset) // ����Ʈ�迭�� ���� �ѱ۵� ����
				fos.write(buffer);  
				fos.write(10); //������ �ƽ�Ű�ڵ� : 10, �������� �� �ٲ�� �ϴϱ�.
				fos.flush(); //���ۿ� �ִ� ���� ����. flush�� ���ϸ� ���� �ȿ� ���ִ� ����. 
		}	
			
		  } catch(FileNotFoundException ex) {
			System.out.println("File Not Found");
		} catch (IOException e) {
			System.out.println();
		}		
	}
}
