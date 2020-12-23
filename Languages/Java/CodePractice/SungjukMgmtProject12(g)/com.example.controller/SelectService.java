package com.example.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import com.example.dao.StudentDao;
import com.example.view.Student;

public class SelectService {
	//���� view���� �̰��� ȣ���� ���̰�, �� selectAll�� DB���� ��û�ؼ� list�� �޾ƿ�.
	public ArrayList<Student> selectAll(){ //���� �л��� ����(�� �������ϱ� paramater�� ����)
		ArrayList<Student> list = null;
		try {
			list = StudentDao.selectAll(); //list�� �޾ƿ�.
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}
	
	public Student select(String hakbun) { //�Ѹ��� �л��� ������ ����(primary key�� �л��� �޾Ƽ� �ѱ�)
		Student s = null;
		try {
			s = StudentDao.select(hakbun);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return s; //null or ã�� student
	}
}
