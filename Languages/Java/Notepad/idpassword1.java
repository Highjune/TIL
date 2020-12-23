package test;

import java.util.HashMap;
import java.util.Scanner;

public class idpassword1 {
	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("june1", 1); //"1"은 string이라서 밑에서 password를 String으로 정의해야 되며, 1은 integer라서 밑에서 password를 int로 정의해서 비교해야 된다.
		map.put("june2", 2);
		map.put("june3", 3);;
		map.put("june4", 4);
//		map.put("id", 4);
		
//		System.out.println(map);
		
		Scanner scan = new Scanner(System.in);
		
		String id = "";
		int password = 0;
		
		while(true) {
			System.out.println("아이디와 패스워드를 입력하세요");
			System.out.println("id : ");
			id = scan.nextLine().trim();
					
			System.out.println("password : ");
			password = scan.nextInt();
			System.out.println();
			
			if(!map.containsKey(id)) { //"id"와 id는 다르다. id는 위에서 입력받은 것. "id"는 말 그대로 key 값이 "id"라는 것.
				System.out.println("입력하신 아이디는 존재하지 않습니다.");
				continue;
			}
			
			if(!(map.get(id).equals(password))) {
				System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해 주세요");
			} else {
				System.out.println("id와 비밀번호가 일치합니다.");
				break;
			}
		}	
	

		
		
	}
}
