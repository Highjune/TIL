
//public class InstanceofDemo1 {
//	public static void main(String[] args) {
//		Sonata sonata = new Sonata("현대 소나타");
//		remake(sonata);
//		Carnival carnival = new Carnival("기아 카니발");
//		remake(carnival); 
//		//위에서 에러가 뜬다. 타입이 다르니까. 그래서 밑에 파라미터가 다른 오버로딩 	static void remake(Carnival carnival) {carnival.repair();}해준다
//		Matiz matiz = new Matiz("쉬보레 마티즈"); 
//		remake(matiz); //에러가 뜬다. 타입이 다르니까. 그래서 밑에 파라미터가 다른 오버로딩	static void remake(Matiz matiz) {matiz.repair();} 만들어주면 에러 안 뜬다.
//			
//	}
//	static void remake(Sonata sonata) {sonata.repair();}
//	static void remake(Carnival carnival) {carnival.repair();}
//	static void remake(Matiz matiz) {matiz.repair();}
//}

//==> 이렇게 매번 메서드마다 remake를 각각 다 만들면 힘드니까 매개변수의 다형성 이용(p367)

public class InstanceofDemo1 {
	public static void main(String[] args) {
		Sonata sonata = new Sonata("현대 소나타");
		remake(sonata);
		Carnival carnival = new Carnival("기아 카니발");
		remake(carnival); //에러가 뜬다. 타입이 다르니까. 그래서 밑에 파라미터가 다른 오버로딩 	static void remake(Carnival carnival) {carnival.repair();}해준다
		Matiz matiz = new Matiz("쉬보레 마티즈"); 
		remake(matiz); //에러가 뜬다. 타입이 다르니까. 그래서 밑에 파라미터가 다른 오버로딩	static void remake(Matiz matiz) {matiz.repair();} 만들어주면 에러 안 뜬다.
			
	}
	static void remake(Car car) {car.repair();} //메소드가 하나로 끝. 오버로딩하면서 메소드를 갯수만큼 할 필요 없다. Polymorphic Parameter라고 한다.
	}

//그런데 이렇게 다형성을 또 쓰면 문제가 된다. 수리가 되느냐 안되느냐의 문제가 아니다. 원래의 모형이 뭐였는지를 모르는 것임. 그것에 맞게(차종) 부품(타이어 등)을 갈아끼울 수 있으니까
//그래서!! instanceof의 2번쨰 용법 등장


//public class InstanceofDemo1 {
//	public static void main(String[] args) {
//		Sonata sonata = new Sonata("현대 소나타");
//		remake(sonata);
//		Carnival carnival = new Carnival("기아 카니발");
//		remake(carnival); //에러가 뜬다. 타입이 다르니까. 그래서 밑에 파라미터가 다른 오버로딩 	static void remake(Carnival carnival) {carnival.repair();}해준다
//		Matiz matiz = new Matiz("쉬보레 마티즈"); 
//		remake(matiz); //에러가 뜬다. 타입이 다르니까. 그래서 밑에 파라미터가 다른 오버로딩	static void remake(Matiz matiz) {matiz.repair();} 만들어주면 에러 안 뜬다.
//			
//	}
//	static void remake(Car car) {	//Polymorphic Parameter
//		if(car instanceof Sonata) {
//			System.out.println("소나타가 수리됐습니다.");
//		}else if(car instanceof Carnival) {
//			System.out.println("카니발이 수리됐습니다.");
//		}else if(car instanceof Matiz) {
//			System.out.println("마티즈가 수리됐습니다.");
//		}
//	}
//
//}
//그러면 또 새로운 문제가 생긴다. 모든 것들을 다 instatnceof로 확인해봐야되나?
// ==> 그래서 나온 것이 제네릭




