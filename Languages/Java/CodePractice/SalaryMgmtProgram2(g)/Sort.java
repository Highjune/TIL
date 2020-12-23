class Sort {
	private Employee [] array;
	private int count;
	
	public Sort(Employee [] array, int count){
		this.array = array;
		this.count = count;
	}
	
	void selectionSort(){
		for(int i = 0 ; i < this.count - 1; i++){
			for(int j = i + 1 ; j < this.count ; j++){
				Employee first = this.array[i];
				Employee second = this.array[j];
				if(first.getSabun() > second.getSabun())
					swap(i, j);
			}
		}
	}
	void swap(int a, int b){
		Employee temp = this.array[a];
		this.array[a] = this.array[b];
		this.array[b] = temp;
	}
}
