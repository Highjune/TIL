import java.util.HashSet;
import java.util.TreeSet;

//자바의 정석 p579
//set
///코드 확인하기 제대로 안 나옴.


//우리가 collection을 배우는 이유 : 이미 설정한 공간을 늘리거나 늘이는 상황을 위해 
//cf) 배열은 특정한 공간을 고정이 되어 있는 것에 반해~. 

public class SetDemo {
	public static void main(String[] args) {
		HashSet<String> hash = new HashSet<String>();
		TreeSet<String> tree = new TreeSet<String>();
		String[] array = {"한지민", "김지민", "박지민", "김지민", "한지민"}; //중복가능한지 보려고 중복해서 넣음
//		hash.//add: 담는 것. remove : 지우는 것. clear : 다 지우는 것, 방의 갯수: size(length 아님)
		
		for(String str : array) {
			hash.add(str);  //hash set에는 방이 몇 개 ? 3개임.(중복된 데이터가 들어오면 튕기니까)
			tree.add(str);
		}
		//
		
		System.out.println(hash.toString()); //hash 에서 toString이 애초에 재정의 되어있어서 여기서는 그냥 바로 써도 된다.
		System.out.println(tree.toString()); //소팅하면서 넣는 것이 tree임, 순서 상관없는 것이 hash 
		//둘의 부모가 다르기 때문이다. 
		
//		System.out.println(hash.size());
//		System.out.println(tree.size()); //방 갯수 역시 3개다. 
	
	}
}






