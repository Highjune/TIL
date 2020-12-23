package com.example.view;

import java.util.Scanner;

public class ShowMenu {
	private Scanner scan;
	
	public ShowMenu() {
		this.scan = new Scanner(System.in);
	}
	public int display() {
		System.out.println("******Menu******");
		System.out.println("1. 전체학생보기");
		System.out.println("2. 학생등록");
		System.out.println("3. 학생조회");
		System.out.println("4. 학생정보수정");
		System.out.println("5. 학생삭제");
		System.out.println("6. 파일로 백업하기");
		System.out.println("7. 종료하기");
		System.out.print("Select a Menu : ");    
		return this.scan.nextInt(); //여기서 scan이 필요하니까 애초에 만들어두는 것(위의 생성자에서)
	}	
}
