
//�����޽��� ����ϴ� 3���� ���.

public class ExceptionDemo3 {
	public static void main(String[] args) {
		try {
			System.out.println(5/0); //�� ������ arithmeticException�� ������.
			// Exception�� �߻��ϸ� (arithmeticException)�� ������.
		}catch(Exception ex) { //ex = new artihmeticException();  ex�� �ּ��̴�!!
//			System.out.println(ex.getMessage());   //1. ���� �θ������ϰ� ��� �� (user���Դ� getMessage�� �Ѹ���)
//			System.out.println(ex);//2. ex.toString()���� Ÿ�Ա��� ���. �� �� ����������.
			
			//3. ���ϵ������ϰ�
			ex.printStackTrace();			//3. ���� �������ϰ� ���α��� ��� (�����ڿ��Դ� 2, 3���� ���ֱ�)
			
		}
	}
	
}





