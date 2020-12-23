package com.example.service;

import java.util.List;

import com.example.vo.StudentVO;

//CRRUD
//interface(모두 추상메서드로 구성)이니까 자식들이 당연히 재정의
public interface SungjukMgmtService {
	int create(StudentVO student); //입력된 학생의 명수(영향받은 row의 갯수니까 리턴 int)
	StudentVO read(String hakbun); //primary key(hakbun)이 들어오면 그에 대한 학생 1명 리턴ㄴ
	List<StudentVO> readAll(); // 모든 학생들 다 담아서 와야 되니까 List리턴. List로 하면 좋은 점은 자식인 Arraylist, vector 로 언제든지 형변환 가능.
	int update(StudentVO student); //update한 명수니까 int리턴
	int delete(String hakbun);//delete한 명수니까 int리턴
}

