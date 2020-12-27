package practice;

public class SystemInReadExample {
	public static void main(String[] args) throws Exception {
		int keyCode;
		
		keyCode = System.in.read();
		System.out.println("KeyCode : " + keyCode);

		keyCode = System.in.read();
		System.out.println("KeyCode : " + keyCode);
		
		keyCode = System.in.read();
		System.out.println("KeyCode : " + keyCode);
		
	} 
}
