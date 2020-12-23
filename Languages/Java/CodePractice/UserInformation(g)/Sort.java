import java.util.ArrayList;
import java.util.Collections;

//사원번호 순으로 오름차순 정렬
public class Sort {
	private ArrayList<Member> list;

	public Sort(ArrayList<Member> list) {
		this.list = list;
	}
	
	public void sort() {
		Collections.sort(this.list);
	}
}




