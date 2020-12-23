/*
 * static ��� (p344)
 * 1. static variable : ��������(Shared Variable)
 * 2. static method : �ּҾ��� �޼ҵ� �����Ϸ���
 * 3. static initialization block
 * 4. static class - inner class���� �� �� �ִ�.
 *		//���� �����ϴ� �Ϳ��� static�� ����� �� ����.
 */

//1. static variable : ��������(shared variable)
public class StaticDemo {
	public static void main(String[] args) {
		Lion[] array = new Lion[5]; //Lion�� ���� ���� �ƴ϶� Lion�� �ּҸ� ���� ��ø�� ���� ���̴�.
		for(int i= 0; i <array.length ; i++) 
			array[i] = new Lion(); //���̾� �����ڸ� 5�� ȣ��
		for(Lion lion : array) 
			lion.display();
	}
}


class Lion{
	private int count; // member variable
	private static int cnt; // static variable
	public Lion() {  
//		count++;	cnt = count; // count�� �� �ν��Ͻ����� �ʱ�ȭ �ǹǷ� 1/1 1/1 ó�� �Ȱ��� ����.
		cnt++;		count = cnt; // ������ array[i] = new Lion(); �����ɶ����� cnt�� 1�� �ö󰡸鼭 count�� �ְ�, cnt�� ���������� 5�� �Ǿ��ִ�. �� �ڿ� ��� ���̹Ƿ�  1/5 2/5 3/5 4/5 5/5�� ���´�.
//		cnt++;		count++;	// cnt�� �Ź� �ʱ�ȭ, count�� ��� ����Ǿ������Ƿ� ���������� 5�� �Ǿ��ִ� ���¿��� ������, 1/5 1/5 1/5 ~ 
	}
	public void display() {
		System.out.printf("count = %d, cnt = %d\n", count, cnt);
	}
}