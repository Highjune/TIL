//1번째 방법. 보통 우린 이 방법으로 많이 쓴다.
import kr.co.sist.libs.HR.Student;
 //처음에 import kr. 까지만 쳤는데 에러이유. eclipse는 kr이 어딨는지 모르기 때문에 그래서 jar배포!!

//2번째 방법(전체 다 땡겨오는 거 ~. *)
//import kr.co.sist.libs.factory.*;  //그런데 이렇게 하면 다 떙겨온다.
import java.lang.System;
import static java.lang.System.out; //까지 쓰면 System.out.println에서 out.println 으로 써도 된다.
import java.lang.String;
//import java.lang.Math;
import static java.lang.Math.random; //까지 쓰면 Math.random()에서 random() 써도 된다.


public class MainClass {
	public static void main(String[] args) {
		int rand = (int)(Math.random()*6 +1);
//		System.out.println("rand = " + rand);
		out.println("rand = " + rand); //import static java.lang.System.out; 위에서 이거 썼음.
		
//		Student sally = new Student();
//		Product ballpen = new Product();
		
//3번째 방법(모든 경로 다 ~). 클래스가 어느 패키지에서 온 건지 확실하게 알지만 ! 너무 길다
//		kr.co.sist.libs.factory.Product ballpen = new kr.co.sist.libs.factory.Product();
		
		static double random() {
			double 
		}
		
		
		
	}
	
	
}
