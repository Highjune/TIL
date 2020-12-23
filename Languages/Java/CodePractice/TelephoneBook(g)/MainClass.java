import java.util.Scanner;

public class MainClass {
	//�ٷ� ���� ��������ó�� ���� ���ؼ� �̸� ����
	private Scanner scan;
	private Friend [] array;
	private int count;
	public MainClass() {  //�����ڰ� �ϴ� ��? ������� �ʱ�ȭ(scanner, array, count �ʱ�ȭ ��)
		this.scan = new Scanner(System.in);
		this.array = new Friend[10];
		this.count = 0;
	}
	public static void main(String[] args) {
		MainClass mc = new MainClass(); //�ּ� ���� => ���� ������ ȣ��. ��¥ġ ��ü ������ �Ǵϱ�, new�� ����鼭 ������ �ʱ�ȭ �۾����� ���ÿ�.
		outer:  // �󺧺ٿ�����.
		do {
			int choice = mc.showMenu();
			switch(choice) {
				case 1 : mc.add(); break;
				case 2 : mc.search(); break;
				case 3 : mc.printList(); break;
				default : break outer;
			}
		}while(true); //���ѷ���
	}
	
	int showMenu() {
		System.out.println("****Menu****");
		System.out.println("1. �߰�");
		System.out.println("2. �˻�");
		System.out.println("3. ��Ϻ���");
		System.out.print("�޴��� �����ϼ��� : ");    
		return this.scan.nextInt();  //���� ��ȣ�� ����, �� ��ȣ�� ������ choice�� ����
	}
	void add() {
		System.out.print("�̸� : ");    String name = this.scan.next();
		System.out.print("��ȭ��ȣ : ");  String tel = this.scan.next();
		System.out.print("���� : ");     String relation = this.scan.next();
		this.array[count] = new Friend(name, tel, relation);   count++; //0��°�� ģ������ �ְ�,�״��� +1 �� �Ŀ� ~ �ٽ�.
	}
	void search() {
		System.out.print("Keyword : ");  String keyword = this.scan.next();
		boolean flag = false;
		for(int i = 0 ; i < this.count ; i++) { //��� ģ���� �˻��ϴ� ���� �ƴ϶�, ���� count������ ã�°�.
			if(this.array[i].getName().equals(keyword) ||
				this.array[i].getTel().equals(keyword) ||
				this.array[i].getRelation().equals(keyword)) {
				System.out.println(this.array[i]);     
				flag = true;  // ã������ true
			}
		}
		if(!flag)  System.out.println("Not Found");//for���� ����µ��� ������ false���~ 
		
	}  //�˻�
	void printList() {
		for(int i = 0; i <this.count ; i++) {
			System.out.println(this.array[i]);
		}
	} //���
	//�� 4������ �� ���, �׷��� �ּҰ� �ʿ�.
}