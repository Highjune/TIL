package com.example.view;

import java.util.Scanner;

import com.example.service.SungjukMgmtService;
import com.example.service.SungjukMgmtServiceImpl;
import com.example.vo.StudentVO;

public class SungjukMgmtUI {
	private Scanner scan;
	private SungjukMgmtService service;  //다형성을 위해서 SungjukMgmtServiceImpl 대신 이것을 만듬(이것을 보내면 부모 포함 자식을 다 사용할 수 있기에), 부모를 넘기면 자식인 SungjukMgmtServiceImpl이 받는다.
	private boolean flag;
	
	public SungjukMgmtUI() { //생성자 - 멤버 초기화
		this.scan = new Scanner(System.in);
		this.service = new SungjukMgmtServiceImpl(); //다형성. 부모(service)는 new를 못 쓰지만 자식(SungjukMgmtServiceImpl)은 new사용가능하다. 부모의 주소로 자식에게 접근가능.
		this.flag = false;
		while(!flag) {
			this.init();
		}
		int choice = -1;
		while(true) {
			choice = this.showMenu();
			this.process(choice);
		}
	}

	private void init() {
		System.out.println("[성적관리프로그램]");
		System.out.println("(1)Login       (2)Register       (3)Exit ");
		System.out.print("선택 >> ");
		switch(this.scan.nextInt()) {
			case 1 : 
				Login login = null;
				while(true) {
					login = new Login();
					int number = login.login();  //-1, 0, 1
					if(number == -1) System.out.println("그런 아이디는 존재하지 않습니다.");
					else if(number == 0) System.out.println("비밀번호가 일치하지 않습니다.");
					else if(number == 1) {
						System.out.println("Login Success");
						this.flag = true;
						//로그인 성공할 때만 break
						break; //break는 반복문을 벗어난다는 말임. 조건문과는 아무런 관련 x
					}
				}
				break; 
			case 2 :
				Register register = new Register();
				register.register();
				break;
			case 3 : 
				System.out.print("정말 종료하시겠습니까(y/n) ? : ");
				if(this.scan.next().toUpperCase().equals("Y")) {
					System.out.println("Bye!!!!");
					System.exit(0);
				}
				break;
		}
	}

	private void process(int choice) {
		switch(choice) {
			case 0 :
				System.out.println("Bye!!!");   System.exit(0);
				break;
			case 1 :
				Output output = new Output();
				output.output();
				break;
			case 2 :
				Input input = new Input();
				StudentVO student = input.input();
				int row = this.service.create(student);
				input.display(row);
				break; 
			case 3 :
				Search search = new Search();
				StudentVO student1 = search.search();
				search.display(student1);
				break;
			case 4 :
				Search search3 = new Search();
				StudentVO student3 = search3.search();
				Update update = new Update();
				update.update(student3);
				break;
			case 5 : 
				Search search2 = new Search();
				StudentVO student2 = search2.search();
				search2.display(student2); //찾은 student 보여주고
				System.out.print("정말 삭제하시겠습니까(y/n) ? : ");
				if(this.scan.next().toUpperCase().equals("Y")) {
					if(this.service.delete(student2.getHakbun()) == 1) { //delete에서 삭제가 되었다면 1을 리턴을 것이므로.
						System.out.println("학생이 잘 삭제됐습니다.");
					}
				}
				break;
		}
	}

	public int showMenu() {
		System.out.println("[성적관리프로그램]");
		System.out.println("1. 전체학생보기");
		System.out.println("2. 학생등록");
		System.out.println("3. 학생조회");
		System.out.println("4. 학생정보수정");
		System.out.println("5. 학생삭제");
		System.out.println("0. 종료하기");
		System.out.print("선택 >> ");                
		return this.scan.nextInt();
	}
}
