package com.example.view;
import java.util.Scanner;

import com.example.vo.StudentVO;

public class Input {
	private Scanner scan;
	
	public Input() {
		this.scan = new Scanner(System.in);
	}
	
	public StudentVO input() {
		System.out.print("�й� : ");  String hakbun = scan.next();
		System.out.print("�̸� : ");  String name = scan.next();
		System.out.print("���� : ");  int kor = scan.nextInt();
		System.out.print("���� : ");  int eng = scan.nextInt();
		System.out.print("���� : ");  int mat = scan.nextInt();
		System.out.print("���� : ");  int edp = scan.nextInt();
			
		StudentVO s = new StudentVO(hakbun, name, kor, eng, mat, edp);
		return s;
	}
	
	public void display(int row) {
		if(row == 1) System.out.println("�л� ��� ����");
		else System.out.println("�л� ��� ����");
	}
}

