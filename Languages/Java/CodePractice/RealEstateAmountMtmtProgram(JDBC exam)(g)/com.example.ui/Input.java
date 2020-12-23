package com.example.ui;

import java.util.Scanner;

import com.example.service.SalaryMgmtService;
import com.example.service.SalaryMgmtServiceImpl;
import com.example.vo.Employee;

public class Input {
	private Scanner scan;
	private SalaryMgmtService service;
	
	public Input() {
		this.scan = new Scanner(System.in);
		this.service = new SalaryMgmtServiceImpl(); //실제로 input하려면 서비스로 넘겨야 하니. 
	}
	
	//UI에서는 입력 받기만 하고 계산 등은 다 서비스로 넘긴다.UI에서는 business logic을 하면 안되기 때문에.ㄴ
	//입력받은 것들로 employee 만들어서 서비스로 넘기면 끝.
	public int input() {
		System.out.println("**** 사원 가입 페이지 ****");
		System.out.print("사번 : ");   String empno = this.scan.next();
		String code = empno.substring(0, 1);   //"A522" => A만 뽑기위해서는 0부터 1전까지.(1은 포함x) 
		int grade = Integer.parseInt(empno.substring(1, 2));  //5
		System.out.print("이름 : ");   String name = this.scan.next();
		System.out.print("기본급 : "); int num = this.scan.nextInt();
		System.out.print("야간근무시간 : ");   int nightcode = this.scan.nextInt();
		System.out.print("가족수 : ");     int family = this.scan.nextInt();
		Employee emp = new Employee(empno, name, code, num, grade, nightcode, family);
		return this.service.insertEmployee(emp);
	}
}



