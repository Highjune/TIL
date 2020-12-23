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
			System.out.print("사원번호 : ");
			int sabun = this.scan.nextInt();
			System.out.print("급 : ");
			int grade = this.scan.nextInt();
			System.out.print("호 : ");
			int ho = this.scan.nextInt();
			System.out.print("수당 : ");
			int sudang = this.scan.nextInt();
			System.out.print("입력/출력(I/O) ? : ");
			y_n = this.scan.next();
			Employee em = new Employee(sabun, grade, ho, sudang);
			this.array[count-1] = em;
		}while(y_n.equals("I") || y_n.equals("i"));
		return count;
	}
}
