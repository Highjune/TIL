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
				this.select_process(); // ȸ����ȸ �޴��� ->select_process
				break;
			case 2:
				Input input = new Input(); // ȸ�� ���
				GymVO gym3 = input.input();
				int row = this.service.create(gym3);
				input.display(row);
				break;
			case 3:
				Search search = new Search();
				GymVO gym = search.search();
				UserUpdate uu = new UserUpdate(); // ȸ�� ���� ����
				uu.update(gym);
				break;
			case 4:
				Search search1 = new Search();
				GymVO gym1 = search1.bodysearch();
				UserBodyUpdate ubu = new UserBodyUpdate(); // ȸ�� ��ü���� ����
				ubu.update(gym1);
				break;
			case 5: // ȸ������
				Search search2 = new Search();
				GymVO gym2 = search2.search();
				search2.display(gym2);
				System.out.print("�����Ͻðڽ��ϱ�(y/n) ? : ");
				if (this.scan.next().toUpperCase().equals("Y")) {
					if (this.service.delete(gym2.getNum()) == 1) {
						System.out.println("�л��� �� �����ƽ��ϴ�.");
					}
				}
				break;
			case 0: // �α׾ƿ�
				System.out.println("�α׾ƿ� �Ǿ����ϴ�.");
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
		case 1: // ��ü ȸ�� ���
			ao.output();
			break;
		case 2:
			// GenderOutput goutput=new GenderOutput(); //������ ��ȸ
			ao.genderoutput();
			break;
		case 3:
			Search search = new Search(); // ȸ�� �˻�
			search.output();
			GymVO gym = search.search();
			search.display(gym);
			break;
		case 0:
			//this.admin_process(); // ���� �޴���
			//break;
			return;

		}

	}

	public int admin_showmenu() {
		System.out.println("[������ ���]");
		System.out.println("1. ȸ�� ��ȸ");
		System.out.println("2. ȸ�� ���");
		System.out.println("3. ȸ�� ���� ����");
		System.out.println("4. ȸ�� ��ü ���� ����");
		System.out.println("5. ȸ�� ����");
		System.out.println("0. �α׾ƿ�");
		System.out.print("���� >> ");
		return this.scan.nextInt();

	}

	public int select_showmenu() {
		System.out.println("[ȸ�� ��ȸ]");
		System.out.println("1. ��ü ȸ�� ���");
		System.out.println("2. ������ ��ȸ");
		System.out.println("3. ȸ�� �˻�");
		System.out.println("0. ���� �޴���");
		System.out.print("���� >> ");
		return this.scan.nextInt();
	}

}
