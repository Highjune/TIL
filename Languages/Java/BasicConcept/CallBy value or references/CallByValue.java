public class CallByValue {
public static void main(String[] args) {
//callbyvalue�� �� �����̸�, �� ����� ������ �ʴ´�. ������ 2��. callbyvalue�� ġ������ ����.���� ������ �� ���ٴ� �� 
//original�� num�� ������ �ٸ���.	
	
	int original = 500;
	System.out.println("Before call");
	System.out.println("Original = " + original);
	CallByValue cbv = new CallByValue(); //���� ������ �ּҰ� ����� �� �ּҷ� �����ϴ� ���� ���
	cbv.change(original);
//	original = cbv.change(original); //�̷��� �ϸ� ���� �ٲ�� �� �� ������, return �� 1���ۿ� �� �ȴ�.
	System.out.println("After call");
	System.out.println("original = " + original);
	
}

	void change(int num) {//int num = original	// static�� ���� ������ �ν��Ͻ� ����(��� ����) , �޸𸮿� �ø��� �� ��(�ν��Ͻ��ǰ�) �ּҷ� ������
		num *= 100;
		System.out.println("in change() num = " + num );
//		int change(int num) {//int num = original	// static�� ���� ������ �ν��Ͻ� ����(��� ����) , �޸𸮿� �ø��� �� ��(�ν��Ͻ��ǰ�) �ּҷ� ������
//			num *= 100;
//			System.out.println("in change() num = " + num );
//			return result; //10000
	}
	}
