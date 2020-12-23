//자바의 정석 p377
//추상화 (다형성의 강제화)
//자식을 낳아서 그것을 통해 객체 생성. 그래서 반드시 (실체가 있으니) 자식을 낳아야 된다. 자기자신(부모)는 실체가 없으니(추상이니까)
  
public class Abstract {
	public static void main(String[] args) {
//		Birds buz = new Birds(); 	 //하면 에러남 
		Birds buz = new Sparow(); 	 
		
		buz.display();
		
	}
}

abstract class Birds{   //abstract을 붙이면 실제로 존재하지 않기 때문에 객체 생성인 new Birds(); 자체가 안된다.
	int numOfWings = 2;
	public void display() {
		System.out.println("새가 날다.");
	}
}
class Sparow extends Birds{
		
}
