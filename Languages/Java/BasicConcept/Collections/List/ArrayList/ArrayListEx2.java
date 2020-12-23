import java.util.*;

//자바의 정석 p587


//긴 문자열 데이터를 원하는 길이로 잘라서 ArrayList에 담은 다음 출력하는 것.
public class ArrayListEx2 {
	public static void main(String[] args) {
		final int LIMIT = 10; //자르고자 하는 글자의 개수
		String source = "01234567890abcdefghijkABCDEFGJI!@#$%^&*()zzz";
		int length = source.length();
		
		List list = new ArrayList(length/LIMIT + 10); //크기를 약간 여유 있게 잡음.
		
		for(int i = 0; i<length; i+=LIMIT) {
			if(i+LIMIT < length)
				list.add(source.substring(i, i+LIMIT));
			else
				list.add(source.substring(i));	
		}
		
		
		for(int i = 0 ; i<list.size(); i++) {
			System.out.println(list.get(i));
		}	
	}
}
