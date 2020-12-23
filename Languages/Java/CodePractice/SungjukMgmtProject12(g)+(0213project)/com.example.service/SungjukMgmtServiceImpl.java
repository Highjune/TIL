package com.example.service;

import java.sql.SQLException;
import java.util.List;

import com.example.dao.SungjukMgmtDao;
import com.example.dao.SungjukMgmtDaoImpl;
import com.example.vo.StudentVO;

public class SungjukMgmtServiceImpl implements SungjukMgmtService {
	private SungjukMgmtDao dao;
	
	public SungjukMgmtServiceImpl() {
		this.dao = new SungjukMgmtDaoImpl();
	}
	
	@Override
	public int create(StudentVO student) { //입력할 학생을 ui쪽에서 받으면 dao에게 보낸다. 보내서 받은row를 다시 ui로 보낸다. 
		int row = -1;
		try {
			row = this.dao.insertStudent(student);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return row;
	}
  
	@Override
	public StudentVO read(String hakbun) {
		StudentVO student = null;
		try {
			student = this.dao.selectStudent(hakbun);
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return student;
	}

	@Override
	public List<StudentVO> readAll() {
		List<StudentVO> list = null;
		try {
			list = this.dao.selectAllStudent();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}

	@Override
	public int update(StudentVO student) {
		int row = -1;
		try {
			row = this.dao.updateStudent(student);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return row;
	}

	@Override
	public int delete(String hakbun) { 
		int row = -1;
		try {
			row = this.dao.deleteStudent(hakbun); //받은 학번을 dao에 던져서 row를 들고옴.
		} catch (SQLException e) {
			System.out.println(e);
		}
		return row;
	}

}
