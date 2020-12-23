//Student, person, employee 로 묶어서 //~상속까지 개념 공부!


//public class Main2 {
//public static void main(String[] args) {
//	
//	
//	Student chulsu = new Student("김철수", 24, "강남구 역삼동", "2019-01", 90); //부모(Person) 에 3개 상납하고 자기가 2개 가짐
//	System.out.println("철수의 정보");
//	System.out.println(chulsu); //chulsu.toString()
//	
//	System.out.println("지민의 정보");
//	Employee jimin = new Employee("한지민", 34, "부산시 해운대구", "2018-05", 250); //부모(Person) 에 3개 상납하고 자기가 2개 가짐
//	System.out.println(jimin);
//	
//			
//}
//
//}

public class Main2 {
public static void main(String[] args) {
	
	Person person; //선언
	person = new Student("김철수", 24, "강남구 역삼동", "2019-01", 90); // Person이 추상이라서 자식으로 만든다~
	//자식인 student는 부모로 형변환 가능
	System.out.println("철수의 정보");
	System.out.println(person); //chulsu.toString()
	
	System.out.println("지민의 정보");
	person = new Employee("한지민", 34, "부산시 해운대구", "2018-05", 250); // 	//자식인 Employee는 부모로 형변환 가능
	System.out.println(person);
	
	
}

}