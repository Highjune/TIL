package test;

public class Example {
	public static void main(String[] args) {
		ImplementationC impl = new ImplementationC();
		
		InterfaceA ia = impl;
		ia.methodA();	// InterfaceA의 변수인 ia는 methodA()만 호출 가능. 리모콘에 버튼이 methodA()밖에 없으므로
		System.out.println(); 
		
		InterfaceB ib = impl;
		ib.methodB();	// Interfaceb의 변수인 ib는 methodB()만 호출 가능. 리모콘에 버튼이 methodB()밖에 없으므로
		System.out.println();
		
		InterfaceC ic = impl;
		// InterfaceC 변수는 methodA(), methodB(), methodC() 모두 호출 가능
		ic.methodA();	
		ic.methodB();	
		ic.methodC();	
		

		
	}
}
