package com.example.view;
import java.util.List;

import com.example.service.SungjukMgmtService;
import com.example.service.SungjukMgmtServiceImpl;
import com.example.vo.StudentVO;

public class Output {
	private SungjukMgmtService service;
	
	public Output() {
		this.service = new SungjukMgmtServiceImpl();
	}
	
	public void output() {
		List<StudentVO> list = this.service.readAll();
		this.printLabel();
		for(StudentVO student : list) {
			System.out.println(student);
		}
	}
	private void printLabel() {
		System.out.println("쌍용고등학교 성적관리프로그램");
		System.out.println("----------------------------------------------------------------");
		System.out.println("학번     이름     국어    영어    수학    전산    총점    평균     평점");
		System.out.println("----------------------------------------------------------------");
	}
}
