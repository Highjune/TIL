package com.example.view;
import java.util.Scanner;

public class Input {
	private Scanner scan;
	private Calc calc;
	
	public Input() {
		this.scan = new Scanner(System.in);
		this.calc = new Calc();
	}
	
	public Student input() {
		System.out.print("학번 : ");  String hakbun = scan.next();
		System.out.print("이름 : ");  String name = scan.next();
		System.out.print("국어 : ");  int kor = scan.nextInt();
		System.out.print("영어 : ");  int eng = scan.nextInt();
		System.out.print("수학 : ");  int mat = scan.nextInt();
			
		Student s = new Student(hakbun, name, kor, eng, mat);
		this.calc.calc(s);
		return s;
	}
	public void display(int row) {
		if(row == 1) System.out.println("학생 등록 성공");
		else System.out.println("학생 등록 실패");
	}
}
