//weekable의 자식임, InterfaceDemo에서 실현

//Week클래스 만들 때 interface만들기-interface 부분- add- weekable 해서 추가
//3. Interface를 상속받는 class는 implements로 상속받는다.
//4. Interface를 상속받는 class는 반드시!! interface의 모든 추상메서드를 public으로 재정의해야 한다.

//public class extends Object Week implements Weekable  //이렇게 extends Obeject가 생략되어 있다.  Week은 Object의 자식이면서도 weekable의 자식이다.


public class Week implements Weekable {
	private int date;
	@Override
	public void set(int date) {
		this.date = date; //date는 저 위에 date다
	}
	

	@Override
	public int get() {
		return this.date;
	}
}





