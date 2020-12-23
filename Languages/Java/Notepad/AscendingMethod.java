package practice;

public class AscendingMethod {
	public static void main(String[] args) {
		// 1~100 임의의 랜덤 수 8개 받아서 bubble 정렬(오름차순) 전, 후 구분해서 정렬하기
		int[] numbers = new int[8];	
		
		for(int i = 0 ; i<8 ; i++) {
			numbers[i] = ((int)(Math.random()*100)+1);  // 0.0<= x < 1.0 , 00.0 <= 100x < 100.0 ,  
		}
		
		AscendingMethod am = new AscendingMethod();
		am.beforeArray(numbers);
		am.bubbleSortArray(numbers);
		am.afterArray(numbers);
	}	
	
	
	public void beforeArray(int[] array) {
		System.out.println("====배열 전====");
		for(int number : array) {			
			System.out.print(number + "\t");			
		}
		System.out.println();
	}
	
	public void bubbleSortArray(int[] array) { 
		for(int i = 0; i< array.length -1 ; i++) { // 8개의 수
			for(int j = 0 ; j < array.length -1 -i ;  j++) { // array.length-1 로 해도 된다. 상위 for문의 조건절과 같아서 외우기 쉽지만, 사실 이미 정렬되어 있는 것도 확인하게 되는 것이므로 효율 떨어짐.
				int temp = -1;
				if(array[j] > array[j+1]) {
					temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}			
	}
	
	public void afterArray(int[] array) {
		System.out.println("====배열 후====");
		for(int number : array) {
			System.out.print(number + "\t");
		}
	}
		
	
	
}


