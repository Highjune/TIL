package com.gym.view;

import java.util.Scanner;

import com.gym.service.AdminService;
import com.gym.vo.GymVO;

public class UserUpdate {
	private Scanner scan;
	private AdminService service;
	
	public UserUpdate() {
		this.scan=new Scanner(System.in);
		this.service=new AdminService();
		
	}
	public void update(GymVO gym) {
		System.out.println("------------------------------");
        System.out.println("           회원정보 수정             ");
        System.out.println("------------------------------");
        System.out.println("이름: " + gym.getName());
        System.out.print("변경할 이름 : ");
        String name= this.scan.next();
        System.out.println("성별 : " + gym.getGender());
        System.out.print("변경할 성별 : ");
        String gender= this.scan.next();
        System.out.println("나이 : " + gym.getAge());
        System.out.print("변경할 나이 : ");
        int age = this.scan.nextInt();
        System.out.println("연락처 : " + gym.getPhone());
        System.out.print("변경할 연락처 : ");
        String phone= this.scan.next();
        System.out.println("키 : " + gym.getHeight());
        System.out.print("변경할 키 : ");
        double height = this.scan.nextDouble();
        System.out.println("몸무게 : " + gym.getWeight());
        System.out.print("변경할 몸무게 : ");
        double weight = this.scan.nextDouble();
        System.out.println("목표체중 : " + gym.getGoal());
        System.out.print("변경할 몸무게 : ");
        double goal = this.scan.nextDouble();
        System.out.println("등록일 : " + gym.getStartd2());
        System.out.print("변경할 등록일 : ");
        String startd = this.scan.next();
        System.out.println("마감일 : " + gym.getEndd2());
        System.out.print("변경할 마감일 : ");
        String endd = this.scan.next();
        gym.setAge(age); gym.setName(name); gym.setGender(gender);
        gym.setPhone(phone); gym.setHeight(height); gym.setWeight(weight);
        gym.setGoal(goal); gym.setStartd2(startd); gym.setEndd2(endd);
        
        int row = this.service.originalUpdate(gym);
        if(row == 1) System.out.println("학생정보 수정 성공");
        else System.out.println("학생정보 수정 실패");
        
		
	}
	/* public void update(StudentVO s) {
        System.out.println("******학생정보수정******");
        System.out.printf("<<%s(%s)'s information>>\n", s.getHakbun(), s.getName());
        System.out.println("변경전 국어 : " + s.getKor());
        System.out.print("변경할 국어 : ");
        int kor = this.scan.nextInt();
        System.out.println("변경전 영어 : " + s.getEng());
        System.out.print("변경할 영어 : ");
        int eng = this.scan.nextInt();
        System.out.println("변경전 수학 : " + s.getMat());
        System.out.print("변경할 수학 : ");
        int mat = this.scan.nextInt();
        System.out.println("변경전 전산 : " + s.getEdp());
        System.out.print("변경할 전산 : ");
        int edp = this.scan.nextInt();
        s.setKor(kor);   s.setEng(eng);  s.setMat(mat);   s.setEdp(edp);
         
        int row = this.service.update(s);
        if(row == 1) System.out.println("학생정보 수정 성공");
        else System.out.println("학생정보 수정 실패");
    }
    */

}
