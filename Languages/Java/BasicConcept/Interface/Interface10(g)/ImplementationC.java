package test;

public class ImplementationC implements InterfaceC{
	
	//interfaceC를 구현했지만 인터페이스 InterfaceC는 InterfaceA와 InterfaceB를 상속받았기에 InterfaceA와 InterfaceB의 메소드를 구현해야 한다.
	
	//InterfaceA의 메소드 구현
	@Override
	public void methodA() { 
		System.out.println("ImplementationC-methodA() 실행");
	}

	//InterfaceB의 메소드 구현
	@Override
	public void methodB() {
		System.out.println("ImplementationC-methodB() 실행");
	}
	
	//InterfaceC의 메소드 구현
	@Override
	public void methodC() {
		System.out.println("ImplementationC-methodC() 실행");
	}

}
