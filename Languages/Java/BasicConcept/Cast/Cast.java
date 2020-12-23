public class Cast {
	public static void main(String[] args) {
		Test t = new Test();
		Demo d = new Demo();
//		t = (Test)d; // 이렇게 안된다. 객체끼리는 형변환이 안된다. 이것이 정상. 강제적 형변환도 안되고 자동 형변환도 안된다.
		//객체가 형변환이 되려면 부모 자식이어야 한다!!!! 
	}
}

class Test{}
class Demo{}