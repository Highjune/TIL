
public class Main {
	public static void main(String[] args) {
//		Student kangjune = new Student();
//		kangjune.input();
//		kangjune.calc();
//		kangjune.output();
//		
//		Student hye = new Student();
//		hye.input();
//		hye.calc();
//		hye.output();
		
		Student[] array = new Student[3];
		
		for(int i=1; i <= array.length ;i++) {
			array[i] = new Student();
			array[i].input();
			array[i].calc();
			array[i].output();		
		}
		
	}
}
