public class Cast {
	public static void main(String[] args) {
		Test t = new Test();
		Demo d = new Demo();
//		t = (Test)d; // �̷��� �ȵȴ�. ��ü������ ����ȯ�� �ȵȴ�. �̰��� ����. ������ ����ȯ�� �ȵǰ� �ڵ� ����ȯ�� �ȵȴ�.
		//��ü�� ����ȯ�� �Ƿ��� �θ� �ڽ��̾�� �Ѵ�!!!! 
	}
}

class Test{}
class Demo{}