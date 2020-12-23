public class Sort {
	private Patient [] array;
	private int count;

	public Sort(Patient [] array, int count){
		this.array = array;
		this.count = count;
	}

	public void bubbleSort(){
		for(int i = 0 ; i < count - 1 ; i++){
			for(int j = 0 ; j < count - 1 - i; j++){
				if(this.array[j].getBunho() > this.array[j+1].getBunho()){
					Patient temp = this.array[j];
					this.array[j] = this.array[j+1];
					this.array[j+1] = temp;
				}
			}
		}
	}
}
