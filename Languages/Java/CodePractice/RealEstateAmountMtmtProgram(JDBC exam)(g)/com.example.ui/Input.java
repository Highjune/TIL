package com.example.ui;

import java.util.Scanner;

import com.example.service.SalaryMgmtService;
import com.example.service.SalaryMgmtServiceImpl;
import com.example.vo.Employee;

public class Input {
	private Scanner scan;
	private SalaryMgmtService service;
	
	public Input() {
		this.scan = new Scanner(System.in);
		this.service = new SalaryMgmtServiceImpl(); //������ input�Ϸ��� ���񽺷� �Ѱܾ� �ϴ�. 
	}
	
	//UI������ �Է� �ޱ⸸ �ϰ� ��� ���� �� ���񽺷� �ѱ��.UI������ business logic�� �ϸ� �ȵǱ� ������.��
	//�Է¹��� �͵�� employee ���� ���񽺷� �ѱ�� ��.
	public int input() {
		System.out.println("**** ��� ���� ������ ****");
		System.out.print("��� : ");   String empno = this.scan.next();
		String code = empno.substring(0, 1);   //"A522" => A�� �̱����ؼ��� 0���� 1������.(1�� ����x) 
		int grade = Integer.parseInt(empno.substring(1, 2));  //5
		System.out.print("�̸� : ");   String name = this.scan.next();
		System.out.print("�⺻�� : "); int num = this.scan.nextInt();
		System.out.print("�߰��ٹ��ð� : ");   int nightcode = this.scan.nextInt();
		System.out.print("������ : ");     int family = this.scan.nextInt();
		Employee emp = new Employee(empno, name, code, num, grade, nightcode, family);
		return this.service.insertEmployee(emp);
	}
}



