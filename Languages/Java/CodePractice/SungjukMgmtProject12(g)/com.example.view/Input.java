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
		System.out.print("�й� : ");  String hakbun = scan.next();
		System.out.print("�̸� : ");  String name = scan.next();
		System.out.print("���� : ");  int kor = scan.nextInt();
		System.out.print("���� : ");  int eng = scan.nextInt();
		System.out.print("���� : ");  int mat = scan.nextInt();
			
		Student s = new Student(hakbun, name, kor, eng, mat);
		this.calc.calc(s);
		return s;
	}
	public void display(int row) {
		if(row == 1) System.out.println("�л� ��� ����");
		else System.out.println("�л� ��� ����");
	}
}
