package com.gym.view;


import java.sql.Date;
//import java.util.GregorianCalendar;
//import java.util.Date;
import java.util.Scanner;

import com.gym.vo.GymVO;

public class Input {
	private Scanner scan;
	
	public Input() {
		this.scan=new Scanner(System.in);
	}
	
	public GymVO input() {
		System.out.println("------------------------------");
		System.out.println("              ȸ�����              ");
		System.out.println("------------------------------");
		System.out.print("ȸ����ȣ : ");   int num = scan.nextInt();
		System.out.print("�̸� : ");   String name = scan.next();
		System.out.print("���� : ");   String gender =scan.next();
		System.out.print("���� : ");   int age = scan.nextInt();
		System.out.print("����ó : ");  String phone = scan.next();
		System.out.print("Ű(cm) : ");  double height = scan.nextDouble();
		System.out.print("������(kg) : ");  double weight = scan.nextDouble();
		System.out.print("����� : ");  String start = scan.next();
        Date startd = Date.valueOf(start);
		System.out.print("������ : ");  String end = scan.next();
		Date endd=Date.valueOf(end);
		System.out.print("��ǥü��(kg) : ");  double goal = scan.nextDouble();
		
		//��¥ string�� date������ �ٲ������

		GymVO gym=new GymVO(num,name,gender,age,phone,height,weight,startd,endd,goal);
		
		return gym;
	}
 
public void display(int row) {
    if(row == 1) System.out.println("�л� ��� ����");
    else System.out.println("�л� ��� ����");
}

}