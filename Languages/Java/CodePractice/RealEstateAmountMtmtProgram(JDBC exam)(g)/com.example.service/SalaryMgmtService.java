package com.example.service;

import java.util.List;

import com.example.vo.Employee;

//CRRUD ��ü�� �ƴ϶� insert�� select��
public interface SalaryMgmtService {
	int insertEmployee(Employee employee);
	Employee selectEmployee(String sabun); //pk�� sabun���� �˻�(pdf�� ����)
	List<Employee> selectAllEmployee();
}
