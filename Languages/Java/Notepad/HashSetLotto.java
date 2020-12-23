package practice;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

//중복값 저장하지 않는 HashSet 특성 이용해서 로또번호 만들기
public class HashSetLotto {
	public static void main(String[] args) {
		Set set = new HashSet();	
		
		for(int i = 0 ; set.size() < 6; i++) {
			int number = (int)(Math.random()*45)+1;
			set.add(number);
		}
	
		List list = new LinkedList(set);
//		List list = new ArrayList(set); // 이걸로 해도 됨
		Collections.sort(list);
		System.out.println(list);
		
	}

}
