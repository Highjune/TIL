import java.util.ArrayList;
import java.util.Collections;

//�����ȣ ������ �������� ����
public class Sort {
	private ArrayList<Member> list;

	public Sort(ArrayList<Member> list) {
		this.list = list;
	}
	
	public void sort() {
		Collections.sort(this.list);
	}
}




