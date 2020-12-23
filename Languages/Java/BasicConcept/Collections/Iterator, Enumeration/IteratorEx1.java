import java.util.*;

public class IteratorEx1 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("4");
		list.add("5");
		list.add("6");
		list.add("7");
		list.add("8");
		
		ListIterator it = list.listIterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println();
		
		while(it.hasPrevious()) {
			System.out.println(it.previous());
		}
		
		System.out.println();
		
	}
	
}
