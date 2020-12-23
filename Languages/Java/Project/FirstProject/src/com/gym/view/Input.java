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
		System.out.println("              회원등록              ");
		System.out.println("------------------------------");
		System.out.print("회원번호 : ");   int num = scan.nextInt();
		System.out.print("이름 : ");   String name = scan.next();
		System.out.print("성별 : ");   String gender =scan.next();
		System.out.print("나이 : ");   int age = scan.nextInt();
		System.out.print("연락처 : ");  String phone = scan.next();
		System.out.print("키(cm) : ");  double height = scan.nextDouble();
		System.out.print("몸무게(kg) : ");  double weight = scan.nextDouble();
		System.out.print("등록일 : ");  String start = scan.next();
        Date startd = Date.valueOf(start);
		System.out.print("마감일 : ");  String end = scan.next();
		Date endd=Date.valueOf(end);
		System.out.print("목표체중(kg) : ");  double goal = scan.nextDouble();
		
		//날짜 string을 date형으로 바꿔줘야함

		GymVO gym=new GymVO(num,name,gender,age,phone,height,weight,startd,endd,goal);
		
		return gym;
	}
 
public void display(int row) {
    if(row == 1) System.out.println("학생 등록 성공");
    else System.out.println("학생 등록 실패");
}

}