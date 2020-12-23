/*
 * 객체의 형변환
 * 1. 자식 --> 부모 : 자동/강제 형변환 모두 가능, 항상 성공
 * 2. 부모 --> 자식 : 강제형변환 가능하며, 항상 성공하지는 않는다. 
 * 
 */

public class Cast4 {
	public static void main(String[] args) {
//		Test t = new Test();
//		Demo d = new Demo();
//		t = d;
//		원래는 위 세줄처럼 해야 되지만, 형변환이 가능하기 때문에 아래 한줄로 가능
		
		Test t = new Demo(); //그래서 이렇게 가능하다 // 선언형은 부모형, 실제형은 자식형이 된다.
		t = new Demo(); 		//선언할 때는 부모형이지만 주소는 자식의 것을 가진다
		
	}
}
class Test{}
class Demo extends Test{}

