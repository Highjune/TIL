package test;

public class KeyboardToStringExample {
	public static void main(String[] args) throws Exception{
		// 읽은 바이트를 저장하기 위한 배열 생성
		byte[] bytes = new byte[100]; 
		
		System.out.println("입력 : ");
		//배열에 읽은 바이트를 저장하고 읽은 바이트 수를 리턴
		//System.in.read() 메소드는 키보드에서 입력한 내용을 매개값으로 주어진 바이트 배열에 저장하고 읽은 바이트 수를 리턴한다. 
		//예를 들어 Hello 를 입력하고 enter를 눌렀다면 Hello + 캐리지리턴(\r) + 라인피드(\n)의 코드값이 바이트 배열에 저장되고 총 7개의 바이트를 읽었기 때문에 7을 리턴한다.
		int readByteNo = System.in.read(bytes); 
		
		//배열을 문자열로 변환
		String str = new String(bytes, 0, readByteNo-2); // -2를 한 이유는 캐리지리턴(\r)+라인피드(\n) 부분은 문자열로 만들 필요가 없기 때문
		System.out.println(str);
		
	}
}
