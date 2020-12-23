package com.example.ui;

import java.util.Scanner;

public class SalaryMgmtUI {
	private Scanner scan;
	
	public SalaryMgmtUI() {
		this.scan = new Scanner(System.in);
		while(true) {
			int choice = this.showMenu();
			this.process(choice);
		}
	}
	private void process(int choice) {
		switch(choice) {
			case 1:  
				Input input = new Input();
				int row = input.input();
				if(row == 1) System.out.println("Insert Success");
				else System.out.println("Insert Failure");
				break;
			case 2:
				Output output = new Output();
				output.output();
				break;
			case 3:
				Search search = new Search();
				search.search();
				break;
			default : 
				System.out.println("Bye!!!");
				System.exit(0);
		}
	}
	private int showMenu() {
		System.out.println("**** Menu ****");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 출력");
		System.out.println("3. 데이터 조회");
		System.out.println("4. 프로그램 종료");
		System.out.print("선택 >> : ");
		return this.scan.nextInt();
	}
}
