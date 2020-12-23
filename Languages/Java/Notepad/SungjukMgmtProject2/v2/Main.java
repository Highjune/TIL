
public class Main {
	public static void main(String[] args) {
//		Student June1 = new Student();
//		June1.input();
//		June1.calc();
//		June1.output();
//		
//		Student june2 = new Student();
//		june2.input();
//		june2.calc();
//		june2.output();
		
		Student[] array = new Student[3];
		System.out.println(array.length);
		for(int i = 0 ; i<=array.length ; i++) {
			array[i]=new Student();
			array[i].input();
			array[i].calc();
			array[i].output();			
		}		
	}
		
}
