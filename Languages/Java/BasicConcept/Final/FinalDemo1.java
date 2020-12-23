/*
 *final method : override 금지
 * 내가 어떤 메서드 쓸 떄 누구도 못 건드리게 하고 싶으면 final붙이면 된다.
 * 
 */


//public class FinalDemo1 {
//	public static void main(String[] args) {
//		Bumo bumo = new Jasik(); bumo.display();
//	}
//	
//}
//
//class Bumo{
//	public final void display() {System.out.println("나는 부모의 메소드");} //final해버리면 재정의 할 수 없다. 그래서 자식에서도 재정의 할 수 없다.
//}
//
//class Jasik extends Bumo{
//	@Override
//	public void display() {System.out.println("나는 자식의 메소드");}   //오버라이딩이 안되었을 때는 오버로딩하면 된다. 안에 파라미터 바꾸면 또 될 것임
//}

///final class가 되면 그 안의 메소드, 변수 등 모든 것이 final이 된다.


	
public class FinalDemo1 {
	public static void main(String[] args) {
		Bumo bumo = new Jasik();  //안됨. Bumo가 final클래스라서 부모자식간의 관계가 아니니까.
		bumo.display();
	}
}


final class Bumo{  //final class를 붙이면 자식을 낳을 수 없다. 즉 자식에서 extends할 수 없다. 
	public final void display() {System.out.println("나는 부모의 메소드");} 
	//final해버리면 재정의 할 수 없다. 그래서 자식에서도 재정의 할 수 없다.
}

class Jasik extends Bumo{  //에러남(부모가 final이라서 자식 안됨)
	@Override
	public void display() {System.out.println("나는 자식의 메소드");}   
}


