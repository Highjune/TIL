package com.gym.view;

import java.util.Scanner;

public class UserUI {
	private Scanner scan;

	public UserUI() {
		this.scan = new Scanner(System.in);

	}

	public void user_process(int userid) {
		while (true) {
			int choice = this.user_showmenu();
			UserOutput uoutput = new UserOutput();
			switch (choice) {
			case 1: // 내 신체 정보 조회
				uoutput.bodyoutput(userid);
				break;
			case 2: // 내 정보 조회
				uoutput.output(userid);
				break;
			case 3:
				this.rankprocess(); // 순위 메뉴로-> rankmenu()
				break;
			case 0: // 로그아웃
				System.out.println("로그아웃 되었습니다.");
//				System.exit(0);
//				break;
				return;
			}
		}

	}

	public void rankprocess() {
		int number = this.rankmenu();
		switch (number) {
		case 1:
			RankOutput rk1 = new RankOutput();
			
			break;
		case 2: //출석률
			RankOutput rk2 = new RankOutput();
			rk2.rankVisit();
			break;
		case 0:
			this.user_showmenu();
			break;
		}
	}

	public int user_showmenu() {
		System.out.println("[회원]");
		System.out.println("1. 내 신체 정보 조회");
		System.out.println("2. 내 정보 조회");
		System.out.println("3. 전체 순위 조회");
		System.out.println("0. 로그아웃");
		System.out.print("선택 >> ");
		return this.scan.nextInt();
	}

	public int rankmenu() {
		System.out.println("1.전달대비 몸무게 감량률");
		System.out.println("2.출석율");
		System.out.println("0.이전 메뉴로");
		System.out.print("선택 >> ");
		return this.scan.nextInt();
	}

}
