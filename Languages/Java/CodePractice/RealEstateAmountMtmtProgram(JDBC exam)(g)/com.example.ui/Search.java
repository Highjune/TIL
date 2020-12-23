package com.example.ui;

import java.util.Scanner;

import com.example.service.SalaryMgmtService;
import com.example.service.SalaryMgmtServiceImpl;
import com.example.vo.Employee;

public class Search {
	private SalaryMgmtService service;
	private Scanner scan;
	
	public Search() {
		this.scan = new Scanner(System.in);
		this.service = new SalaryMgmtServiceImpl();
	}
	
	public void search() {
		System.out.println("**** ��� �˻� ������ ****");
		System.out.print("�����ȣ : ");   String empno = this.scan.next();
		Employee emp = this.service.selectEmployee(empno);
		System.out.println("�̸� : " + emp.getName()); 
		System.out.println("�⺻�� : " + emp.getNum());
		System.out.println("�߰� ���� : " + emp.getNightcode());
		System.out.println("������ : " + emp.getFamily());
	}

}
