
public class Polymorphism {
	public static void main(String[] args) {
		Captain cap = new Member();
		cap.display(); //자식의 것을 먼저 찾아서 실행됨
	}
}


class Captain{
	public void display() {
		System.out.println("나는 따르라(captain)");
	}
}

class Member extends Captain{
	@Override
	public void display() {
		System.out.println("저는 따라갈게요(member)");
	}
	
}
