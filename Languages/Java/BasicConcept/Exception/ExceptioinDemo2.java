
//public class ExceptioinDemo2 {
//	public static void main(String[] args) {
//		try {
//			System.out.println(5/0);  //exception이 발생한 것을 던지면, 밑에 기다리는 catch들이 순차적으로 ~ 
//		}catch(NullPointerException ex) {  //try 안의 타입과 catch() 안의 타입이 맞아야 된다. 안 맞으면 못 잡는다.
//			System.out.println("널입니다.");
//		}catch(NumberFormatException ex) {
//			System.out.println("NumberFormatException");
//		}catch(NegativeArraySizeException ex) {
//			System.out.println("Array가 음수사이즈");  //이까지 3가지의 exception이 못 잡았음. 타입이 달라서. 즉 catch를 많이 쓴다고 해서 꼭 좋은 것 X		
//		}catch(ArithmeticException ex) {   //여기서 잡힘. 즉 ArithmeticException 예외였음. 
//			System.out.println("내가 잡았음");
//		}
//	}
//}
//주의사항
////1. 여러개의 catch block을 사용할 떄 반드시 많이 사용할 필요 없다.
//2. 여러개의 catch block을 사용할 때는 부모 자식관계를 고려해야 한다.(위에서 부모가 잡아버리면 밑에서 못 잡으니까.)
//위는 자식 Exception, 아래는 부모 Exception 
//그래서 상속 관계를 봐야 된다

public class ExceptioinDemo2 {
	public static void main(String[] args) {
		try {
			System.out.println(5/0);  // NegativeArraySizeException의 종류임
//		}catch(RuntimeException ex) { RuntimeExxception 은 밑의 것들의 부모다. 그래서 밑은 쓸 필요가 없다. //
		}catch(NullPointerException ex) {
			System.out.println("NullPointerException.");
		}catch(RuntimeException ex) {
			System.out.println("RuntimeException.");
		}catch(Exception ex) {
			System.out.println("Exception");  //	
		}
	}
}
