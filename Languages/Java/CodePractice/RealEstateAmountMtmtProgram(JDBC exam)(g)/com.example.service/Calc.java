package com.example.service;
import java.util.List;
 
import com.example.vo.Employee;

public class Calc {
	public void calc(List<Employee> list) {
		for(Employee emp : list) {	
			//�ѱݾ� = ȣ�޼��� + �⺻�� + �߰����� + ��������
			int total = emp.getBonus() + emp.getDefaultSalary() + 
							emp.getNightBonus() + emp.getFamilyBonus();
			
			//������ ȣ�޼����� 10%
			int tax = (int)(emp.getBonus() * 0.1);
			
			//�Ǽ��ɾ��� �ѱݾ׿��� ������ ���ݾ��̴�
			int money = total - tax;
			
			//setTotal, setMoney�� ���� employee�� ���� �߰����ְ�  get, set�� ���� ������ֱ�
			emp.setTotal(total);
			emp.setMoney(money);
		}
	}
}

