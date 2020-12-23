/*
 * 객체의 형변환
 * 1. 자식 --> 부모 : 자동/강제 형변환 모두 가능, 항상 성공
 * 2. 부모 --> 자식 : 
 * 
 */

public class Cast1 {
	public static void main(String[] args) {
		Test t = new Test();
		Demo d = new Demo();
		t = d; //자식은 부모형으로 자동형변환이 된다.
		t=(Test)d; //강제형변환은 물론 된다. 
	}
}

class Test{}
class Demo extends Test{}