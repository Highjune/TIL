
//instanceof 2가지 형법 중 1가지
//부모->자식으로 형변환이 가능한지 체크가능


public class InstanceofDemo {
	public static void main(String[] args) {
		String original = "Hello, World";
		Object obj = original; //자식->부모형으로의 형변환은 항상 가능 (자동형변환 되니까 강제 형변환할 필요도 없다)		

		if(obj instanceof String) {
		String another = (String)obj; 
		System.out.println(another);  //부모-->자식으로 가능한 경우임(불가능한 경우도 있는데 항상 이렇게 검사!)
		}else {
			System.out.println("불가");  //불가 안 찍을 것임. 왜냐하면 되니까!
		}
	}
}
