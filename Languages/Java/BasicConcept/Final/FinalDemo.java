/* 자바의 정석 p344
 * 
 * 1. final variable ==> constant
 * 2. final method ==
 * 3. final class
 * 
 *cf) abstract은 class, method앞에는 가능한데, 변수 앞에는 못 쓴다.
 *
 *
 *
 */
///final 3가지가 있다. constant 만드는 final. 값을 바꿀 수 없는. 위치에 따라서 3가지.(member class local)
public class FinalDemo {
	final int NUM = 5; // member constant
	static final int ENG = 90; // class constant
	
	public FinalDemo(int num) { //Constructor
//		this.NUM = num; //에러남. 생성자가 멤버상수도 초기화. 하여간에 멤버변수, 멤버상수는 생성자가 초기화 시작값이 초기화
//ex) this.NUM = 10;
		
	}
	
	public static void main(String[] args) {
		{
		final int SU = 5; // local constant
//		SU = 100; //안 된다. 한 번 설정되면 변경할 수 없다.
		}
//		System.out.println(SU);  //안됨. 지역상수는 영역벗어나며 사라진다.
	}	
	static void change(final int su) {  //이것도 지역상수, 내가 넘긴 것 그대로 써라~라는 입장에서 쓰는 것임.
//		su *= 100; //에러남
		
	}
	
}