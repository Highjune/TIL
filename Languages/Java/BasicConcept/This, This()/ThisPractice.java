public class ThisPractice{
	//iv앞에는 this.이 생략
	
	long a, b; // this.a, this.b ==> iv의 진짜이름
	
	ThisPractice(int a, int b) { //생성자
		//여기서는 생략불가(같은 이름이기때문에)
		//this를 붙여서 iv와 lv를 구별
		this.a = a; //this.a는 iv, a는 lv
		this.b = b;			
	}
	
	long add() {
		return a + b; // 원래는 return this.a + this.b인데 여기서는 없더라도 위에서 long a, b;로 선언해준 iv인것을 알기 때문에.
	}
	
	//static은 객체생성 없이 사용하는 것이므로 iv사용불가
	static long add(long a, long b) { //클래스 메서드(static 메서드). 매개변수 long a, long b 는 다 lv
		return a+b; //둘 다 lv임. 그래서 this.를 못 붙인다.
	}
}