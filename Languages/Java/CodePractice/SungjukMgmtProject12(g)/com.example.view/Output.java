package com.example.view;
import java.util.ArrayList;

public class Output {
	public void output(ArrayList<Student> list) {
		this.printLabel();
		for(Student s : list) { //student�� tostringȣ���ؼ� ���� ?
			System.out.println(s);
		}
	}
	private void printLabel() { 
		//���� ���� �۾��ϱ�
	}
}
