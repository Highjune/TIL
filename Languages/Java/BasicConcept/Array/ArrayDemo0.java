//�迭�� �־ �ִ밪�� �ּҰ� : �ڹ��� ���� p197 ���� 5-6
import java.util.Scanner;
public class ArrayDemo0 {
	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int[] array = new int[10];
	for(int i = 0 ; i<array.length; i++) {
		array[i] = scan.nextInt();
	}  //�Է³�

	int max = array[0], min = array[0];
	int i = 1; //�ʱ��, max�� ���� ��(0)�� �־����ϱ� 1���� ���ϸ� ��.
	while(i < array.length) { //����
		if(max < array[i]) 
			max = array [i];
		if(min < array[i]) 
			min = array [i];
		i++; // ������ (���� ���� ���� �ȵǱ� ������)
	}
	System.out.println("max = " + max + ", min =" + min);
}
}