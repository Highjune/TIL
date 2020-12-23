//


//public class VariableArgumentDemo {
//	public static void main(String[] args) {
//		display(6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8);
//	}
//	static void display(int ... array) {		
////		System.out.println(array.length);
//		for(int su : array) System.out.printf("%d\t", su);
//		
//	}
//}
///다양한 형을 넘겨줄 때

public class VariableArgumentDemo {          
	public static void main(String[] args) {
		display('A', 89.5, true, 34);

	}
	static void display(Object ... array) {
		System.out.println(array.length);
		for(Object su : array) 
			System.out.print(su + "\t");
	}
}








