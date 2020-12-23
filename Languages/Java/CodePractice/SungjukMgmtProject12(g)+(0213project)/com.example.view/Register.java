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
		System.out.println("*****ȸ������������******");
		System.out.print("���̵� : ");
		String userid = this.scan.next();
		System.out.print("��й�ȣ : ");
		String passwd = this.scan.next();
		MemberVO member = new MemberVO(userid, passwd);
		int row = this.service.register(member);
		if(row == 1) System.out.println("ȸ�� ���� ����");
		else System.out.println("ȸ�� ���� ����");
	}
	
}
