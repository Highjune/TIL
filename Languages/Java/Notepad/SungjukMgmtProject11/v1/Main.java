import java.util.Scanner;

public class Main {
	private Scanner scan;

	private Main() {
		this.scan = new Scanner(System.in);
	}

	public static void main(String[] args) {
		Main main = new Main();
		int choice = -1;		
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
				Student s = search.search();
				if(s!=null) {
					System.out.println("학번 : " + s.getHakbun() + "\t");
					System.out.println("이름 : " + s.getName() + "\t");
					System.out.println("국어 : " + s.getKor() + "\t");
					System.out.println("영어 : " + s.getEng() + "\t");
					System.out.println("수학 : " + s.getMat() + "\t");
				}				
				break;
			case 4 : 
				Search search11 = new Search(this.scan);
				Student sss = search11.search();
				
				if(sss!=null) {
					Update update = new Update(this.scan);
					update.update(sss);			
				}		
					break;
			case 5 : 
//				Delete delete = new Delete();
//				Search search1 = new Search(this.scan);
//				Student ss = search1.search();
//				delete.delete(ss);			
//				break;
				//위와 같이 코딩했을 경우, 없는 회원 삭제요청시 에러가 난다. 왜냐하면 DB에 없는 회원요청에 대한 재요청 반문 처리를 애초에 Search에서 하기 때문.				
				Search search1 = new Search(this.scan);
				Student ss = search1.search();
				if(ss != null) {
					Delete delete = new Delete();
					delete.delete(ss);
				}
				break;
			case 6 : 
				Output output1 = new Output();
				output1.output1();
				break;
			case 7 : 
				System.out.println("Bye");
				System.exit(0); 
				break;			
			}		
	}

	private int showMenu() {
		System.out.println("*******Menu*******");
		System.out.println("원하시는 메뉴를 선택하세요");
		System.out.println("1. 전체학생보기");
		System.out.println("2. 학생등록");
		System.out.println("3. 학생조회");
		System.out.println("4. 학생정보수정");
		System.out.println("5. 학생삭제");
		System.out.println("6. 파일로 백업하기");
		System.out.println("7. 종료하기");
		System.out.println("Select a Menu");
		int choice = this.scan.nextInt();
		return choice;	

	}
}
