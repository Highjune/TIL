
public class Sort {
	private Student[] array;
	
	public Sort(Student[] array) {
		this.array = array;		
	}
	
	public void bubblesort() {
		for(int i =0 ; i<array.length -1 ; i++) {
			for(int j=0 ; j<array.length -1 -i ; j++) {
				if(array[j].getTot() < array[j].getTot()) {
					Student tmp = array[j+1];
					array[i+1] = array[i];
					array[i] = tmp;					
				}				
			}			
		}		
	}
	
}
