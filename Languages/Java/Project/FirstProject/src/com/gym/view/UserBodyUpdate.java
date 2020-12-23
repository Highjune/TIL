package com.gym.view;

import java.util.Scanner;

import com.gym.service.AdminService;
import com.gym.vo.GymVO;

public class UserBodyUpdate {
	private Scanner scan;
	private AdminService service;
	
	public UserBodyUpdate() {
		this.scan=new Scanner(System.in);
		this.service=new AdminService();
		
	}
	public void update(GymVO gym) {
		System.out.println("------------------------------");
        System.out.println("           회원 신체 정보 수정             ");
        System.out.println("------------------------------");
        System.out.println("변경전 측정일 : " + gym.getCheckday());
        System.out.println("변경할 측정일은 오늘입니다. ");
       // String checkday=this.scan.nextLine();
        
        System.out.println("변경전 몸무게 : " + gym.getWeight());
        System.out.print("변경할 몸무게 : ");
        double weight = this.scan.nextDouble();
       
        gym.setWeight(weight);
        
        int row = this.service.changeUpdate(gym);
        
        if(row == 1) System.out.println("회원정보 수정 성공");
        else System.out.println("회원정보 수정 실패");
        
        
        
		
	}
	
	

}
/*public void update(StudentVO s) {
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
