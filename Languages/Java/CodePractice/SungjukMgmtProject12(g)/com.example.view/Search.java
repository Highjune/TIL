package com.example.view;
import java.util.Scanner;

import com.example.controller.SelectService;

public class Search {
	private Scanner scan;
	
	public Search() {
		this.scan = new Scanner(System.in);
	}
	
	public Student search() {
		System.out.print("학생의 학번 : ");
		String hakbun = this.scan.next();
		SelectService ss = new SelectService();
		Student s = ss.select(hakbun); //리턴은 dao까지 다녀와서 찾은 student인 것임. 즉 controller의 selectService의 select()함수를 통해서 다녀옴
		return s; //null or 찾은 학생(student)
	}
	
	public void display(Student s) {
		if(s == null) System.out.println("조건에 맞는 학생을 찾지 못했습니다.");
		else if(s != null) System.out.println(s);
	}
	
}

