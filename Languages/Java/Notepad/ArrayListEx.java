package practice;

import java.util.ArrayList;
import java.util.List;

public class ArrayListEx {
	public static void main(String[] args) {
		
		final int LIMIT = 10;
		String source = "128379sadfkhasdf812sdhfkkvjhaiuy1jhkdf";
		int length = source.length();
		
		List list = new ArrayList(); //
		
		for(int i = 0 ; i<length ; i+=LIMIT) {
			if(i+LIMIT<length) {
				list.add(source.substring(i, i+LIMIT));
			} else {
				list.add(source.substring(i));
			}
		}
		
		System.out.println(list.size());
		
		for(int i = 0 ; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		 
	}
}
