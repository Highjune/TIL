package com.example.dao;

import java.sql.SQLException;
import java.util.List;

import com.example.vo.StudentVO;

//CRRUD
//모든 dao작업은 이것이 다 한다.
public interface SungjukMgmtDao {
	int insertStudent(StudentVO student) throws SQLException;
	StudentVO selectStudent(String hakbun) throws SQLException;
	List<StudentVO> selectAllStudent() throws SQLException;
	int updateStudent(StudentVO student) throws SQLException;
	int deleteStudent(String hakbun) throws SQLException;
}
