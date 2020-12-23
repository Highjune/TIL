package com.example.view;
import java.util.List;

import com.example.service.SungjukMgmtService;
import com.example.service.SungjukMgmtServiceImpl;
import com.example.vo.StudentVO;

public class Output {
	private SungjukMgmtService service;
	
	public Output() {
		this.service = new SungjukMgmtServiceImpl();
	}
	
	public void output() {
		List<StudentVO> list = this.service.readAll();
		this.printLabel();
		for(StudentVO student : list) {
			System.out.println(student);
		}
	}
	private void printLabel() {
		System.out.println("�ֿ����б� �����������α׷�");
		System.out.println("----------------------------------------------------------------");
		System.out.println("�й�     �̸�     ����    ����    ����    ����    ����    ���     ����");
		System.out.println("----------------------------------------------------------------");
	}
}
