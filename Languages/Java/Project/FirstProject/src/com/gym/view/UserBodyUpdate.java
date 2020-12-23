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
        System.out.println("           ȸ�� ��ü ���� ����             ");
        System.out.println("------------------------------");
        System.out.println("������ ������ : " + gym.getCheckday());
        System.out.println("������ �������� �����Դϴ�. ");
       // String checkday=this.scan.nextLine();
        
        System.out.println("������ ������ : " + gym.getWeight());
        System.out.print("������ ������ : ");
        double weight = this.scan.nextDouble();
       
        gym.setWeight(weight);
        
        int row = this.service.changeUpdate(gym);
        
        if(row == 1) System.out.println("ȸ������ ���� ����");
        else System.out.println("ȸ������ ���� ����");
        
        
        
		
	}
	
	

}
/*public void update(StudentVO s) {
        System.out.println("******�л���������******");
        System.out.printf("<<%s(%s)'s information>>\n", s.getHakbun(), s.getName());
        System.out.println("������ ���� : " + s.getKor());
        System.out.print("������ ���� : ");
        int kor = this.scan.nextInt();
        System.out.println("������ ���� : " + s.getEng());
        System.out.print("������ ���� : ");
        int eng = this.scan.nextInt();
        System.out.println("������ ���� : " + s.getMat());
        System.out.print("������ ���� : ");
        int mat = this.scan.nextInt();
        System.out.println("������ ���� : " + s.getEdp());
        System.out.print("������ ���� : ");
        int edp = this.scan.nextInt();
        s.setKor(kor);   s.setEng(eng);  s.setMat(mat);   s.setEdp(edp);
         
        int row = this.service.update(s);
        if(row == 1) System.out.println("�л����� ���� ����");
        else System.out.println("�л����� ���� ����");
    }
    */
