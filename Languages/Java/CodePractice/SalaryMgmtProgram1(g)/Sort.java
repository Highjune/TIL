import java.util.Collections;
import java.util.Vector;

//사원번호 순으로 오름차순 정렬
public class Sort {
	private Vector<Salary> vector;

	public Sort(Vector<Salary> vector) {
		this.vector = vector;
	}
	
	public void sort() {
		Collections.sort(this.vector);
	}
}




