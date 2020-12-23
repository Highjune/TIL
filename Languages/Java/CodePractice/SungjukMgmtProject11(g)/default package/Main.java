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
				Student s = search.search(); //못 찾았으면 null, 찾았으면 Student를 넘겨줄 것임.
				if(s != null) { //찾은 경우
					System.out.print("학번 : " + s.getHakbun() + "\t");      
					System.out.print("이름 : " + s.getName() + "\t");
					System.out.print("국어 : " + s.getKor() + "\t");       
					System.out.print("영어 : " + s.getEng() + "\t");
					System.out.println("수학 : " + s.getMat());
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
				if(s1 != null) { //찾았다면
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
				System.exit(0); //정상종료 : 0
				break;
		}
	}
	private int showMenu() {
		System.out.println("******Menu******");
		System.out.println("1. 전체학생보기");
		System.out.println("2. 학생등록");
		System.out.println("3. 학생조회");
		System.out.println("4. 학생정보수정");
		System.out.println("5. 학생삭제");
		System.out.println("6. 파일로 백업하기");
		System.out.println("7. 종료하기");
		System.out.print("Select a Menu : ");    
		return this.scan.nextInt();
	}		
}
