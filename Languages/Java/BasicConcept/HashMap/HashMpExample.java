package practice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMpExample {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("�ſ��", 85);
		map.put("ȫ�浿", 90);
		map.put("���屺", 80);
		map.put("ȫ�浿", 95);
		System.out.println("�� Entry �� : " + map.size());
		
		System.out.println("\tȫ�浿" + map.get("ȫ�浿"));
		System.out.println();
		
		//��ü�� �ϳ��� ó��. keySet()
		Set<String> keySet = map.keySet();
		Iterator<String> keyIterator = keySet.iterator();
		while(keyIterator.hasNext()) {
			String key = keyIterator.next();
			Integer value = map.get(key);
			System.out.println("\t" + key + " : " + value);
		}
		System.out.println();
		
		map.remove("ȫ�浿");
		System.out.println("�� Entry ��: " + map.size());
		
		//��ü�� �ϳ��� ó��. entrySet();
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
		
		while(entryIterator.hasNext()) {
			Map.Entry<String, Integer> entry = entryIterator.next();
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println("\t" + key + " : " + value);
		}
		
		map.clear();
		System.out.println("�� Entry �� " + map.size());
		
	}
}
