package com.example.view;

import java.util.Scanner;

import com.example.service.SungjukMgmtService;
import com.example.service.SungjukMgmtServiceImpl;
import com.example.vo.StudentVO;

public class SungjukMgmtUI {
	private Scanner scan;
	private SungjukMgmtService service;  //�������� ���ؼ� SungjukMgmtServiceImpl ��� �̰��� ����(�̰��� ������ �θ� ���� �ڽ��� �� ����� �� �ֱ⿡), �θ� �ѱ�� �ڽ��� SungjukMgmtServiceImpl�� �޴´�.
	private boolean flag;
	
	public SungjukMgmtUI() { //������ - ��� �ʱ�ȭ
		this.scan = new Scanner(System.in);
		this.service = new SungjukMgmtServiceImpl(); //������. �θ�(service)�� new�� �� ������ �ڽ�(SungjukMgmtServiceImpl)�� new��밡���ϴ�. �θ��� �ּҷ� �ڽĿ��� ���ٰ���.
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
		System.out.println("[�����������α׷�]");
		System.out.println("(1)Login       (2)Register       (3)Exit ");
		System.out.print("���� >> ");
		switch(this.scan.nextInt()) {
			case 1 : 
				Login login = null;
				while(true) {
					login = new Login();
					int number = login.login();  //-1, 0, 1
					if(number == -1) System.out.println("�׷� ���̵�� �������� �ʽ��ϴ�.");
					else if(number == 0) System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
					else if(number == 1) {
						System.out.println("Login Success");
						this.flag = true;
						//�α��� ������ ���� break
						break; //break�� �ݺ����� ����ٴ� ����. ���ǹ����� �ƹ��� ���� x
					}
				}
				break; 
			case 2 :
				Register register = new Register();
				register.register();
				break;
			case 3 : 
				System.out.print("���� �����Ͻðڽ��ϱ�(y/n) ? : ");
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
				search2.display(student2); //ã�� student �����ְ�
				System.out.print("���� �����Ͻðڽ��ϱ�(y/n) ? : ");
				if(this.scan.next().toUpperCase().equals("Y")) {
					if(this.service.delete(student2.getHakbun()) == 1) { //delete���� ������ �Ǿ��ٸ� 1�� ������ ���̹Ƿ�.
						System.out.println("�л��� �� �����ƽ��ϴ�.");
					}
				}
				break;
		}
	}

	public int showMenu() {
		System.out.println("[�����������α׷�]");
		System.out.println("1. ��ü�л�����");
		System.out.println("2. �л����");
		System.out.println("3. �л���ȸ");
		System.out.println("4. �л���������");
		System.out.println("5. �л�����");
		System.out.println("0. �����ϱ�");
		System.out.print("���� >> ");                
		return this.scan.nextInt();
	}
}
