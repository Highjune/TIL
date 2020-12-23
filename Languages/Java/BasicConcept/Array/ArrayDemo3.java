//참조변수
public class ArrayDemo3 {
	public static void main(String[] args) {
		Car sonata = new Car();
		sonata.name = "Sonata"; 
		sonata.price = 25_000_000;
		
		Car carnival = new Car();
		carnival.name = "Carnival"; 
		carnival.price=30_000_000;  // name은 멤버변수
	
 		
//		Car을 만드는 것이 아니라, Car라는 자동차가 들어가야될 array를 만든것
		Car[] array;  //선언 
		array = new Car[2];  //생성
		
		array[0] = new Car(); 
		array[0].name = "Sonata"; 
		array[0].price = 25_000_000;
				
		array[1] = new Car();
		array[1].name = "Carnival";
		array[1].price = 30_000_000;
		
		for(int i = 0 ; i<array.length ; i++) {
			System.out.printf("이름 = %s, 가격=%d\n", array[i].name, array[i].price);
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



