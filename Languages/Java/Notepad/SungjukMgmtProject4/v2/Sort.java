
public class Sort {
	public Student[] array;
	
	Sort(Student[] array) {
		this.array = array;		
	}
	
	void sort(Student[] array) {
		for(int i = 0 ; i < array.length -1 ; i++) {
			for(int j = 0 ; j < array.length-1-i ; j++) {
				if(array[j].getTot() < array[j+1].getTot()) {
					Student tmp = array[j+1];
					array[j+1] = array[i];
					array[j] = tmp;															
				}
			}			
		}
	}
}
