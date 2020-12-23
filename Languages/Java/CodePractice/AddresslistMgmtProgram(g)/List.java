import java.util.ArrayList;

//전체검색

public class List {
	private ArrayList<Person> list;

	public List(ArrayList<Person> list) { //생성자
		this.list = list;
	}

	public void printList() {
		if (this.list != null && this.list.size() > 0) { //안에 데이터가 있어야 전체 목록을 보여줄 수 있으므로. 만약 null만 아니고 안에 갯수가 0이라며면 보여줄 수 없으므로.
			System.out.println("[ 전체 회원 목록 ]");
			for (Person p : this.list) {
				System.out.println(p);
			}
		} else {
			System.out.println("No Data.");
		}
	}
}
