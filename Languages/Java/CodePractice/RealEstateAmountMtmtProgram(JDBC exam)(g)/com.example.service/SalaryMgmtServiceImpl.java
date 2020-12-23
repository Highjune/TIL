package com.example.service;

import java.sql.SQLException;
import java.util.List;

import com.example.dao.SalaryMgmtDao;
import com.example.dao.SalaryMgmtDaoImpl;
import com.example.vo.Employee;

public class SalaryMgmtServiceImpl implements SalaryMgmtService {
	private SalaryMgmtDao dao;
	
	public SalaryMgmtServiceImpl() {
		this.dao = new SalaryMgmtDaoImpl();
	}
	@Override
	public int insertEmployee(Employee employee) {
		int row = -1;
		try {
			row = this.dao.insert(employee);
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return row;
	}

	@Override
	public Employee selectEmployee(String sabun) {
		Employee emp = null;
		try {
			emp = this.dao.select(sabun);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return emp;
	}

	@Override
	public List<Employee> selectAllEmployee() {
		List<Employee> list = null;
		Calc c = new Calc();
		try {
			list = this.dao.selectAll();
			c.calc(list); //calc�� �ٳ���� �Ǽ��ɾ�, �ѱݾ��� ����� ��������
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}
  
}
