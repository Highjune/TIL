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
        System.out.println("           ȸ������ ����             ");
        System.out.println("------------------------------");
        System.out.println("�̸�: " + gym.getName());
        System.out.print("������ �̸� : ");
        String name= this.scan.next();
        System.out.println("���� : " + gym.getGender());
        System.out.print("������ ���� : ");
        String gender= this.scan.next();
        System.out.println("���� : " + gym.getAge());
        System.out.print("������ ���� : ");
        int age = this.scan.nextInt();
        System.out.println("����ó : " + gym.getPhone());
        System.out.print("������ ����ó : ");
        String phone= this.scan.next();
        System.out.println("Ű : " + gym.getHeight());
        System.out.print("������ Ű : ");
        double height = this.scan.nextDouble();
        System.out.println("������ : " + gym.getWeight());
        System.out.print("������ ������ : ");
        double weight = this.scan.nextDouble();
        System.out.println("��ǥü�� : " + gym.getGoal());
        System.out.print("������ ������ : ");
        double goal = this.scan.nextDouble();
        System.out.println("����� : " + gym.getStartd2());
        System.out.print("������ ����� : ");
        String startd = this.scan.next();
        System.out.println("������ : " + gym.getEndd2());
        System.out.print("������ ������ : ");
        String endd = this.scan.next();
        gym.setAge(age); gym.setName(name); gym.setGender(gender);
        gym.setPhone(phone); gym.setHeight(height); gym.setWeight(weight);
        gym.setGoal(goal); gym.setStartd2(startd); gym.setEndd2(endd);
        
        int row = this.service.originalUpdate(gym);
        if(row == 1) System.out.println("�л����� ���� ����");
        else System.out.println("�л����� ���� ����");
        
		
	}
	/* public void update(StudentVO s) {
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

}
