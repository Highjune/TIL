import java.util.Scanner;

public class Main {
	private Scanner scan;
	
	private Main() {
		this.scan = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		int choice = 0;
		while(true) {
			choice = main.showMenu();
			main.process(choice);
		}
	}
	
	private void process(int choice) {
		switch(choice) {
			case 1 : 
				Output output = new Output();
				output.output();
				break;
			case 2 :
				Input input = new Input();
				input.input();
				break;
			case 3 : 
				Search search = new Search(this.scan);
				Student s = search.search(); //�� ã������ null, ã������ Student�� �Ѱ��� ����.
				if(s != null) { //ã�� ���
					System.out.print("�й� : " + s.getHakbun() + "\t");      
					System.out.print("�̸� : " + s.getName() + "\t");
					System.out.print("���� : " + s.getKor() + "\t");       
					System.out.print("���� : " + s.getEng() + "\t");
					System.out.println("���� : " + s.getMat());
				}
				break;
			case 4 :
				Search search2 = new Search(this.scan);
				Student s2 = search2.search();
				if(s2 != null) {
					Update update = new Update(this.scan);
					update.update(s2);
				}
				break;
			case 5 :
				Search search1 = new Search(this.scan);
				Student s1 = search1.search();
				if(s1 != null) { //ã�Ҵٸ�
					Delete delete = new Delete();
					delete.delete(s1);
				}
				break;
			case 6 :
				Output output1 = new Output();
				output1.output1();
				break;
			case 7 : 
				System.out.println("Bye");
				System.exit(0); //�������� : 0
				break;
		}
	}
	private int showMenu() {
		System.out.println("******Menu******");
		System.out.println("1. ��ü�л�����");
		System.out.println("2. �л����");
		System.out.println("3. �л���ȸ");
		System.out.println("4. �л���������");
		System.out.println("5. �л�����");
		System.out.println("6. ���Ϸ� ����ϱ�");
		System.out.println("7. �����ϱ�");
		System.out.print("Select a Menu : ");    
		return this.scan.nextInt();
	}		
}
