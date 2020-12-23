package com.example.controller;

import java.sql.SQLException;

import com.example.dao.StudentDao;
import com.example.view.Student;

public class InsertService { //��� �ǹ����� logic�� �� �� �ܰ��뿡�� �̷�����.
	//�տ��� insert�� �л��� �޾Ƽ� �ڷ� �ѱ� �� �ٽ� row�� ��� �´�.
	public int insert(Student s) { //�տ��� �ް�
		int row = 0;
		try { 
			row = StudentDao.insert(s); //�ڷ� �Ѱܼ� �ٽ� row ����
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return row;
	}
}
