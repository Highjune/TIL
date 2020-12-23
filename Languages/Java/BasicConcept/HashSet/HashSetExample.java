package test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		
		set.add("Java");
		set.add("JDBC");
		set.add("Servlet/JSP");
		set.add("Java"); // overlap upper "Java". so cannot save.
		set.add("iBATIS");
		
		int size = set.size();
		System.out.println("number of total object : " + size);
		
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			String element = iterator.next();
			System.out.println("\t" + element);
		}
		
		set.remove("JDBC");
		set.remove("iBATIS");
		
		size = set.size();
		System.out.println("-----After remove 2 object -----");
		System.out.println("number of total object : " + size);
		
		iterator = set.iterator();
		for(String element : set) {
			System.out.println("\t" + element);
		}
		
		set.clear(); // empty & erate all object
		if(set.isEmpty()) {
			System.out.println("now empty");
		}
		
	}
}
