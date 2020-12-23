package com.example.service;
import java.util.List;
 
import com.example.vo.Employee;

public class Calc {
	public void calc(List<Employee> list) {
		for(Employee emp : list) {	
			//총금액 = 호급수당 + 기본급 + 야간수당 + 가족수당
			int total = emp.getBonus() + emp.getDefaultSalary() + 
							emp.getNightBonus() + emp.getFamilyBonus();
			
			//세금은 호급수당의 10%
			int tax = (int)(emp.getBonus() * 0.1);
			
			//실수령액은 총금액에서 세금을 뺀금액이다
			int money = total - tax;
			
			//setTotal, setMoney를 위해 employee에 변수 추가해주고  get, set도 따로 만들어주기
			emp.setTotal(total);
			emp.setMoney(money);
		}
	}
}

