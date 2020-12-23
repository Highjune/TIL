
public class StaticDemo2 {
	int count; 	//member variable
	final int SU; //member constant
	static int age; //static variable
	static final String NAME; 	// static constant
	public StaticDemo2() { //Constructor
		count = 24;
		SU = 100; 
	}
	//멤버변수, 멤버상수 초기화는 생성자가 초기화 한다.
	
	//그러면 static 변수는 누가 초기화? 그것이 바로 static initialization block이 한다.
	static { //static initialization block  . 앞에 static안 붙이면 initialization block -> 사실 거의 쓰는 경우가 없다.
		age = 34; NAME = "SALLY";  //age의 값을 바꿀 수 없다. 메모리에 올라올 때 딱 처음 1번(메인보다 먼저). 왜? 이름이 없으니까! 
	//class는 처음에 메모리 올라갈 때 처음 딱 한 번 올라간다. 메인(static)이 접근~
	}
	
	
	public static void main(String[] args) {
		
	}
	
}
