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
		//System.out.println("������ ��üȸ�� ��ȸ");
		List<GymVO> list = this.admin.readAll();
		System.out.println("                    ��ü ȸ�� ���              ");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("ȸ����ȣ      �̸�      ����    ����        ����ó                  ��ϱⰣ   ");
        System.out.println("---------------------------------------------------------------------------------");
        for(GymVO gym : list) {
        	if(gym.getNum()>10) {
        	System.out.printf("%d\t%s\t%s\t%d\t%s\t%s\n"
            		,gym.getNum(),gym.getName(),gym.getGender(),gym.getAge(),gym.getPhone(),gym.getGigan());
        	}
        }
		
	}
	public void genderoutput() {
		//System.out.println("������ ���� ��ȸ");
		System.out.print("��ȸ�� ������ �Է��ϼ���(M/F):");
		String gender=this.scan.next();
		List<GymVO> list = this.admin.readGender(gender);
			System.out.println("                     ���� ��ȸ              ");
	        System.out.println("-----------------------------------------------------------");
	        System.out.println("ȸ����ȣ     �̸�      ����     ����     ����ó        ��ϱⰣ   ");
	        System.out.println("------------------------------------------------------------");
	        for(GymVO gym : list) {
	            System.out.printf("%d\t%s\t%s\t%d\t%s\t%s~%s\n"
	            		,gym.getNum(),gym.getName(),gym.getGender(),gym.getAge(),gym.getPhone(),gym.getStartd2(),gym.getEndd2());   
	        }
	}
	
	

}