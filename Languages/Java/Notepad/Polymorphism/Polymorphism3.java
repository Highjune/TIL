
public class Polymorphism3 {
	public static void main(String[] args) {
		Parent p = new Child();
		p.display();
		p.cleaning(); //자식이 들고 있으므로
//		p.play();  에러남. p에는 play() 버튼 자체가 없다. 그래서 불러올 수 없음.  부모는 자식이 부모의 재정의 된 메소드만 접근 가능하다. 그 외에는 접근이 안된다!!!!!!
		
	}
}


class Parent {
	public void display() {System.out.println("내가 부모다");}
	public void cleaning() {System.out.println("부모만 할 수 있는 청소");}
}

class Child extends Parent{
	@Override
	public void display() {System.out.println("난 자식인디,,,");}
	public void play() {System.out.println("자식만 놀 수 있는 청소");}
	
}
