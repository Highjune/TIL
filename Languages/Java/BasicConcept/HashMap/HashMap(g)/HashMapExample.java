package practice;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
	public static void main(String[] args) {
		Map<Student, Integer> map = new HashMap<Student, Integer>();
		
		//학번과 이름이 동일한 Student 를 키로 저장
		//아래 2개는 같은 것으로 취급
		map.put(new Student(1, "홍길동"), 95);
		map.put(new Student(1, "홍길동"), 95);
		
		//1개임
		System.out.println("총 Entry 수 : " + map.size());
		
	}
}
