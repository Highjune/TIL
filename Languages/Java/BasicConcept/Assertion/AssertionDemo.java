//�����ڰ� �ڽ��� �ڵ带 �����ϴ� ���


public class AssertionDemo {
	public static void main(String[] args) {
		int sum = 0;
		int i = 0; //for���� ������ i�� ����ֵ��� �ۿ� ����
		for(i = 1; i<=50 ; i++) {
			sum+=1;
		}
		
		assert (i == 51) : "���� ����"; //i==51�̸�(���� ������ 50�� ���Ҵٴ� ��) ���, �ƴ϶�� �޼���
		assert ( sum > 50 ) : "�հ迡 ���� �߻�";
		
		System.out.println("sum = " + sum);
		}
	}
//��Ŭ������ �ϴ� ��� run  - run as - run configurations - arguments tab�� -ea �ֱ� - run



