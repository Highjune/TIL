package com.example.view;

import java.util.Scanner;

import com.example.service.MembershipService;
import com.example.service.MembershipServiceImpl;

public class Login {
	private Scanner scan;
	private MembershipService service;
	
	public Login() {
		this.scan = new Scanner(System.in);
		this.service = new MembershipServiceImpl();
	}
	
	public int login() {
		System.out.println("******Login Page******");
		System.out.print("���̵� : ");
		String userid = this.scan.next();
		System.out.print("��й�ȣ : ");
		String passwd = this.scan.next();
		return this.service.login(userid, passwd);
	}
}
