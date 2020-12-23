/*
 * 객체의 형변환
 * 1. 자식 --> 부모 : 자동/강제 형변환 모두 가능, 항상 성공
 * 2. 부모 --> 자식 : 강제형변환 가능하며, 항상 성공하지는 않는다. 
 * 
 */


public class Cast2 {
	public static void main(String[] args) {
		Test t = new Test();
		Demo d = new Demo();
//		d = t; //부모는 자식으로 형변환이 안 된다
		d = (Demo)t;  // 오류는 아닌데 런타임 때 오류가 난다	
	}
}

class Test{}
class Demo extends Test{}