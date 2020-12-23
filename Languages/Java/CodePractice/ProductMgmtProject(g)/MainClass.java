import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;


//�� ���α׷��� ���۵� �� ����ȭ�Ǿ��ִ� ���Ϸκ��� ����ȭ�Ǿ��ִ� ��ǰ���� �������� ��.
//

public class MainClass {
	
	//�̷��� �ٱ������� �������(�������� ����)�� ���� input calc sort output���� �Ķ���͸� �ѱ� �ʿ䰡 ����.
	//��������� lifescycle�� ���� ����ؾߵǴ� ����.
	//���������� �ڵ������� �����ǰ� ������� ������ lifecycle�� ����� �ʿ䰡 ����.
	private ArrayList<Product> list; //Q) �̷��� ���� �Ķ���͸� �� �ʿ䰡 ����. ��������� ���� �Ǵϱ�=> �� ���� ������?, �̰Ŷ����� input calc sort output => �Ķ���͸� �ѱ� �ʿ䰡 ����? 
	
	public MainClass() { // ������ �ʱ�ȭ
		this.list = new ArrayList<Product>(); // productdata.txt���� 7���� �ִ� �� ������ �����Ӱ� 10���� ���. �⺻�� : 10����
	}
	
	public static void main(String[] args) {
		MainClass mc = new MainClass(); //������ ȣ�� : arraylist�������. product�� ������� ���� �ƴ϶� product�� �� ��ø�� ������� ����
		mc.input();    mc.calc();   mc.sort();  mc.output();
	}
	// ==> �� ���α׷��� ���� ���������� ������� ����Ǵ� ����.
	
	
	//�Ʒ��� �� �Լ����� return���� �� ��� void 
	private void input(){   //������ ���� : productdata.txt // ������ �� : �޸��� �Է¹���
		try(FileInputStream fis = new FileInputStream("productdata.txt")) {  // ���Ϸκ��� �о���̴� ���� FileInputstream�� autocloseable �ڽ��̹Ƿ� finally�� close�� ���� �ʿ����.
			byte [] buffer = new byte[fis.available()]; //available�� �ѹ��� �� �о����. (���� ����) - ��� ���� �� ���� ���. ������ ����� �𸣱� ������
			int number = fis.read(buffer); //�о���� �����͸� ���ۿ� ����. 
			String str = new String(buffer, 0, number); // byte -> string���� ��ȯ : String �����ڷ�.(buffer�� ����ִ� ���� 0���� number����ŭ String���� ��ȯ
			StringTokenizer st = new StringTokenizer(str, "\n"); //productdata.txt�� \n�������� ¥��. (�ٹٲ�)
			String [] array = new String[st.countTokens()]; //7���� ������ŭ �迭 ���� 7���� ��
			for(int i = 0 ; i < array.length ; i++) {
				array[i] = st.nextToken();  //NOTEBOOK	36000	5000	4700	2000 (ù��° token) => �׷��� ���⿡ �����̽��ٰ� ������ �ؿ��� �װ��� �������� ¥��
				Scanner scan = new Scanner(array[i]).useDelimiter("\\s+"); // \\s+ �����̽� 1�� �̻�
				Product product = new Product(scan.next(), scan.nextInt(), scan.nextInt(), 
						                                      scan.nextInt(), scan.nextInt());
				this.list.add(product);
			}
		}catch(IOException ex) {
			System.out.println(ex);
		}
	}
	
	private void calc(){
		for(Product product : this.list) { //list���� product���� �� ����
			//bolpen�� �о ���� �Ի� �� ~ , books, pencil � ��������
			
			//�Ǹűݾ� = ���� * �ǸŴܰ�
			int sales = product.getQty() * product.getSalemoney(); 
			//���Աݾ� = ���� * ���Դܰ�
			int buy = product.getQty() * product.getBuymoney();
			//���ͱ� =�Ǹűݾ� - (���Աݾ� + ��۷�)
			int sum = sales - (buy + product.getFee());
			//������ = ���ͱ� / ���Աݾ� * 100
			double rate = sum / (double)buy * 100; //sum buy 100�� �� �����̹Ƿ� ��� ������ double�� ������� ��
			product.setSum(sum);  product.setRate(rate);
		}
	}
	
	private void sort(){ //sort�ϱ� ���ؼ���, product�� comparable�� �ڽ��̾�� �Ѵ�. �׷��� product Ŭ�������� implements Comparable���� ����
		Collections.sort(this.list); //sort()�� parameter�� list�迭�� �ڽ� �� �����ϴϱ� this.list �־���
		//sort�ϰ� ������ Comparable�� �ڽ��� �Ǿ�� �ϰ�(compareto����) sort������ Collections.sort()���ָ� ��
		//�̷��� �����ϸ� ������ ��������, ������ ���� ���� �͵��� �˰������� �����ϴ� �ͺ��� �ξ� �� ����.	
	}
	
	
	private void output(){ 
		//PrintStream�� �̿��Ͽ� ���Ϸ� ��� 
		//print�� �ϴµ� stream���� ������? byte���
		//�츮�� ���²� �ؿ� Sytem.out.println(ǥ�����)�� type�� PrintStream�̴�.(�츮�� �ؿԴ� ��)
		
		try(PrintStream ps = new PrintStream(//PrintStream(OutputStream)�̹Ƿ� outputstream�� �ڽĵ�(�� �� FileOutPutStrema)�� �� ��밡���ϴ�
				new FileOutputStream("C:/temp/productresult.txt"))){
			for(Product product : this.list) { //�ݺ��� ��� : list
				ps.println(product); //printstream���� �������� ��. printstream�� ����� "C:/temp/productresult.txt"�� ����Ű�� �����ϱ� �� ���Ͽ� �������ٴ� �� 
			}//�̷��� prinstream�� ������ ���뿡 ���
			ps.flush(); //for������ ���뿡 �ݺ��ؼ� �� �������� �ѹ��� flush
			System.out.println("Save Success");
		}catch(IOException ex) {
			System.out.println(ex);
		}
		//��ǰ�� �ѹ��� �������� autoflush �����൵ �ȴ�.
		//api���� autocloseble �ڽ��̸� finally�� �ᵵ �ȴ�.
		
		
		}
	}

