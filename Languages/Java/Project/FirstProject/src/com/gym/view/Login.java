package com.gym.view;

import java.util.Scanner;
import com.gym.service.MembershipService;

public class Login {
	private Scanner scan;
    private MembershipService service;
     
    public Login() {
        this.scan = new Scanner(System.in);
        this.service = new MembershipService();
    }
     
    public int login() {
    	while(true) {
    		System.out.println("------------------------------");
            System.out.println("         <<�α���>>        ");
            System.out.println("------------------------------");
            System.out.print("ID : ");
            int userid = this.scan.nextInt();
            System.out.print("PW : ");
            String passwd = this.scan.next();
            int number = this.service.login(userid, passwd);
    		switch(number) {
    		case -1:
    			System.out.println("��ϵ��� ���� ȸ���Դϴ�.");
    			break;
    		case 0: //ȸ��
    			System.out.println("�α��� ����");
    		 			
    			return userid;   			
    		case 1: 
    			System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
    			break;
    			 		
    		}
    				
    	}
   		
		
	}
        

}


 