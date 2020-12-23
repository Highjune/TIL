package com.gym.view;

import java.sql.SQLException;
import java.util.Scanner;

import com.gym.dao.AdminDao;
import com.gym.service.AdminService;
import com.gym.vo.GymVO;

public class Search {
	private Scanner scan;
	private AdminService service;

	
	public Search() {
		this.scan=new Scanner(System.in);
		this.service=new AdminService();

	}
	
	public GymVO search() {
	   // this.output();
        System.out.print("회원 번호를 입력하세요 : ");
        int num= this.scan.nextInt();
        GymVO gym=this.service.read(num); //다시 확인 후 
        return gym;
        
	}
	public GymVO bodysearch()  {
		 System.out.print("회원 번호를 입력하세요 : ");
	        int num= this.scan.nextInt();
	        GymVO gym=this.service.readBody(num); //다시 확인 후 
	        return gym;
	}
	public void display(GymVO gym) {
        if(gym == null) 
        	System.out.println("조건에 맞는 학생을 찾지 못했습니다.");
        else if(gym != null) {
        	System.out.printf("이름: %s\n",gym.getName());
        	//System.out.printf("%d\n",gym.getNum());
        	System.out.printf("성별: %s\n",gym.getGender());
        	System.out.printf("나이: %d\n",gym.getAge());
        	System.out.printf("연락처: %s\n",gym.getPhone());
        	System.out.printf("키: %.1f\n",gym.getHeight());
        	System.out.printf("몸무게: %.1f\n",gym.getWeight());
        	System.out.printf("등록기간: %s~%s\n",gym.getStartd2(),gym.getEndd2());
        	System.out.printf("목표체중: %.1f\n",gym.getGoal());
        	System.out.printf("BMI: %.1f\n",gym.getBmi());
        	System.out.printf("전달 대비 몸무게: %.1f\n",gym.getCha());
        	System.out.printf("출석률: %s\n",gym.getRate());        	        	
        }
        	       
    }
	public void output() {
		System.out.println("------------------------------");
        System.out.println("           회원검색              ");
        System.out.println("------------------------------");
	}

}

