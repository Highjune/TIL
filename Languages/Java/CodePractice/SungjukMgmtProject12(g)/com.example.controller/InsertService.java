package com.example.controller;

import java.sql.SQLException;

import com.example.dao.StudentDao;
import com.example.view.Student;

public class InsertService { //사실 실무에서 logic은 다 이 단계쯤에서 이뤄진다.
	//앞에서 insert할 학생을 받아서 뒤로 넘긴 후 다시 row를 들고 온다.
	public int insert(Student s) { //앞에서 받고
		int row = 0;
		try { 
			row = StudentDao.insert(s); //뒤로 넘겨서 다시 row 들고옴
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return row;
	}
}
