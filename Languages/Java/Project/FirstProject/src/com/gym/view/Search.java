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
        System.out.print("ȸ�� ��ȣ�� �Է��ϼ��� : ");
        int num= this.scan.nextInt();
        GymVO gym=this.service.read(num); //�ٽ� Ȯ�� �� 
        return gym;
        
	}
	public GymVO bodysearch()  {
		 System.out.print("ȸ�� ��ȣ�� �Է��ϼ��� : ");
	        int num= this.scan.nextInt();
	        GymVO gym=this.service.readBody(num); //�ٽ� Ȯ�� �� 
	        return gym;
	}
	public void display(GymVO gym) {
        if(gym == null) 
        	System.out.println("���ǿ� �´� �л��� ã�� ���߽��ϴ�.");
        else if(gym != null) {
        	System.out.printf("�̸�: %s\n",gym.getName());
        	//System.out.printf("%d\n",gym.getNum());
        	System.out.printf("����: %s\n",gym.getGender());
        	System.out.printf("����: %d\n",gym.getAge());
        	System.out.printf("����ó: %s\n",gym.getPhone());
        	System.out.printf("Ű: %.1f\n",gym.getHeight());
        	System.out.printf("������: %.1f\n",gym.getWeight());
        	System.out.printf("��ϱⰣ: %s~%s\n",gym.getStartd2(),gym.getEndd2());
        	System.out.printf("��ǥü��: %.1f\n",gym.getGoal());
        	System.out.printf("BMI: %.1f\n",gym.getBmi());
        	System.out.printf("���� ��� ������: %.1f\n",gym.getCha());
        	System.out.printf("�⼮��: %s\n",gym.getRate());        	        	
        }
        	       
    }
	public void output() {
		System.out.println("------------------------------");
        System.out.println("           ȸ���˻�              ");
        System.out.println("------------------------------");
	}

}

