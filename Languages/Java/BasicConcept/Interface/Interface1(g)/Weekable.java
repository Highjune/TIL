//week의 부모임, InterfaceDemo실현

//interface 2가지 용법
//1. interface에는 변수를 가질 수 없다. public static final이 생략된 상수만 가능하고 반드시 초기화해야 한다.
//2. interface에는 public abstract이 생략된 추상메소드만 가능하다. (100개면 100개 다 추상메소드). 메소드의 바디X
//ex) api에서 java.lang - Runnable 들어가면 메소드 1개 있는데 void run()이 있는데 이 앞에 다 public abstract이 생략되어 있다.
//앞에 public이 생략되어 있으니 자식을 만들 때도 public으로 만들어야 된다.
//나중에 JDBC(자바와 DB합치는거) 할 텐데, JDBC의 대부분이 interface다.


public interface Weekable { //interface로 만든 것임.
//	private int age; //주석못 넣음
//	private final int AGE = 1; //final은 셋팅 후 변경 못함. 대문자로 써야됨, 반드시 초기값도 줘야 한다.
	
//	public static final int AGE = 1; //이렇게 되어야 되는데 무조건 public static final이므로 앞에 생략한다.그래서 아래처럼.
//	int AGE = 1; 
	
	int SUN = 0, MON=1, TUE=2, WED=3, THU=4, FRI=5, SAT=6;  //앞에 public static final이 생략되어 있다.
	
//	void display();//메소드에서 바디가 없어야 한다.
//	protected display(); // protected도 안된다.
//	public abstract void display(); //앞에 public abstract 가 생략된다. 모든 것이 다 public 과 abstract이므로 생략.
	void set(int date); //
	int get(); //
	//여기서 set 과 get은 몸통만 구분해주고 그 자식인 week에서 제대로 정의해준다. 
	
	
}








