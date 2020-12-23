package com.gym.view;

import java.util.List;
import java.util.Scanner;

import com.gym.service.AdminService;
import com.gym.vo.GymVO;

public class AdminOutput {
	private AdminService admin;
	private Scanner scan;
	
	public AdminOutput() {
		this.admin=new AdminService();
		this.scan=new Scanner(System.in);
	}
	
	public void output() {
		//System.out.println("관리자 전체회원 조회");
		List<GymVO> list = this.admin.readAll();
		System.out.println("                    전체 회원 목록              ");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("회원번호      이름      성별    나이        연락처                  등록기간   ");
        System.out.println("---------------------------------------------------------------------------------");
        for(GymVO gym : list) {
        	if(gym.getNum()>10) {
        	System.out.printf("%d\t%s\t%s\t%d\t%s\t%s\n"
            		,gym.getNum(),gym.getName(),gym.getGender(),gym.getAge(),gym.getPhone(),gym.getGigan());
        	}
        }
		
	}
	public void genderoutput() {
		//System.out.println("관리자 성별 조회");
		System.out.print("조회할 성별을 입력하세요(M/F):");
		String gender=this.scan.next();
		List<GymVO> list = this.admin.readGender(gender);
			System.out.println("                     성별 조회              ");
	        System.out.println("-----------------------------------------------------------");
	        System.out.println("회원번호     이름      성별     나이     연락처        등록기간   ");
	        System.out.println("------------------------------------------------------------");
	        for(GymVO gym : list) {
	            System.out.printf("%d\t%s\t%s\t%d\t%s\t%s~%s\n"
	            		,gym.getNum(),gym.getName(),gym.getGender(),gym.getAge(),gym.getPhone(),gym.getStartd2(),gym.getEndd2());   
	        }
	}
	
	

}