package com.example.sawol;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int numb = -1;
		Main main = new Main();
		
		while(true) {
			main.showmenu();
			numb = main.input();
			if(numb > 6 || numb < 0) System.out.println("1~6사이의 번호를 입력하세요");
			else if(numb == 6) {System.out.println("다음에 또 해보세요~"); break;}
			else {
				main.output(numb);
			}
		}
	}
	
	
	
	public void showmenu(){
		System.out.println("=================");
		System.out.println("아래에서 메뉴를 선택하세요");
		System.out.println("1. Girin");
		System.out.println("2. Gun");
		System.out.println("3. Hee");
		System.out.println("4. Seungsu");
		System.out.println("5. Son");
		System.out.println("6. 안할래요");
		System.out.println("=================");
	}
	
	public int input() {
		int num = -1;
		Scanner scan = new Scanner(System.in);
		num = scan.nextInt();
		return num;		
	}
	
	
	public void output(int n) {
		June j = null;
		switch(n) {
		case 1 : j = new Girin(); j.shouting(); break;
		case 2 : j = new Gun(); j.shouting(); break;
		case 3 : j = new Hee(); j.shouting(); break;
		case 4 : j = new Seungsu(); j.shouting(); break;
		case 5 : j = new Son(); j.shouting(); break;		
		}		
	}
}
