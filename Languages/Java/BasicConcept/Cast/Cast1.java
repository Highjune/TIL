/*
 * ��ü�� ����ȯ
 * 1. �ڽ� --> �θ� : �ڵ�/���� ����ȯ ��� ����, �׻� ����
 * 2. �θ� --> �ڽ� : 
 * 
 */

public class Cast1 {
	public static void main(String[] args) {
		Test t = new Test();
		Demo d = new Demo();
		t = d; //�ڽ��� �θ������� �ڵ�����ȯ�� �ȴ�.
		t=(Test)d; //��������ȯ�� ���� �ȴ�. 
	}
}

class Test{}
class Demo extends Test{}