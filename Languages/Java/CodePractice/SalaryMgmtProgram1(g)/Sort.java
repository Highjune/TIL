import java.util.Collections;
import java.util.Vector;

//�����ȣ ������ �������� ����
public class Sort {
	private Vector<Salary> vector;

	public Sort(Vector<Salary> vector) {
		this.vector = vector;
	}
	
	public void sort() {
		Collections.sort(this.vector);
	}
}




