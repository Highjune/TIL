
//instanceof 2���� ���� �� 1����
//�θ�->�ڽ����� ����ȯ�� �������� üũ����


public class InstanceofDemo {
	public static void main(String[] args) {
		String original = "Hello, World";
		Object obj = original; //�ڽ�->�θ��������� ����ȯ�� �׻� ���� (�ڵ�����ȯ �Ǵϱ� ���� ����ȯ�� �ʿ䵵 ����)		

		if(obj instanceof String) {
		String another = (String)obj; 
		System.out.println(another);  //�θ�-->�ڽ����� ������ �����(�Ұ����� ��쵵 �ִµ� �׻� �̷��� �˻�!)
		}else {
			System.out.println("�Ұ�");  //�Ұ� �� ���� ����. �ֳ��ϸ� �Ǵϱ�!
		}
	}
}
