package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class idpassword2 {
	public static void main(String[] args) {
		
		//collection으로 아이디 패스워드 받아서 넣고 확인하기
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		
		Scanner scan = new Scanner(System.in);
		String id = "";
		String password = "";
		
		//3명 정보 받기
		System.out.println("-----------------------------회원가입--------------------------------");
		for(int i = 0 ; i < 3 ; i++) {			
			System.out.println((i+1) + " 번째 사람의" + "아이디와 패스워드를 입력하세요");
			
			System.out.println("id : ");			
			id = scan.nextLine().trim();
						
			System.out.println("password : ");			
			password = scan.nextLine().trim();			
			
			listMap.put(id,  password);
		}
		list.add(listMap);
		
		System.out.println("------------------------------회원가입끝---------------------------");
		System.out.println();
		System.out.println("<<<아이디와 비밀번호 검증 시작>>>");
		 
		System.out.println(list); //	[{june1=1, june2=2, june3=3}]		
	
		while(true) {
			System.out.println("검사하실 아이디와 비밀번호를 입력하세요");
			
			System.out.println("id : ");
			id = scan.nextLine().trim();
			
			System.out.println("password : ");
			password = scan.nextLine().trim();
			
			for(int i = 0 ; i<list.size() ; i++) { // [{june1=1, june2=2, june3=3}]				
				if(!(list.get(i).containsKey(id))) { // 아이디 비교
					System.out.println("아이디가 존재하지 않습니다");
					break;
				} 
				
				if(!(password.equals(list.get(i).get(id)))) { // value를 비밀번호와 비교
					System.out.println("아이디가 존재하지만 비밀번호가 일치하지 않습니다.");
				} else {		
					System.out.println("아이디와 비밀번호가 일치합니다.");
				}
			}			
	}
}
}


