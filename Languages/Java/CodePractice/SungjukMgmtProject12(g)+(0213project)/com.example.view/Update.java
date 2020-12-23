package com.example.view;

import java.util.Scanner;

import com.example.service.SungjukMgmtService;
import com.example.service.SungjukMgmtServiceImpl;
import com.example.vo.StudentVO;

public class Update {
	private Scanner scan;
	private SungjukMgmtService service;
	
	public Update() {
		this.scan = new Scanner(System.in);
		this.service = new SungjukMgmtServiceImpl();
	}
	public void update(StudentVO s) {
		System.out.println("******�л���������******");
		System.out.printf("<<%s(%s)'s information>>\n", s.getHakbun(), s.getName());
		System.out.println("������ ���� : " + s.getKor());
		System.out.print("������ ���� : ");
		int kor = this.scan.nextInt();
		System.out.println("������ ���� : " + s.getEng());
		System.out.print("������ ���� : ");
		int eng = this.scan.nextInt();
		System.out.println("������ ���� : " + s.getMat());
		System.out.print("������ ���� : ");
		int mat = this.scan.nextInt();
		System.out.println("������ ���� : " + s.getEdp());
		System.out.print("������ ���� : ");
		int edp = this.scan.nextInt();
		s.setKor(kor);   s.setEng(eng);  s.setMat(mat);   s.setEdp(edp);
		
		int row = this.service.update(s);
		if(row == 1) System.out.println("�л����� ���� ����");
		else System.out.println("�л����� ���� ����");
	}
}




