package practice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMpExample {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("½Å¿ë±Ç", 85);
		map.put("È«±æµ¿", 90);
		map.put("µ¿Àå±º", 80);
		map.put("È«±æµ¿", 95);
		System.out.println("ÃÑ Entry ¼ö : " + map.size());
		
		System.out.println("\tÈ«±æµ¿" + map.get("È«±æµ¿"));
		System.out.println();
		
		//°´Ã¼¸¦ ÇÏ³ª¾¿ Ã³¸®. keySet()
		Set<String> keySet = map.keySet();
		Iterator<String> keyIterator = keySet.iterator();
		while(keyIterator.hasNext()) {
			String key = keyIterator.next();
			Integer value = map.get(key);
			System.out.println("\t" + key + " : " + value);
		}
		System.out.println();
		
		map.remove("È«±æµ¿");
		System.out.println("ÃÑ Entry ¼ö: " + map.size());
		
		//°´Ã¼¸¦ ÇÏ³ª¾¿ Ã³¸®. entrySet();
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
		
		while(entryIterator.hasNext()) {
			Map.Entry<String, Integer> entry = entryIterator.next();
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println("\t" + key + " : " + value);
		}
		
		map.clear();
		System.out.println("ÃÑ Entry ¼ö " + map.size());
		
	}
}
