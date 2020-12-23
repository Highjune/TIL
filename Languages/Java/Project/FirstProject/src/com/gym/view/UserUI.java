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
			case 1: // �� ��ü ���� ��ȸ
				uoutput.bodyoutput(userid);
				break;
			case 2: // �� ���� ��ȸ
				uoutput.output(userid);
				break;
			case 3:
				this.rankprocess(); // ���� �޴���-> rankmenu()
				break;
			case 0: // �α׾ƿ�
				System.out.println("�α׾ƿ� �Ǿ����ϴ�.");
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
		case 2: //�⼮��
			RankOutput rk2 = new RankOutput();
			rk2.rankVisit();
			break;
		case 0:
			this.user_showmenu();
			break;
		}
	}

	public int user_showmenu() {
		System.out.println("[ȸ��]");
		System.out.println("1. �� ��ü ���� ��ȸ");
		System.out.println("2. �� ���� ��ȸ");
		System.out.println("3. ��ü ���� ��ȸ");
		System.out.println("0. �α׾ƿ�");
		System.out.print("���� >> ");
		return this.scan.nextInt();
	}

	public int rankmenu() {
		System.out.println("1.���޴�� ������ ������");
		System.out.println("2.�⼮��");
		System.out.println("0.���� �޴���");
		System.out.print("���� >> ");
		return this.scan.nextInt();
	}

}
