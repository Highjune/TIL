//GenericDemo Ŭ������ �Բ�
//Ư�� Ÿ��(ex. int)���� ���ѵ� Ŭ������ ���������� ������ش�.

public class Test<T> {
//	private int value;
	private T value; //T�� type T, �ƹ��ų� �ص� ����
	
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
