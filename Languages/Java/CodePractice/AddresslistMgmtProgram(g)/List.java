import java.util.ArrayList;

//��ü�˻�

public class List {
	private ArrayList<Person> list;

	public List(ArrayList<Person> list) { //������
		this.list = list;
	}

	public void printList() {
		if (this.list != null && this.list.size() > 0) { //�ȿ� �����Ͱ� �־�� ��ü ����� ������ �� �����Ƿ�. ���� null�� �ƴϰ� �ȿ� ������ 0�̶��� ������ �� �����Ƿ�.
			System.out.println("[ ��ü ȸ�� ��� ]");
			for (Person p : this.list) {
				System.out.println(p);
			}
		} else {
			System.out.println("No Data.");
		}
	}
}
