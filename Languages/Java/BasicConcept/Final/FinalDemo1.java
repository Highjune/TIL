/*
 *final method : override ����
 * ���� � �޼��� �� �� ������ �� �ǵ帮�� �ϰ� ������ final���̸� �ȴ�.
 * 
 */


//public class FinalDemo1 {
//	public static void main(String[] args) {
//		Bumo bumo = new Jasik(); bumo.display();
//	}
//	
//}
//
//class Bumo{
//	public final void display() {System.out.println("���� �θ��� �޼ҵ�");} //final�ع����� ������ �� �� ����. �׷��� �ڽĿ����� ������ �� �� ����.
//}
//
//class Jasik extends Bumo{
//	@Override
//	public void display() {System.out.println("���� �ڽ��� �޼ҵ�");}   //�������̵��� �ȵǾ��� ���� �����ε��ϸ� �ȴ�. �ȿ� �Ķ���� �ٲٸ� �� �� ����
//}

///final class�� �Ǹ� �� ���� �޼ҵ�, ���� �� ��� ���� final�� �ȴ�.


	
public class FinalDemo1 {
	public static void main(String[] args) {
		Bumo bumo = new Jasik();  //�ȵ�. Bumo�� finalŬ������ �θ��ڽİ��� ���谡 �ƴϴϱ�.
		bumo.display();
	}
}


final class Bumo{  //final class�� ���̸� �ڽ��� ���� �� ����. �� �ڽĿ��� extends�� �� ����. 
	public final void display() {System.out.println("���� �θ��� �޼ҵ�");} 
	//final�ع����� ������ �� �� ����. �׷��� �ڽĿ����� ������ �� �� ����.
}

class Jasik extends Bumo{  //������(�θ� final�̶� �ڽ� �ȵ�)
	@Override
	public void display() {System.out.println("���� �ڽ��� �޼ҵ�");}   
}


