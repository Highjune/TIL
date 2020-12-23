package test;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
	public static void main(String[] args) {
		Set<Member> set = new HashSet<Member>();
		
		//인스턴스는 다르지만 이름과 나이가 동일하므로 객체 1개만 저장
		set.add(new Member("홍길동", 30));
		set.add(new Member("홍길동", 30));
		
		//저장된 객체 수 얻기
		System.out.println("총 객체수 : " + set.size());
	}
}
