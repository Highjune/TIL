package com.example.view;
import java.util.Scanner;

import com.example.controller.SelectService;

public class Search {
	private Scanner scan;
	
	public Search() {
		this.scan = new Scanner(System.in);
	}
	
	public Student search() {
		System.out.print("�л��� �й� : ");
		String hakbun = this.scan.next();
		SelectService ss = new SelectService();
		Student s = ss.select(hakbun); //������ dao���� �ٳ�ͼ� ã�� student�� ����. �� controller�� selectService�� select()�Լ��� ���ؼ� �ٳ��
		return s; //null or ã�� �л�(student)
	}
	
	public void display(Student s) {
		if(s == null) System.out.println("���ǿ� �´� �л��� ã�� ���߽��ϴ�.");
		else if(s != null) System.out.println(s);
	}
	
}

