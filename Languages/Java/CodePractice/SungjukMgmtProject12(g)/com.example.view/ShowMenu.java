package com.example.view;

import java.util.Scanner;

public class ShowMenu {
	private Scanner scan;
	
	public ShowMenu() {
		this.scan = new Scanner(System.in);
	}
	public int display() {
		System.out.println("******Menu******");
		System.out.println("1. ��ü�л�����");
		System.out.println("2. �л����");
		System.out.println("3. �л���ȸ");
		System.out.println("4. �л���������");
		System.out.println("5. �л�����");
		System.out.println("6. ���Ϸ� ����ϱ�");
		System.out.println("7. �����ϱ�");
		System.out.print("Select a Menu : ");    
		return this.scan.nextInt(); //���⼭ scan�� �ʿ��ϴϱ� ���ʿ� �����δ� ��(���� �����ڿ���)
	}	
}
