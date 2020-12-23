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
            System.out.println("         <<로그인>>        ");
            System.out.println("------------------------------");
            System.out.print("ID : ");
            int userid = this.scan.nextInt();
            System.out.print("PW : ");
            String passwd = this.scan.next();
            int number = this.service.login(userid, passwd);
    		switch(number) {
    		case -1:
    			System.out.println("등록되지 않은 회원입니다.");
    			break;
    		case 0: //회원
    			System.out.println("로그인 성공");
    		 			
    			return userid;   			
    		case 1: 
    			System.out.println("비밀번호가 틀렸습니다.");
    			break;
    			 		
    		}
    				
    	}
   		
		
	}
        

}


 