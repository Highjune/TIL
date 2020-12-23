import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

public class Sort {
	private Vector<Student> vector;   //member  variable
	
	public Sort(Vector<Student> vector) {
		this.vector = vector;
	}

	public void sort() {
		//Collections.sort(this.vector);
		Collections.sort(this.vector, new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				return s1.getTot() > s2.getTot() ? -1 :
								s1.getTot() == s2.getTot() ? 0 : 1;
			}
		});
	}
}


