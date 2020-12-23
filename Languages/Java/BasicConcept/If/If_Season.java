//import java.util.Scanner;
//public class IfDemo {
//public static void main(String[] args) {
//	Scanner scan = new Scanner(System.in);  //키보드로 받음
//	System.out.println("좋아하시는 계절 : ");
//	String season = scan.next();
//	System.out.println("season = " + season);
//	
//	if(season == "spring") {
//		System.out.println("개나리, 진달래");
//	}else if(season == "summer") {
//		System.out.println("장미, 아카시아");		
//	}else if(season == "fall") {
//		System.out.println("코스모스, 백합");
//	}else {
//		System.out.println("동백, 매화");		
//	}
//	}
//}
//////////위에서의 logic 에러는 왜 발생? season 에는 주소가 저장되어있으니까 값을 비교해도 안된다. 그래서 문자열을 비교할 때는 == 를 쓰면 안된다. ==은 값을 비교할 때 값
////season은 주소이며, spring, summer, fall은 다 값임.

//그래서 아래와 같이 한다.(equals함수 씀)

//import java.util.Scanner;
//public class IfDemo {
//public static void main(String[] args) {
//	Scanner scan = new Scanner(System.in);  //키보드로 받음
//	System.out.println("좋아하시는 계절 : ");
//	String season = scan.next();
//	System.out.println("season = " + season);
//	
//	if(season.equals("spring")) {                      //season이라는 곳의 값이 spring? 그런데 equals란 함수는 맞으면 true, 틀리면 false를 반환하는다. 문자열의 비교는 equals라는 메소드함수를 쓴다.
//		System.out.println("개나리, 진달래");
//	}else if(season.equals("summer")) {
//		System.out.println("장미, 아카시아");		
//	}else if(season.equals("fall")) {
//		System.out.println("코스모스, 백합");
//	}else if(season.equals("winter")) {
//		System.out.println("동백, 매화");		
//	}
//	}
//}
///위의 것을 switch 문으로 ---------------------------------------------------------------------------
import java.util.Scanner;
public class If_Season {
public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);  //키보드로 받음
	System.out.println("좋아하시는 계절 : ");
	String season = scan.next();
	System.out.println("season = " + season);
	switch(season) {
	case "spring":
		System.out.println("개나리, 진달래"); break;
	case "summer":
		System.out.println("장미, 아카시아"); break;
	case "fall":
		System.out.println("코스모스, 백합"); break;
	case "winter":
		System.out.println("동백, 매화"); break;
				
}
}
}







