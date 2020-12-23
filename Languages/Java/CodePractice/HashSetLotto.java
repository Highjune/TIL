import java.util.*;

//�ߺ����� �������� �ʴ� HashSet�� Ư���� �̿��ؼ� Lotto��ȣ�� �����ϴ� ��
//�ڹ��� ���� p632
public class HashSetLotto {
	public static void main(String[] args) {
		Set set = new HashSet();
		
		for (int i=0 ; set.size() < 6 ; i++) { //�ߺ��� ���� ���� �� ������ �ܼ��� �ݺ����� 6���� ������ �ȵȴ�.
			int num = (int)(Math.random()*45) + 1;
			set.add(new Integer(num));
		}
		
		List list = new LinkedList(set); //LinkedList(Collection c)
		Collections.sort(list);
		System.out.println(list);
	}	
}


