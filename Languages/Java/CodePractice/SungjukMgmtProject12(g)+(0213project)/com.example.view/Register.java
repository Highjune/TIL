package com.example.view;

import java.util.Scanner;

import com.example.service.MembershipService;
import com.example.service.MembershipServiceImpl;
import com.example.vo.MemberVO;

public class Register {
	private Scanner scan;
	private MembershipService service;
	
	public Register() {
		this.scan = new Scanner(System.in);
		this.service = new MembershipServiceImpl();
	}
	
	public void register() {
		System.out.println("*****회원가입페이지******");
		System.out.print("아이디 : ");
		String userid = this.scan.next();
		System.out.print("비밀번호 : ");
		String passwd = this.scan.next();
		MemberVO member = new MemberVO(userid, passwd);
		int row = this.service.register(member);
		if(row == 1) System.out.println("회원 가입 성공");
		else System.out.println("회원 가입 실패");
	}
	
}
