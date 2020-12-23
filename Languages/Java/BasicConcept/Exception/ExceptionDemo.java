
//Syntax Error => Compile Error
//Symantec Error(의미적 오류임) => Runtime Error ==> Exception.  //문법적 오류가 아님. 

//import java.util.Scanner;

//public class ExceptionDemo {
//	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		System.out.print("첫번째 숫자 : ");	
//		int first = scan.nextInt();
//		System.out.print("두번쨰 숫자 : ");
//		int second = scan.nextInt();
//		try {//exception의 가능성이 있는 곳을 try로 묶고, 그 곳을 대체하는 것이 catch
//			System.out.println(first / second);
//	}catch(Exception ex) {
//		System.out.println("에러처리했음");
//	}	
//	}
//}



//import java.util.Scanner;
//
//public class ExceptionDemo {
//	public static void main(String[] args) {
//
//		String str = "한지민";
//		System.out.println(str); //한지민
//		str = null;
//		System.out.println(str);  //null
//		
//		Car sonata = new Car(); 
//		sonata.price = 25_000_000;
//		System.out.println(sonata.price);
//		sonata = null;
//		System.out.println(sonata.price);		//NullPointerException
//	}	
//}
//
//class Car{
//	 int price;
//}
//어떠한 예외의 종류를 알고 싶다면, API 족보에서 그 부모를 보자!. Runtimeexception 이라면 unchecked exception임. 즉 try catch 안 써도 됨






//import java.util.Scanner;
//
//public class ExceptionDemo {
//	public static void main(String[] args) {
//
//		Scanner scan = new Scanner(System.in);
//		System.out.println("방을 몇개 만들까요 ? ");
//		int size = scan.nextInt();
//		int [] array = new int[size];	
//		//배열은 런타임 때 생긴다. 그런데 방의 갯수를 -로 입력하면 ! runtime exeption의 자식. 얘들은 compile할 때 오류가 발생하지 않는다.
//		System.out.println("방갯수 : " + array.length);
//		
//	}	
//	}




import java.util.Scanner;

public class ExceptionDemo {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("문자형 숫자 : ");
		String str = scan.next();// "4" --> 4 를 목적
		int su = Integer.parseInt(str);
		System.out.printf("su = %d\n", su);  //설마 유저가 잘못된 값을 넣을까? 그런데 만약 Hello를 넣으면??.... numberformat exception 이라고 뜬다.
		//그래서 API에서 numberformat 찾아서 보면 엄마가 Runtimeexception 이고 이것은 Unchecked exception 이다. 
		//즉, Runtimeexception 의 자식과 error의 자식은 모두 다 Unchecked exception.
		
	}	
	}






