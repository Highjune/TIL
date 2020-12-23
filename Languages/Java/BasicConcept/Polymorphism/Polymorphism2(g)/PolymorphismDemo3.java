//자바의 정석 p370


//public class Polymorphism {
//	public static void main(String[] args) {
////		Dog[] array = new Dog[3]
//		Mammal [] array =new Mammal[4]; //이 안에 포유류를 다 넣을 수 있다.
//		//==> Heterogeneous Collection
//		array[0] = new Dog();
//		array[1] = new Cat();
//		array[2] = new Korean();
//		array[3] = new American();
//		for(Mammal m : array) 
//			m.saySomething();
//		//종류가 다른 saySomething을 하는데 알고보니 부모가 다 같음.
//		//배열에 각각 다 같은 타입이 들어간 것이 아니다.
//		//각각 방에 다른 종류들이 들어간다.
//		//대신에 그 배열은 부모로 설정해야 된다.****
//		//각각의 방에는 다 자식들이 들어간다.
//	}
//}

///////////////////////////////

//public class PolymorphismDemo3 {
//	public static void main(String[] args) {
//		Object[] array = {  
//				90, 89.5, false, 'A', new Sonata("현대 소나타"), new Dog(),				
//				"Hello, World"
//				//이렇게 다 담을 수 있는 이유는 모두다 Object의 자식이라서!!**
//		};
//		print(array);		
//	}
//	
//	static void print(Object[] array) {
//		for(Object obj : array) 
//			System.out.println(obj); //이렇게 찍으면 다 잘 나오는데, 소나타와 개는 이상하게 나옴. 제대로 나오게 하려면 toString을 재정의 해야 된다.	
//	}
//}

/////////////////////

public class PolymorphismDemo3 {
	public static void main(String[] args) {
		Object[] array =   
				{90, 89.5, false, 'A', new Sonata("현대 소나타"), new Dog(), "Hello, World"};
				//이렇게 다 담을 수 있는 이유는 모두다 Object의 자식이라서!	
		print(array);		
	}
	
	
	static void print(Object[] array) {
		for(Object obj : array) { //이렇게 Object으로 배열을 만들면 모든 것을 다 넣을 수 있다. cf) Object배열을 Vector라고 한다.
			if(obj instanceof Sonata) {
//				Sonata sonata = (Sonata)obj;
//				System.out.println(sonata.getName()); 
				System.out.println(((Sonata)obj).getName());   //여기서 sonata는 null이 나오는데 이름을 준 적이 없다. 그래서 기본값 null
				//obj를 sonata로 강제형변환 것의 getName()  // ((Sonata)obj) 에서 큰 ()를 해준 이유는 . 보다 먼저 연산하게 하려고! 안하면 .이 먼저 연산된다.
			}
			else if(obj instanceof Dog) {
				((Dog)obj).saySomething(); //이렇게 강제형변환 해야 제대로 나온다.				
			}
			else System.out.println(obj);	
		}
	}
}

//위처럼 막 넣는것은 상관없다. 그런데 꺼낼 때는 그것의 원래 형태를 알아야 된다. 그래서 instanceof 를 쓴 것임.
