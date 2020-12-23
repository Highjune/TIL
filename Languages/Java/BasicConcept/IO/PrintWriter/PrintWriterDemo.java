import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

import javax.swing.JFileChooser;

//ǥ���Է��� �ٸ� ���Ϸ� �����Ͻÿ�.
//�о���̴� ����� stream���, �����ϴ� ����� writer(char���) ���� �ϴ� ��.
//printWriter�� byte���, char��� ���� ���� ������ �ܰ�
//https://youtu.be/C-Z6fmnrQI8 
//(©���κ�) https://youtu.be/9tZKi1Xo6gQ 3��
//(©���κ�) https://youtu.be/Huva8AjAObo 13��

///���!!! ***input�� BufferedReader ���ڴ� ��. output�� PrintWriter ���ڴ� ��. ***

public class PrintWriterDemo {
	public static void main(String[] args) throws IOException {
		System.out.println("�����ϰ� ���� ������� �Է��ϼ���. ���������� ���� 0�� ��������.");
		JFileChooser jc = new JFileChooser("C:/temp");
		jc.showSaveDialog(null); //showSaveDialog�ϸ� �����ϴ� �� �߰�, showopenDialog�ϸ� �׳� ������. 	//	()�� parent�κ��ε� gui�� �Ҽ��� ����ϴ� �ǵ� �츮�� �׳� null
		int choice = jc.showSaveDialog(null);
		String path = null;
		if(choice == JFileChooser.APPROVE_OPTION) {  //�����ư�� �����ٸ���. ��Ҵ� cancel~ 
			path = jc.getSelectedFile().getAbsolutePath(); //������. user�� ������ ������ġ
		}
		InputStream is = System.in; //InputStream�� �߻�Ŭ�����̱� ������ new�� ���Ἥ �̷������ιۿ� ��ü������ ���Ѵ�.system.in => Ű����(ǥ���Է�)
		InputStreamReader isr = new InputStreamReader(is); //�츮�� �ѱ��� �о�� �Ǳ� ������ InputStream������ �ȵȴ�. �׷��� Reader�� �ʿ���.char�ʿ��ϱ� ������
		BufferedReader br = new BufferedReader(isr); //���ʹ����� ���� ���̰�, �������� �о�� �ϱ⿡ BufferedReader�� �д´�. //Ư¡ 2���� : �ѱ۰���, ���δ����� �б� ����
		//��������� �о���̴� �� �� �Ѱ���.
		
		
//		FileWriter fw = new FileWriter(path, true);
//		Writer writer = fw; 
		//���� 3�ٺ��� �� ������ �����(���� 2����) ////��� �̷� ��� ����� �� ���� �ʴ´�. ������ �����ڷ� ���� ���� ������ �ϴ� ���ϻ�, �����δ� ***�� 2���̸� �ȴ�. BufferedReader�� PrintWriter 2���� �ȴ�.****
		FileOutputStream fos = new FileOutputStream(path, true); //���Ϸ� �������� ��.ȭ���� �ƴ϶� ������.
		OutputStream os = fos;  //"�ʴ� ���� �԰� �ٴϴ�"�� ��ǻ�� �ȿ��� char�ε� �̰��� byte�� �������� ���� outputstream
		OutputStreamWriter osw = new OutputStreamWriter(os);
		
		PrintWriter pw = new PrintWriter(osw, true); // �ѱ��� ���� ���� PrintWriter. printf�� �������� ���� ȭ���� �ƴ϶� file�̶� ������ file. �Ű����� �ι�°���� autoflush�� . printf()����,  �ѱ۰���
		//printf�� printStream���� �ְ� printwriter���� �ִ�.
		//���߿� jsp���� PrintWriter�� ���´�. printStream���� PrintWriter������ ������ ����� �ƴ϶� �ѱ� �� �� �����ؾ� �Ǳ� ������.
		while(true) {
			String str = br.readLine();
			if(str.equals("0"))break;
			pw.printf("%s\n", str);
		}
		
		System.out.println("Save Success");
		
		br.close();		//���� �͵��� �ݴ������ ������ �ȴ�. �׷��� ������ InputStream is ~ ���� 3�� ~~ new BufferedReader(isr)�� ���ٿ� ���̸� br.close()�ϳ��� �ȴ�. BufferedRedaer �� ������ �ȴ�.
		isr.close(); 
		is.close(); 
		//��������� �о���̴� �� �� �� ����.
	
		pw.close();
		osw.close();
		os.close();
		fos.close(); //Writer�� ��� ���ٷ� ǥ���ϸ� pw.close()�ϳ��� ��. �������� ������ �����ִ� �ֵ��̰� ���ٷ� �ٲ� �� �ִ�.
	}
}