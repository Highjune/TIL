
public class CallByReference {
public static void main(String[] args) {
	Test t = new Test(); 
	t.original = 500;
	System.out.println("Before call t.original = " + t.original);
	
	CallByReference cbr = new CallByReference();
//	cbr.change(t.original); //callbyvalue임. 구별법은 뭐가 넘어가는지 !8개의 종류 중 하나면 무조건 callbyvalue**********
	
	cbr.change(t); //callbyreference(주소를 넘기게 되면). cf) String은 주소가 넘어가긴 하지만 바뀌지 않기 때문에 callbyvalue
	System.out.println("After call t.original = " + t.original);
//이렇게 주소를 복사하면 값이 바뀐다. 한 공간을 똑같이 바라보니깐.
	
}

void change(Test num) {  //Test num = t; // num은 주소
	num.original *= 100;  //num의 주소로 가서 original이라는 방에서.
	System.out.println("in change() num.original = " + num.original );

}
}
class Test{
	int original ; //멤버변수(클래스 안에 있지만 static  X), 멤버변수는 반드시 주소가 필요
}