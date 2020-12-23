import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//Iterator 자바의 정석 p614. 벌크로 뽑을 때 
public class EnumerationDemo {
	public static void main(String[] args) {
		//벌크로 들고올 떄 
		Stack<String> stack = new Stack<String>();
		String [] array = {"한지민", "김지민", "박지민", "이지민", "홍지민"};
		
		for(String str : array)  stack.push(str); //stack으로 넣었음
		Enumeration<String> enums = stack.elements();
		while(enums.hasMoreElements()) 
			System.out.println(enums.nextElement());
			//컬렉션의 타입(stack, queue 등) 과는 무관하게 벌크로 들고온다.
		System.out.println("-----------");
		
		Queue<String> queue = new LinkedList<String>();
		for(String str : array)  queue.offer(str);
		Iterator<String> iters = queue.iterator();
		while(iters.hasNext()) System.out.println(iters.next());
	}
}


