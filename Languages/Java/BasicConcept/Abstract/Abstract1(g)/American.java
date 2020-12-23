
public class American extends Mammal {
	@Override
	public void saySomething() {
		System.out.println("Good Morning");
	}
} 


//public abstract class American extends Mammal {
//	@Override
//	public void saySomething() {
//		System.out.println("Good Morning");
//	}///여기서 몸통을 안 쓰면(에러난다) 젤 위에 class앞에 abstract도 붙여주면 된다. 대신에 new는 못 씀
//}
