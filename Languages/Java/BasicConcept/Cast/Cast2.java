/*
 * ��ü�� ����ȯ
 * 1. �ڽ� --> �θ� : �ڵ�/���� ����ȯ ��� ����, �׻� ����
 * 2. �θ� --> �ڽ� : ��������ȯ �����ϸ�, �׻� ���������� �ʴ´�. 
 * 
 */


public class Cast2 {
	public static void main(String[] args) {
		Test t = new Test();
		Demo d = new Demo();
//		d = t; //�θ�� �ڽ����� ����ȯ�� �� �ȴ�
		d = (Demo)t;  // ������ �ƴѵ� ��Ÿ�� �� ������ ����	
	}
}

class Test{}
class Demo extends Test{}