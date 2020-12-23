import java.util.HashSet;
import java.util.TreeSet;

//�ڹ��� ���� p579
//set
///�ڵ� Ȯ���ϱ� ����� �� ����.


//�츮�� collection�� ���� ���� : �̹� ������ ������ �ø��ų� ���̴� ��Ȳ�� ���� 
//cf) �迭�� Ư���� ������ ������ �Ǿ� �ִ� �Ϳ� ����~. 

public class SetDemo {
	public static void main(String[] args) {
		HashSet<String> hash = new HashSet<String>();
		TreeSet<String> tree = new TreeSet<String>();
		String[] array = {"������", "������", "������", "������", "������"}; //�ߺ��������� ������ �ߺ��ؼ� ����
//		hash.//add: ��� ��. remove : ����� ��. clear : �� ����� ��, ���� ����: size(length �ƴ�)
		
		for(String str : array) {
			hash.add(str);  //hash set���� ���� �� �� ? 3����.(�ߺ��� �����Ͱ� ������ ƨ��ϱ�)
			tree.add(str);
		}
		//
		
		System.out.println(hash.toString()); //hash ���� toString�� ���ʿ� ������ �Ǿ��־ ���⼭�� �׳� �ٷ� �ᵵ �ȴ�.
		System.out.println(tree.toString()); //�����ϸ鼭 �ִ� ���� tree��, ���� ������� ���� hash 
		//���� �θ� �ٸ��� �����̴�. 
		
//		System.out.println(hash.size());
//		System.out.println(tree.size()); //�� ���� ���� 3����. 
	
	}
}






