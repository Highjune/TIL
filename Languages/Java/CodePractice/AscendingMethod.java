//배열과 메소드
//배열을 넘겨서~ 

//오름차순. 메소드 만드는 것

public class AscendingMethod {
	public static void main(String[] args) {
		int [] array = {4, 8, 1, 2, 6, 3, 9, 0};
		AscendingMethod md = new AscendingMethod();
		md.display(array); //전 //array 는 주소. 그래서 call by refe~. 배열은 무조건 주소를 넘긴다. 배열은 무조건 call by refe~.그래서 메소드 안에서 배열이 수정되면 메인에 다 반영이 된다.
		md.bubbleSort(array);
		md.display(array);	//후
		
}
//display는 배열이 넘어오면 그냥 그 배열을 처음부터 쭉 찍는 것.
	
	void bubbleSort(int [] array) { //bubbleSort는 1번 sorting한다고 되는 것이 아니다. 대신 장점은 i와 j의 범위가 같다~ (length-1)
		for(int i = 0 ; i <array.length - 1 ; i++) {
			for(int j = 0 ; j < array.length -1 ; j++) {
				if(array[j] > array[j+1]) {
					int temp = array[j]; 
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}
	
	
	void display(int[] array) {  //array 는 지역변수이므로 메인의 array 와 다르다.
		for(int su : array) 
		System.out.printf("%d\t", su);
		System.out.println();
	}
}

