/* �ڹ��� ���� p344
 * 
 * 1. final variable ==> constant
 * 2. final method ==
 * 3. final class
 * 
 *cf) abstract�� class, method�տ��� �����ѵ�, ���� �տ��� �� ����.
 *
 *
 *
 */
///final 3������ �ִ�. constant ����� final. ���� �ٲ� �� ����. ��ġ�� ���� 3����.(member class local)
public class FinalDemo {
	final int NUM = 5; // member constant
	static final int ENG = 90; // class constant
	
	public FinalDemo(int num) { //Constructor
//		this.NUM = num; //������. �����ڰ� �������� �ʱ�ȭ. �Ͽ����� �������, �������� �����ڰ� �ʱ�ȭ ���۰��� �ʱ�ȭ
//ex) this.NUM = 10;
		
	}
	
	public static void main(String[] args) {
		{
		final int SU = 5; // local constant
//		SU = 100; //�� �ȴ�. �� �� �����Ǹ� ������ �� ����.
		}
//		System.out.println(SU);  //�ȵ�. ��������� ��������� �������.
	}	
	static void change(final int su) {  //�̰͵� �������, ���� �ѱ� �� �״�� ���~��� ���忡�� ���� ����.
//		su *= 100; //������
		
	}
	
}