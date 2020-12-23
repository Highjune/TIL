package com.gym.view;

import java.util.List;

import com.gym.service.UserService;
import com.gym.vo.GymVO;

public class UserOutput {
  private UserService service;
	
	public UserOutput() {
		this.service=new UserService();
	}
	
	public void output(int userid) {
		GymVO gym = this.service.userAll(userid);
	    System.out.println("------------------------------------------------------------");
		System.out.printf("                   %s님 정보 조회               \n",gym.getName());
	    System.out.println("------------------------------------------------------------");	        
	    System.out.printf("회원번호 : %d\n",userid);
	    System.out.printf("성별 : %s\n",gym.getGender());
	    System.out.printf("나이 : %d\n",gym.getAge());
	    System.out.printf("연락처 : %s\n",gym.getPhone());
	    System.out.printf("키 : %.1f\n",gym.getHeight());
	    System.out.printf("몸무게 : %.1f\n",gym.getWeight());
	    System.out.printf("등록기간 : %s\n",gym.getPeriod());
	    System.out.printf("목표체중 : %.1f\n",gym.getGoal());
	    System.out.printf("총 출석일 : %s\n",gym.getRate());	    
	}

	public void bodyoutput(int userid) {
		//System.out.println("유저신체정보");
		List<GymVO> list = this.service.userBody(userid);
			System.out.println("                 내 신체 정보 조회              ");
	        System.out.println("-----------------------------------------------------------");
	        System.out.println("    측정일       몸무게(kg)      전달대비 몸무게 감량(kg)     bmi   ");
	        System.out.println("------------------------------------------------------------");
	        for(GymVO gym : list) {
	            System.out.printf("%s\t%.1f\t\t%.1f\t\t%.1f\n",gym.getCheckday(),gym.getCweight(),gym.getReduce(),gym.getBmi());
	        }
	}


}
