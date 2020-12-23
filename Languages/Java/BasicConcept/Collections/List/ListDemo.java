//자료구조임.데이터를 stack방식으로 저장할 것인가, 아니면 queue로 할 것인가. 

import java.util.Vector;

public class ListDemo {
	public static void main(String[] args) {
		
//		Queue<String> queue = new LinkedList<String>();
//		String[] array = {"한지민", "김지민", "박지민", "박소현", "허강준"};
//		for(String str : array) queue.offer(str);
////		System.out.println(queue.peek());  //queue는 stack과 다르다. queue는 파이프니까 먼저 들어온 것이 먼저 나간다.
//		System.out.println(queue.poll());  //poll도 queue와 똑같다. 한지민
//		System.out.println(queue.poll());  //poll도 queue와 똑같다. 김지민
//		System.out.println(queue.poll());  //poll도 queue와 똑같다. 박지민
//		System.out.println(queue.poll());  //poll도 queue와 똑같다. 박소현
//		System.out.println(queue.poll());  //poll도 queue와 똑같다. 허강준
//		System.out.println(queue.poll());  //poll도 queue와 똑같다. //여기서부터 null로 나온다. 이미 다 꺼냈으니까.
//		System.out.println(queue.poll());  //poll도 queue와 똑같다.
//		System.out.println(queue.poll());  //poll도 queue와 똑같다.

			//stack은 push pop, collection은 add remove, queue는 offer poll
		
//		LinkedList<Object> obj = new LinkedList<String>(); 이런 형변환이 안된다는 것이지 위처럼은 가능하다.
		
//		ArrayList<String> list = new ArrayList<String>();
//		String[] array = {"한지민", "김지민", "박지민", "김지민", "한지민"}; // 0 1 2 3 4 
//		for(String str : array) list.add(str);  // 담을때는 add. 뽑을 때는 get
//		System.out.println(list.get(2));
		
		///Vector - arraylist보다 훨씬 더 효율적임
		///vector 생성자에의 파라미터중 capacityincrement는 증가사이즈임. 방이 늘어날때마다 증가사이즈만큼 생성됨.
		
		//ex)사원수가 5명 이하입니다 - 배열로도 만들수 있지만, 사원수 제한없다 - 배열로는 절대 불가능, 컬렉션을 쓸 수 밖에 없다.
		//
		
		Vector <String> vector = new Vector <String> (5,3); // 초기사이즈 5개, 증가사이즈 3개 . 5개가 다 찼을 때 1개가 더 들어오면 방 3개가 생성
		String[] array = {"한지민", "김지민", "박지민", "김지민", "한지민"};
		for(String str : array) vector.add(str);
		System.out.println("capacity = " + vector.capacity());
		System.out.println("size = " + vector.size());
		vector.add("이지민");
		System.out.println("capacity = " + vector.capacity()); //1명 더 들어왓는데 방이 3개가 늘어남.
		System.out.println("size = " + vector.size());  
		//대신 속도가 느림.
	}
}






