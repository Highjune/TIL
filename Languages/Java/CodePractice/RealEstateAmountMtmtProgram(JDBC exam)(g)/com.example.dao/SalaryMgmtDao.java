package com.example.dao;

import java.sql.SQLException;
import java.util.List;

import com.example.vo.Employee;

public interface SalaryMgmtDao {
	int insert(Employee employee) throws SQLException;
	List<Employee> selectAll() throws SQLException;
	Employee select(String empno)  throws SQLException;
}
