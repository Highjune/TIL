package practice;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
	public static void main(String[] args) {
		Map<Student, Integer> map = new HashMap<Student, Integer>();
		
		//�й��� �̸��� ������ Student �� Ű�� ����
		//�Ʒ� 2���� ���� ������ ���
		map.put(new Student(1, "ȫ�浿"), 95);
		map.put(new Student(1, "ȫ�浿"), 95);
		
		//1����
		System.out.println("�� Entry �� : " + map.size());
		
	}
}
