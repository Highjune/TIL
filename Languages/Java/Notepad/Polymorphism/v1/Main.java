package com.example.polymorphism;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int num = -1;
		Main main = new Main();
		while(true) {
			main.showmenu();
			num = main.input();
			if(num > 5 || num < 1) System.out.println("다시 입력하세요");
			else if(num == 5) {System.out.println("안녕히 가세요~"); break;}
			else {
				main.output(num);
				continue;
			}			
		}
	}
	
	public void showmenu() {
		System.out.println("===========");
		System.out.println("1. American");
		System.out.println("2. Korean");
		System.out.println("3. Cat");
		System.out.println("4. Dog");
		System.out.println("5. 선택안할래요");
		System.out.println("===========");
	}
	
	public int input() {
		Scanner scan = new Scanner(System.in);
		System.out.println("위에서 하나를 입력하세요");
		int num = scan.nextInt();
		return num;	
	}
	
	public void output(int n) {
		Mammal mam = null;
		switch(n) {
		case 1 : mam = new American(); mam.saySomething(); break;
		case 2 : mam = new Korean(); mam.saySomething();   break;
		case 3 : mam = new Cat(); mam.saySomething(); 	   break;
		case 4 : mam = new Dog(); mam.saySomething(); 	   break;
		}
	}
}


