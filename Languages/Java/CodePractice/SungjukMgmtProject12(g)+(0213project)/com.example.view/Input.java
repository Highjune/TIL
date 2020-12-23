package com.example.view;
import java.util.Scanner;

import com.example.vo.StudentVO;

public class Input {
	private Scanner scan;
	
	public Input() {
		this.scan = new Scanner(System.in);
	}
	
	public StudentVO input() {
		System.out.print("학번 : ");  String hakbun = scan.next();
		System.out.print("이름 : ");  String name = scan.next();
		System.out.print("국어 : ");  int kor = scan.nextInt();
		System.out.print("영어 : ");  int eng = scan.nextInt();
		System.out.print("수학 : ");  int mat = scan.nextInt();
		System.out.print("전산 : ");  int edp = scan.nextInt();
			
		StudentVO s = new StudentVO(hakbun, name, kor, eng, mat, edp);
		return s;
	}
	
	public void display(int row) {
		if(row == 1) System.out.println("학생 등록 성공");
		else System.out.println("학생 등록 실패");
	}
}

