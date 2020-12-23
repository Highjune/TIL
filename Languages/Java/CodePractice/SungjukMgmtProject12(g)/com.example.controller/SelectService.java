package com.example.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import com.example.dao.StudentDao;
import com.example.view.Student;

public class SelectService {
	//앞의 view에서 이것을 호출할 것이고, 이 selectAll은 DB에게 요청해서 list를 받아옴.
	public ArrayList<Student> selectAll(){ //여러 학생을 리턴(다 가져오니깐 paramater는 없다)
		ArrayList<Student> list = null;
		try {
			list = StudentDao.selectAll(); //list를 받아옴.
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}
	
	public Student select(String hakbun) { //한명의 학생을 리턴할 것임(primary key인 학생을 받아서 넘김)
		Student s = null;
		try {
			s = StudentDao.select(hakbun);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return s; //null or 찾은 student
	}
}
