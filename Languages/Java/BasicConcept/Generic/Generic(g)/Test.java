//GenericDemo 클래스와 함께
//특정 타입(ex. int)에만 국한된 클래스를 만능형으로 만들어준다.

public class Test<T> {
//	private int value;
	private T value; //T는 type T, 아무거나 해도 무관
	
	public Test(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
}
