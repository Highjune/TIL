package com.example.view;
import java.util.Scanner;

import com.example.service.SungjukMgmtService;
import com.example.service.SungjukMgmtServiceImpl;
import com.example.vo.StudentVO;

public class Search {
	private Scanner scan;
	private SungjukMgmtService service;
	
	public Search() {
		this.scan = new Scanner(System.in);
		this.service = new SungjukMgmtServiceImpl();
	}
	
	public StudentVO search() {
		System.out.print("�л��� �й� : ");
		String hakbun = this.scan.next();
		StudentVO student = this.service.read(hakbun);
		return student;
	}
	public void display(StudentVO student) {
		if(student == null) System.out.println("���ǿ� �´� �л��� ã�� ���߽��ϴ�.");
		else if(student != null) System.out.println(student);
	}
}



