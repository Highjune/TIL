import java.util.Scanner;

class Input {
	private Employee [] array;
	private Scanner scan;
	
	public Input(Employee [] array){
		this.array = array;
		scan = new Scanner(System.in);
	}
	public int input(){
		String y_n = null;
		int count = 0;
		do{
			count++;
			System.out.print("�����ȣ : ");
			int sabun = this.scan.nextInt();
			System.out.print("�� : ");
			int grade = this.scan.nextInt();
			System.out.print("ȣ : ");
			int ho = this.scan.nextInt();
			System.out.print("���� : ");
			int sudang = this.scan.nextInt();
			System.out.print("�Է�/���(I/O) ? : ");
			y_n = this.scan.next();
			Employee em = new Employee(sabun, grade, ho, sudang);
			this.array[count-1] = em;
		}while(y_n.equals("I") || y_n.equals("i"));
		return count;
	}
}
