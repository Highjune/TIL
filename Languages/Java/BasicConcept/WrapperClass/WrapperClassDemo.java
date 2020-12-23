//자바 1.4때까지만 아래와 같이 썼음.
//public class WrapperClassDemo {
//	public static void main(String[] args) {
//		int age = 24;//primitive type이므로 stack이 있다.
//		Integer in = new Integer(age); //Wrapping, boxing//heap에 간다. heap에 간 주소를 in이 참조하고 있음.
//		//api에서 lang - integer 보면 integer의 생성자확인하면 ()안에 int들어간다
//		
//		int number = in.intValue(); //unwrapping, unboxing
//		System.out.println("number = " + number);
//		
//	}
//}


//자바 버전 업 이후로는 아래와 같이.
//Autoboxing!!!

public class WrapperClassDemo {
	public static void main(String[] args) {
		int age = 24;//primitive type이므로 stack이 있다.
		
		Integer in = age + 100; // new Integer(24+100); // autoboxing(heap에 보낼 떄 자동으로 해줌)
		//new를 안썻는데도 에러X. 버츄얼 머신이 대신해준다.
		
		int number = in;	//in.intValue();가 생략된 것임. autounboxing (stack에 넘어올 때 자동으로 해줌)
		//참조변수의 주소가 number에 들어가는 것이 아님. 
		
		
		System.out.println("number = " + number);
		
	}
}











