

//callstack 이라고 한다.
public class ExceptionDem6 {
	public static void main(String[] args) {
		a();
	}
	
	static void a() {
		try {
		b();
		}catch(Exception e) {
			System.out.println("여기서 잡았음");
		}
		
	}
	
	
	static void b() throws RuntimeException { 
		c();
	}
	static void c() throws RuntimeException {
		d();
	}
	static void d() throws RuntimeException{ //
		System.out.println(5/0);  //exception발생. d메소드가 exception을 던진다. 누구에게? 나를 호출한 애(C). 
//		C는 B에게, B는 A에게 . 각각 해결이 안되니까 던지는 것임. A는 메인에게 던짐. 메인도 해결안됨. 그러면 메인은 VM(virtual machine)에 던짐
		//그런데 exception을 중간에서 잡으면 된다. 그래서 a쯤에서 try catch를 넣은 것임.
	}
}


