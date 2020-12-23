package com.gym.view;

import java.util.List;

import com.gym.service.UserService;
import com.gym.vo.GymVO;

public class UserOutput {
  private UserService service;
	
	public UserOutput() {
		this.service=new UserService();
	}
	
	public void output(int userid) {
		GymVO gym = this.service.userAll(userid);
	    System.out.println("------------------------------------------------------------");
		System.out.printf("                   %s�� ���� ��ȸ               \n",gym.getName());
	    System.out.println("------------------------------------------------------------");	        
	    System.out.printf("ȸ����ȣ : %d\n",userid);
	    System.out.printf("���� : %s\n",gym.getGender());
	    System.out.printf("���� : %d\n",gym.getAge());
	    System.out.printf("����ó : %s\n",gym.getPhone());
	    System.out.printf("Ű : %.1f\n",gym.getHeight());
	    System.out.printf("������ : %.1f\n",gym.getWeight());
	    System.out.printf("��ϱⰣ : %s\n",gym.getPeriod());
	    System.out.printf("��ǥü�� : %.1f\n",gym.getGoal());
	    System.out.printf("�� �⼮�� : %s\n",gym.getRate());	    
	}

	public void bodyoutput(int userid) {
		//System.out.println("������ü����");
		List<GymVO> list = this.service.userBody(userid);
			System.out.println("                 �� ��ü ���� ��ȸ              ");
	        System.out.println("-----------------------------------------------------------");
	        System.out.println("    ������       ������(kg)      ���޴�� ������ ����(kg)     bmi   ");
	        System.out.println("------------------------------------------------------------");
	        for(GymVO gym : list) {
	            System.out.printf("%s\t%.1f\t\t%.1f\t\t%.1f\n",gym.getCheckday(),gym.getCweight(),gym.getReduce(),gym.getBmi());
	        }
	}


}
