
public class VariableInitialize {
	static int cv = 1; //����� �ʱ�ȭ
	int iv =1;		//����� �ʱ�ȭ
	
	static { cv = 2; } //Ŭ���� �ʱ�ȭ ��
	{ iv = 2; }	//�ν��Ͻ� �ʱ�ȭ �� - �� �� ��
	
	VariableInitialize() { //������ 
		iv = 3;
	}
}

