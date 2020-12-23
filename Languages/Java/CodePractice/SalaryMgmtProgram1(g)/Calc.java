import java.util.Vector;

import kr.co.sist.libs.utils.DepartmentUtil;
import kr.co.sist.libs.utils.SalGrade;

public class Calc {
	private Vector<Salary> vector;

	public Calc(Vector<Salary> vector) {
		this.vector = vector;
	}
	
	public void calc() {
		for(Salary sal : this.vector) {
			//"�����ȣ"�� �Է��� "�μ����ڵ�+ȣ�޼����ڵ�+���� 2�ڸ����� �ԷµǸ� �μ����ڵ��
			//<�μ����ڵ�ǥ>�� �����ϰ� ȣ�޼����ڵ�� <ȣ�޼����ڵ�>�� �����Ѵ�.
			String sabun = sal.getSabun();   //"A522"
			char code = sabun.charAt(0);  //'A'
			String department = DepartmentUtil.getDepartment(code);  //������
			char gradeChar = sabun.charAt(1);  //'5'
			String gradeStr = String.valueOf(gradeChar);   //'5' --> "5"
			int grade = Integer.parseInt(gradeStr);  //"5" --> 5
			int hoSalary = SalGrade.getSalaryGrade(grade); //300000
			//�������� = ������ * 7000;
			int familyBonus = sal.getFamily() * 7000;   
			int nightBonus = SalGrade.getHourBonus(sal.getNightHour());
			//�ѱݾ��� ȣ�޼��� + �⺻�� + �߰����� + ���������̴�.
			int defSalary = sal.getDefSalary();  //3 --> 35000
			int sum = hoSalary + SalGrade.getDefaultSalary(defSalary) + 
									nightBonus + familyBonus;
			//������ ȣ�޼����� 10%
			int tax = (int)(hoSalary * 0.1);
			//�Ǽ��ɾ��� �ѱݾ׿��� ������ ���ݾ��̴�
			int salary = sum - tax;
			sal.setDepartment(department);  //�μ���
			sal.setHoSalary(hoSalary);   //ȣ�޼���
			sal.setFamilyBonus(familyBonus);   //��������
			sal.setNightBonus(nightBonus);      //�߰�����
			sal.setSum(sum);    //�ѱݾ�
			sal.setSalary(salary);   //�Ǽ��ɾ�
		}
	}
}





