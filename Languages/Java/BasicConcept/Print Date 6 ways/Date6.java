import java.util.Date;

//��¥�� ǥ���ϴ� ���6
//printf
//%t�� �̿���. (java.formatter ���� ����) cf) format�Լ��� ������ formtter class���� ã��
//%t�ڿ� H, K, l, S ���� ���̸� ���ϴ� �ð� �� � ���� ����� ���� �� ����
public class Date6 {
	public static void main(String[] args) {
//		System.out.printf("������ %tl�� %tM�� %tS���Դϴ�.", new Date(), new Date(), new Date()); //�̷��� ������ ���絵 ������ �Ʒ��� ���� new Date() 1���� �� ���� �ִ�.
//		System.out.printf("������ %1$tl�� %1$tM�� %1$tS���Դϴ�.", new Date()); //1$�� �ڿ� �Ķ���� �߿��� ù��° ���� �����Ѵٴ� ��. ����� 1���� �־ �ȴ�.
		
		
//		System.out.printf("������ %T", new Date());//�빮�� T�� ��, ��, �ʸ� ��Ʈ�� �� ���� �ִ�.
		
		//���� ���� String���� �ٲ� ��
		String now = String.format("������ %T", new Date());
		System.out.println(now);
		
	}
}
