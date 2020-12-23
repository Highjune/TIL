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
		System.out.println("******학생정보수정******");
		System.out.printf("<<%s(%s)'s information>>\n", s.getHakbun(), s.getName());
		System.out.println("변경전 국어 : " + s.getKor());
		System.out.print("변경할 국어 : ");
		int kor = this.scan.nextInt();
		System.out.println("변경전 영어 : " + s.getEng());
		System.out.print("변경할 영어 : ");
		int eng = this.scan.nextInt();
		System.out.println("변경전 수학 : " + s.getMat());
		System.out.print("변경할 수학 : ");
		int mat = this.scan.nextInt();
		System.out.println("변경전 전산 : " + s.getEdp());
		System.out.print("변경할 전산 : ");
		int edp = this.scan.nextInt();
		s.setKor(kor);   s.setEng(eng);  s.setMat(mat);   s.setEdp(edp);
		
		int row = this.service.update(s);
		if(row == 1) System.out.println("학생정보 수정 성공");
		else System.out.println("학생정보 수정 실패");
	}
}




