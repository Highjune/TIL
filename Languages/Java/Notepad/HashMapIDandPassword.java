package practice;

import java.util.HashMap;
import java.util.Scanner;
//map에 넣어서 id와 password 일치 여부 확인
//꼭 do-while로 안해도 된다. while로 하면 구조가 더 간편. (사실은 똑같다)
public class HashMapIDandPassword {
	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("june1",  "1111");
		map.put("june2",  "2222");
		map.put("june3",  "3333");
		map.put("june4",  "4444");
		Scanner scan = new Scanner(System.in);
		String id= "";
		String password= "";
		
		do {
			System.out.println("==ID와 PASSWORD를 입력하세요==");
			System.out.println("ID : ");
			id = scan.next();
			
			if(!map.containsKey(id)) {
				System.out.println("존재하는 ID가 없습니다. ID를 확인 후 다시 입력하세요");
				continue;
			} else {
				System.out.println("PASSWORD : ");
				password = scan.next();
				if(!map.get(id).equals(password)) {
					System.out.println("비밀번호가 일치하지 않습니다. ID부터 다시 입력하세요");
				} else {
					System.out.println("축하합니다. ID와 비밀번호가 일치합니다.");					
					break;
				}	
			}			
		}while(true);
		System.out.println("수고 하셨습니다.");		
		
	}
}
