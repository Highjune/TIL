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
			//"사원번호"의 입력은 "부서명코드+호급수당코드+숫자 2자리“로 입력되며 부서명코드는
			//<부서명코드표>를 참조하고 호급수당코드는 <호급수당코드>를 참조한다.
			String sabun = sal.getSabun();   //"A522"
			char code = sabun.charAt(0);  //'A'
			String department = DepartmentUtil.getDepartment(code);  //영업부
			char gradeChar = sabun.charAt(1);  //'5'
			String gradeStr = String.valueOf(gradeChar);   //'5' --> "5"
			int grade = Integer.parseInt(gradeStr);  //"5" --> 5
			int hoSalary = SalGrade.getSalaryGrade(grade); //300000
			//가족수당 = 가족수 * 7000;
			int familyBonus = sal.getFamily() * 7000;   
			int nightBonus = SalGrade.getHourBonus(sal.getNightHour());
			//총금액은 호급수당 + 기본급 + 야간수당 + 가족수당이다.
			int defSalary = sal.getDefSalary();  //3 --> 35000
			int sum = hoSalary + SalGrade.getDefaultSalary(defSalary) + 
									nightBonus + familyBonus;
			//세금은 호급수당의 10%
			int tax = (int)(hoSalary * 0.1);
			//실수령액은 총금액에서 세금을 뺀금액이다
			int salary = sum - tax;
			sal.setDepartment(department);  //부서명
			sal.setHoSalary(hoSalary);   //호급수당
			sal.setFamilyBonus(familyBonus);   //가족수당
			sal.setNightBonus(nightBonus);      //야간수당
			sal.setSum(sum);    //총금액
			sal.setSalary(salary);   //실수령액
		}
	}
}





