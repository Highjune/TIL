/*
 * static 용법 (p344)
 * 1. static variable : 공유변수(Shared Variable)
 * 2. static method : 주소없이 메소드 접근하려고
 * 3. static initialization block
 * 4. static class - inner class에만 쓸 수 있다.
 *		//따로 존재하는 것에는 static을 사용할 수 없다.
 */

//1. static variable : 공유변수(shared variable)
public class StaticDemo {
	public static void main(String[] args) {
		Lion[] array = new Lion[5]; //Lion을 만든 것이 아니라 Lion의 주소를 적을 수첩을 만든 것이다.
		for(int i= 0; i <array.length ; i++) 
			array[i] = new Lion(); //라이언 생성자를 5번 호출
		for(Lion lion : array) 
			lion.display();
	}
}


class Lion{
	private int count; // member variable
	private static int cnt; // static variable
	public Lion() {  
//		count++;	cnt = count; // count는 매 인스턴스마다 초기화 되므로 1/1 1/1 처럼 똑같이 나옴.
		cnt++;		count = cnt; // 위에서 array[i] = new Lion(); 생성될때마다 cnt가 1씩 올라가면서 count에 넣고, cnt는 최종적으로 5가 되어있다. 그 뒤에 찍는 것이므로  1/5 2/5 3/5 4/5 5/5로 나온다.
//		cnt++;		count++;	// cnt는 매번 초기화, count는 계속 저장되어있으므로 최종적으로 5가 되어있는 상태에서 찍으니, 1/5 1/5 1/5 ~ 
	}
	public void display() {
		System.out.printf("count = %d, cnt = %d\n", count, cnt);
	}
}