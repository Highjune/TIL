
public class Sort {
	private Student[] array;   //member  variable
	
	public Sort(Student[] array) {
		this.array = array;
	}

	public void bubbleSort() {
		for(int i = 0 ; i < this.array.length - 1 ; i++) {
			for(int j = 0 ; j < this.array.length - 1 - i; j++) {
				if(this.array[j].getTot() < this.array[j+1].getTot()) {
					Student temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}
}

