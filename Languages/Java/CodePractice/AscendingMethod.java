//�迭�� �޼ҵ�
//�迭�� �Ѱܼ�~ 

//��������. �޼ҵ� ����� ��

public class AscendingMethod {
	public static void main(String[] args) {
		int [] array = {4, 8, 1, 2, 6, 3, 9, 0};
		AscendingMethod md = new AscendingMethod();
		md.display(array); //�� //array �� �ּ�. �׷��� call by refe~. �迭�� ������ �ּҸ� �ѱ��. �迭�� ������ call by refe~.�׷��� �޼ҵ� �ȿ��� �迭�� �����Ǹ� ���ο� �� �ݿ��� �ȴ�.
		md.bubbleSort(array);
		md.display(array);	//��
		
}
//display�� �迭�� �Ѿ���� �׳� �� �迭�� ó������ �� ��� ��.
	
	void bubbleSort(int [] array) { //bubbleSort�� 1�� sorting�Ѵٰ� �Ǵ� ���� �ƴϴ�. ��� ������ i�� j�� ������ ����~ (length-1)
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
	
	
	void display(int[] array) {  //array �� ���������̹Ƿ� ������ array �� �ٸ���.
		for(int su : array) 
		System.out.printf("%d\t", su);
		System.out.println();
	}
}

