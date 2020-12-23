import java.util.ArrayList;

public class List {
	private ArrayList<Person> list;

	public List(ArrayList<Person> list) {
		this.list = list;
	}

	public void printList() {
		if (this.list != null && this.list.size() > 0) {
			System.out.println("[ ��ü ȸ�� ��� ]");
			for (Person p : this.list) {
				System.out.println(p);
			}
		} else {
			System.out.println("No Data.");
		}
	}
}
