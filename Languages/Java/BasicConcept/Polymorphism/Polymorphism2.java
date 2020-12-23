//다형성 할 때 주의해야 할 부분들
public class Polymorphism2 {
	public static void main(String[] args) {
		Bumo bumo = new Jasik();
		bumo.print();
		bumo.display();
//		bumo.show(); // 에러!!! 	자식의 고유(자신만 갖고 있는 것)에만 접근이 가능하다.
		
		//되는 것 : 부모는 자식이 부모의 재정의 된 메소드만 접근 가능하다. 그 외에는 접근이 안된다!!!!!! (p355)
		
	}
}

class Bumo{
	public void display() {System.out.println("부모의 display()");}
	public void print() {System.out.println("부모의 print()");}
	
	
	
}
class Jasik extends Bumo{
	public void show() {System.out.println("자식의 show()");}
	@Override
	public void display() {System.out.println("자식의 display()");} //부모 것 재정의 override

}

