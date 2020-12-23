public class ExceptionDemo4 {
	public static void main(String[] args) {
//		int su = Integer.parseInt("54"); // "54" --> 54  숫자형 글자를 숫자로 
//		int su = Integer.parseInt("54cm"); // cm 때문에 exception 발생
//		System.out.printf("su = %d\n", su);
//		
		
		Bumo bumo = new Jasik(); 
		bumo.display();
		
	}
}


class Bumo{
	public void display() throws java.io.FileNotFoundException{ //FileNotFoundException이 IOException(API에서 부모)보다 범위가 좁아서 에러가난다.
		System.out.println("나는 부모의 메소드");}
}

class Jasik extends Bumo{
	@Override
//	public void display() {System.out.println("나는 부모의 메소드");} //허용
	public void display() throws java.io.IOException /*, java.sql.SQLExceptioni*/ {   
		System.out.println(5/0);
//runtimeexception일 경우에는 이렇게 써도 된다user가 잘 쓰기만 하면 잘 뜬다.(자식, 부모의 관계와 무관)
//대신에 반드시 try catch 써야 되는 checked exception을 쓸 때는 부모 자식 관계 생각해야 된다.
//부모는 선언안하고 나는 선언하면 에러난다.(checked exception만) 범위, 갯수 다 생각해야 된다.
//예외갯수가 적거나(책에서는 갯수만 말함), 범위(예외 범위 안에서 부모-자식) 안에서의 범위로서도 부모가 더 넓어야 된다.
//근데 자식이 더 넓어서 에러나는 것임.
	
	}
}

