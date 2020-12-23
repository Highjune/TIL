
public class StaticBlockTest {
	static int[] arr = new int[10]; //명시적 초기화
	
	static { //static 초기화 블럭
		for(int i=0 ; i<arr.length; i++) {
			arr[i] = (int)(Math.random()*10)+1;
		}
	}
}
