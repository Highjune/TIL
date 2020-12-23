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
		System.out.println("**** 사원 검색 페이지 ****");
		System.out.print("사원번호 : ");   String empno = this.scan.next();
		Employee emp = this.service.selectEmployee(empno);
		System.out.println("이름 : " + emp.getName()); 
		System.out.println("기본급 : " + emp.getNum());
		System.out.println("야간 수당 : " + emp.getNightcode());
		System.out.println("가족수 : " + emp.getFamily());
	}

}
