
public class StaticDemo2 {
	int count; 	//member variable
	final int SU; //member constant
	static int age; //static variable
	static final String NAME; 	// static constant
	public StaticDemo2() { //Constructor
		count = 24;
		SU = 100; 
	}
	//�������, ������ �ʱ�ȭ�� �����ڰ� �ʱ�ȭ �Ѵ�.
	
	//�׷��� static ������ ���� �ʱ�ȭ? �װ��� �ٷ� static initialization block�� �Ѵ�.
	static { //static initialization block  . �տ� static�� ���̸� initialization block -> ��� ���� ���� ��찡 ����.
		age = 34; NAME = "SALLY";  //age�� ���� �ٲ� �� ����. �޸𸮿� �ö�� �� �� ó�� 1��(���κ��� ����). ��? �̸��� �����ϱ�! 
	//class�� ó���� �޸� �ö� �� ó�� �� �� �� �ö󰣴�. ����(static)�� ����~
	}
	
	
	public static void main(String[] args) {
		
	}
	
}
