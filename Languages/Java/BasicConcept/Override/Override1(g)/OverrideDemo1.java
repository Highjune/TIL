
//override������ ����. Point ���� equals�� �޼ҵ带 ������ �ؼ� �� ����.

public class OverrideDemo1 {
	public static void main(String[] args) {
		Point original = new Point(40, 80);
		System.out.println(original);
		Point other = new Point(40, 80);
//		System.out.println(original.equals(other));  
// 		Object�� �� ��ü�� equals�� ����� ����. equals�� �ּҺ��ϴ� ���̱� ������ original�� other�� �ּҰ� �ٸ��� false;
		System.out.println(original.equals(other));  // ���� false, �Ʒ��� true. �Ʒ��� point Ŭ�������� ������(������ ���ϰ�)�� �ڿ� ��� ��.
		//�� equals�� ���� �ּҸ� ���ϴµ� �������ؼ� �����ϴ� ������ �ٲ� ����.
	
		
		
		
}
	
	
}
