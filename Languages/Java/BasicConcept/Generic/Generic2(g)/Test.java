//GenericDemo 클래스와 함께


//public class Test <T>{
//	private T value;
//	public Test(T value) {this.value = value;}
//	public void setValue(T value) {this.value = value;}
//	public T getValue() {return this.value;}
//	
//	//이렇게 모든 T가 다 가능할수도 있기에 제한을 두기로 했다.
//	//API보면 숫자형은 다 number의 자식.	
//}


//이제 제한을 두기 시작.
public class Test <T extends Number>{  //==>number만 받겠다는 제한!
//public class Test <T super Number>{  //==>number의 부모를 받겠다.
//public class Test <? super Number>{  //==>number의 부모이거나 자식~
	private T value;
	public Test(T value) {this.value = value;}
	public void setValue(T value) {this.value = value;}
	public T getValue() {return this.value;}

}











