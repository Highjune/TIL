
public class VariableInitialize {
	static int cv = 1; //명시적 초기화
	int iv =1;		//명시적 초기화
	
	static { cv = 2; } //클래스 초기화 블럭
	{ iv = 2; }	//인스턴스 초기화 블럭 - 잘 안 씀
	
	VariableInitialize() { //생성자 
		iv = 3;
	}
}

