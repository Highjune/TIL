import java.util.Scanner;

public class Input {
	private Student[] array;
	private Scanner scan;
	
	public Input(Student[] array) {
		this.array = array;
		this.scan= new Scanner(System.in);	
	}
	
	public void input() {
		
		for(int i=0; i < array.length ; i++) {
			System.out.println((i+1) + "번째 학생의 정보 입력");
			array[i] = new Student();
			
			System.out.println("What is your student cord?");
			array[i].setHakbun(scan.next());
			
			System.out.println("What is your name?");
			array[i].setName(scan.next());
			
			System.out.println("What is your kor scord?");
			array[i].setKor(scan.nextInt());
			
			System.out.println("What is your eng scord?");
			array[i].setEng(scan.nextInt());
			
			System.out.println("What is your mat scord?");
			array[i].setMat(scan.nextInt());
		}	
	}
}
