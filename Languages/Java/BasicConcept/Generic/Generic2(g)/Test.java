//GenericDemo Ŭ������ �Բ�


//public class Test <T>{
//	private T value;
//	public Test(T value) {this.value = value;}
//	public void setValue(T value) {this.value = value;}
//	public T getValue() {return this.value;}
//	
//	//�̷��� ��� T�� �� �����Ҽ��� �ֱ⿡ ������ �α�� �ߴ�.
//	//API���� �������� �� number�� �ڽ�.	
//}


//���� ������ �α� ����.
public class Test <T extends Number>{  //==>number�� �ްڴٴ� ����!
//public class Test <T super Number>{  //==>number�� �θ� �ްڴ�.
//public class Test <? super Number>{  //==>number�� �θ��̰ų� �ڽ�~
	private T value;
	public Test(T value) {this.value = value;}
	public void setValue(T value) {this.value = value;}
	public T getValue() {return this.value;}

}











