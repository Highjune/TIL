package com.example.dao;

import java.sql.SQLException;
import java.util.List;

import com.example.vo.StudentVO;

//CRRUD
//��� dao�۾��� �̰��� �� �Ѵ�.
public interface SungjukMgmtDao {
	int insertStudent(StudentVO student) throws SQLException;
	StudentVO selectStudent(String hakbun) throws SQLException;
	List<StudentVO> selectAllStudent() throws SQLException;
	int updateStudent(StudentVO student) throws SQLException;
	int deleteStudent(String hakbun) throws SQLException;
}
