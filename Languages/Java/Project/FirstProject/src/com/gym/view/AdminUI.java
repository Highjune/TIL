package com.gym.view;

import java.util.Scanner;

import com.gym.service.AdminService;
import com.gym.vo.GymVO;

public class AdminUI {
	private Scanner scan;
	private AdminService service;
	private Login login;

	public AdminUI() {
		this.scan = new Scanner(System.in);
		this.service = new AdminService();
		this.login = new Login();

	}

	public void admin_process() {
		while (true) {
			int choice = this.admin_showmenu();
			switch (choice) {
			case 1:
				this.select_process(); // 회원조회 메뉴로 ->select_process
				break;
			case 2:
				Input input = new Input(); // 회원 등록
				GymVO gym3 = input.input();
				int row = this.service.create(gym3);
				input.display(row);
				break;
			case 3:
				Search search = new Search();
				GymVO gym = search.search();
				UserUpdate uu = new UserUpdate(); // 회원 정보 수정
				uu.update(gym);
				break;
			case 4:
				Search search1 = new Search();
				GymVO gym1 = search1.bodysearch();
				UserBodyUpdate ubu = new UserBodyUpdate(); // 회원 신체정보 수정
				ubu.update(gym1);
				break;
			case 5: // 회원삭제
				Search search2 = new Search();
				GymVO gym2 = search2.search();
				search2.display(gym2);
				System.out.print("삭제하시겠습니까(y/n) ? : ");
				if (this.scan.next().toUpperCase().equals("Y")) {
					if (this.service.delete(gym2.getNum()) == 1) {
						System.out.println("학생이 잘 삭제됐습니다.");
					}
				}
				break;
			case 0: // 로그아웃
				System.out.println("로그아웃 되었습니다.");
//            login.login(); 
				// System.exit(0);
//            break;
				return;
			}
		}

	}

	public void select_process() {
		int choice = this.select_showmenu();
		AdminOutput ao = new AdminOutput();
		switch (choice) {
		case 1: // 전체 회원 목록
			ao.output();
			break;
		case 2:
			// GenderOutput goutput=new GenderOutput(); //성별로 조회
			ao.genderoutput();
			break;
		case 3:
			Search search = new Search(); // 회원 검색
			search.output();
			GymVO gym = search.search();
			search.display(gym);
			break;
		case 0:
			//this.admin_process(); // 이전 메뉴로
			//break;
			return;

		}

	}

	public int admin_showmenu() {
		System.out.println("[관리자 모드]");
		System.out.println("1. 회원 조회");
		System.out.println("2. 회원 등록");
		System.out.println("3. 회원 정보 수정");
		System.out.println("4. 회원 신체 정보 수정");
		System.out.println("5. 회원 삭제");
		System.out.println("0. 로그아웃");
		System.out.print("선택 >> ");
		return this.scan.nextInt();

	}

	public int select_showmenu() {
		System.out.println("[회원 조회]");
		System.out.println("1. 전체 회원 목록");
		System.out.println("2. 성별로 조회");
		System.out.println("3. 회원 검색");
		System.out.println("0. 이전 메뉴로");
		System.out.print("선택 >> ");
		return this.scan.nextInt();
	}

}
