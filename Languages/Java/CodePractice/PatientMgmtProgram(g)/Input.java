import java.util.Scanner;

public class Input {
	private Patient [] array;
	private Scanner scan;

	public Input(Patient [] array){
		this.array = array;
		this.scan = new Scanner(System.in);
	}
	public int input(){
		int count = 0;
		char y_n = '\0';   //초기화
		do{
			count++;
			System.out.print("번호 : ");
			int bunho = this.scan.nextInt();
			System.out.print("진료코드 : ");
			String code = this.scan.next();
			System.out.print("입원일수 : ");
			int day = this.scan.nextInt();
			System.out.print("나이 : ");
			int age = this.scan.nextInt();
			System.out.print("입력 / 출력 (I/O) ? :");
			y_n = this.scan.next().charAt(0);
			this.array[count-1] = new Patient(bunho, code, day, age);
		}while(count <= 5 && (y_n == 'i' || y_n == 'I'));
		return count;
	}
}
