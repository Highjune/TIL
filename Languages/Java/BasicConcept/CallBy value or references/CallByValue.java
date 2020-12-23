public class CallByValue {
public static void main(String[] args) {
//callbyvalue는 값 복사이며, 값 복사는 변하지 않는다. 공간이 2개. callbyvalue의 치명적인 단점.값을 복사할 수 없다는 것 
//original과 num은 공간이 다르다.	
	
	int original = 500;
	System.out.println("Before call");
	System.out.println("Original = " + original);
	CallByValue cbv = new CallByValue(); //집을 지으면 주소가 생기고 그 주소로 접근하는 것이 멤버
	cbv.change(original);
//	original = cbv.change(original); //이렇게 하면 값을 바뀌게 할 수 있지만, return 이 1개밖에 안 된다.
	System.out.println("After call");
	System.out.println("original = " + original);
	
}

	void change(int num) {//int num = original	// static이 없기 때문에 인스턴스 변수(멤버 변수) , 메모리에 올리고 난 후(인스턴스되고) 주소로 ㅈ접근
		num *= 100;
		System.out.println("in change() num = " + num );
//		int change(int num) {//int num = original	// static이 없기 때문에 인스턴스 변수(멤버 변수) , 메모리에 올리고 난 후(인스턴스되고) 주소로 ㅈ접근
//			num *= 100;
//			System.out.println("in change() num = " + num );
//			return result; //10000
	}
	}
