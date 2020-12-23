
//////////////
//추상메소드
//메소드- > 추상 메소드가 되면 자신이 속한 클래스는 반드시 추상이 될수밖에 없다.
//API중에서 어떠한 클래스가 추상이라면, 일단 그 클래스는 new로 못 만들고, 그 자식을 통해서 new를 만들어야 한다.
//그리고 자신이 가지고 있는 100가지 메소드 중에 1가지라도 추상이라면 자신도 추상이 되어야 한다.


public class Abstract2 {
	public static void main(String[] args) {
		Birds buz = new Sparow(); //Birds가 추상이므로 new로 못 만들기 때문에 그 Birds의 자식을 통해서 만든다.
		buz.display();
		
	}
}

abstract class Birds{   //밑의 display()앞에 abstract가 붙었기 때문에 추상메소드를 포함하는 클래스도 반드시 abstract이 붙어야 되서 붙는다.
	int numOfWings = 2;
	public abstract void display(); //메소드에서는 {}가 없는 것을 추상메소드 라고 한다. 즉, 구현부가 없으므로
}

class Sparow extends Birds{
	//부모의 메소드가 추상메소드면 자식은 반드시!! 재정의 해야 된다.오버라이딩을 안하면 안된다.
	public void display() {
		System.out.println("자식에서 구현했음.");  //
	}
}




