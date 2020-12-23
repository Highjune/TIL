
//참조변수
public class ArrayDemo4 {
	public static void main(String[] args) {
		student [] array; //선언
		//array = new int[] {4, 5};
		array = new student[] {new student(), new student()};  //학생이 들어갈 배열을 만드는 것
		array[0].name = "한지민";
		array[1].name = "김지민";
		
		array[0].address = "서울시 강남구 역삼동";
		array[1].address = "부산시 해운대구 해운대동";
		for(student s : array) {    
		System.out.println(s.name);
		System.out.println(s.address);
		System.out.println("---------------");
		
		}
}
}

class Car{
	String name; 
	int price;   
	//string(참조변수) 는 4바이트의 주소, int는 4바이트의 값이니 : 1개의 Car이 만들어질 때마다 8바이트 생성 
}


class student{
	String name, address;  //한 학생당 8바이트 (각각 4바이트, 왜냐하면 각각 다 참조이므로 주소만)
//	double weight // -> 하게 되면 weight하나만 8바이트
}
