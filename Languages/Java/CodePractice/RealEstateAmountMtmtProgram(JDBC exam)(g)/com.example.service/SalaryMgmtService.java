package com.example.service;

import java.util.List;

import com.example.vo.Employee;

//CRRUD 전체가 아니라 insert와 select만
public interface SalaryMgmtService {
	int insertEmployee(Employee employee);
	Employee selectEmployee(String sabun); //pk인 sabun으로 검색(pdf에 의해)
	List<Employee> selectAllEmployee();
}
