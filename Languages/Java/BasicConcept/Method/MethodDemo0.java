
//ó�� ��, ���� �� �ֱ�
public class MethodDemo0 {
	public static void main(String[] args) {
	
//	MethodDemo0.calcSum();  //�� �����س��µ� �ƹ��͵� �� ������ ����
	MethodDemo0.calcSum(50, 60);
		calcSum(1, 3);      //������ ȣ���Ѵٰ� �ؼ� call by value
		calcSum(20, 10);
	}

	static void calcSum(int start, int last) 	{       //int num = 50
		int sum = 0;
		for(int i=start ; i <=last ; i++) {
			sum += i;
		}
		System.out.println(start + "����" + last + "������ ����" + sum + "�Դϴ�.");
	//	return; �� �����Ǿ� ����. return�� ���ư��ڶ�� ��. return�ڿ� �ƹ��͵� ������ void�� ��. 
	//	return �ڿ� ������ ������ return Ÿ��
	}
}
///////////////�̷��� �Ϸ��� ������ ���ȭ��� �Ѵ�.




