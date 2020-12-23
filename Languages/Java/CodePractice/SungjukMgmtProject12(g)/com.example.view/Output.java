package com.example.view;
import java.util.ArrayList;

public class Output {
	public void output(ArrayList<Student> list) {
		this.printLabel();
		for(Student s : list) { //student의 tostring호출해서 찍음 ?
			System.out.println(s);
		}
	}
	private void printLabel() { 
		//내가 직접 작업하기
	}
}
