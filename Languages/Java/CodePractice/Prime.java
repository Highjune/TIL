// * 2. 2���� 50���� �Ҽ�(prime number)����ϱ�
//�ٽ� ����

//������ ��
public class Prime {
	public static void main(String[] args) {
		for(int i = 2; i <=50 ; i++){
			if(isPrime(i)) System.out.printf("%d\t", i);
				
			}
		}
	static boolean isPrime(int su) {
		int i;
		for(i = 2; i<su ;i++) {
			if(su%i == 0 )
				break; // �ڱ��ڽ�-1���� �߿��� �ڽ��� ���� �� �ִ� ���� ������ -> true -> break �Ǿ ����
			}
		if(i == su)return true;
		else return false;
			//
	}
	}
