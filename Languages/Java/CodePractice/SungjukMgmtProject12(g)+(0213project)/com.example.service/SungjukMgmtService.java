package com.example.service;

import java.util.List;

import com.example.vo.StudentVO;

//CRRUD
//interface(��� �߻�޼���� ����)�̴ϱ� �ڽĵ��� �翬�� ������
public interface SungjukMgmtService {
	int create(StudentVO student); //�Էµ� �л��� ���(������� row�� �����ϱ� ���� int)
	StudentVO read(String hakbun); //primary key(hakbun)�� ������ �׿� ���� �л� 1�� ���Ϥ�
	List<StudentVO> readAll(); // ��� �л��� �� ��Ƽ� �;� �Ǵϱ� List����. List�� �ϸ� ���� ���� �ڽ��� Arraylist, vector �� �������� ����ȯ ����.
	int update(StudentVO student); //update�� ����ϱ� int����
	int delete(String hakbun);//delete�� ����ϱ� int����
}

