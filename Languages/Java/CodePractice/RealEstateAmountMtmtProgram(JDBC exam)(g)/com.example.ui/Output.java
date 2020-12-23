package com.example.ui;

import java.util.List;

import com.example.service.SalaryMgmtService;
import com.example.service.SalaryMgmtServiceImpl;
import com.example.vo.Employee;

public class Output {
	private SalaryMgmtService service;
	
	public Output() {
		service = new SalaryMgmtServiceImpl();
	}
	
	public void output() {
		printLabel();
		List<Employee> list = this.service.selectAllEmployee();
		for(Employee emp : list) {
			System.out.println(emp);
		}
	}
	
	private void printLabel() {}

}
