import java.util.*;

//중복값을 저장하지 않는 HashSet의 특성을 이용해서 Lotto번호를 생성하는 것
//자바의 정석 p632
public class HashSetLotto {
	public static void main(String[] args) {
		Set set = new HashSet();
		
		for (int i=0 ; set.size() < 6 ; i++) { //중복된 값이 있을 수 있으니 단순히 반복문을 6번만 돌리면 안된다.
			int num = (int)(Math.random()*45) + 1;
			set.add(new Integer(num));
		}
		
		List list = new LinkedList(set); //LinkedList(Collection c)
		Collections.sort(list);
		System.out.println(list);
	}	
}


