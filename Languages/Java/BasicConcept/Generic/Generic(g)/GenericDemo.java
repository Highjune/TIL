
public class GenericDemo {
	public static void main(String[] args) {
//		Test t = new Test(89.5);
		Test <Integer> t = new Test<Integer>(5);
		System.out.printf("%d\n", t.getValue());
		
		Test <Double> t1 = new Test<Double>(89.5);
		System.out.printf("%.1f\n", t1.getValue());
		
		Test <String> t2 = new Test<String>("Hello");
		System.out.printf("%s\n", t2.getValue());
//		t2.setValue(5); // String으로 라벨 붙여놨으니까 숫자 안됨.		
		
/* 예전에는 제너릭 말고 object라는 것이 있었다. 지금은 노노
 * Object [] array = {new java.util.Scanner(System.in), new String("Hello"),
 * 								5,
 * 								89.5,
 * 								Math.PI};
 * System.out.printf("%s\n", array[o]);
 */
		
//		Test t = new Test("Hello");		
		
	}
}
