package com.gym.view;

import java.util.Scanner;

public class Menu {
	private Scanner scan;
	private AdminUI au;
	private UserUI uu;
	private boolean flag;
	
	
	public Menu() {
		this.scan=new Scanner(System.in);
		this.au=new AdminUI();
		this.uu=new UserUI();
		this.flag=false;
		while(!flag) {
			this.init();
		}

	}
	 
	public void init() {
		System.out.println("------------------------------");
		System.out.println("       <<건강해GYM>>");
		System.out.println("------------------------------");
		System.out.println("(1)로그인               (2)종료");
		System.out.print("선택>>");
		int choice=this.scan.nextInt();
		if(choice==1) {
			Login login=null;
				login=new Login();
				int userid=login.login();
				if(userid>10) {
					uu.user_process(userid);
				}
				else if(userid<=10) {
					au.admin_process();	
				}
	
		}else if(choice==2) {
			System.out.print("정말 종료하시겠습니까(y/n) ? : ");
            if(this.scan.next().toUpperCase().equals("Y")) {
                System.out.println("Bye!!!!");
                System.exit(0);
            }
		
	}
		
 }
}
