

//자바의 정석 p201 5-10 오름차순 정렬
import java.util.Scanner;
public class ArrayDemo {
public static void main(String[] args) {
		int [] array = {6, 9, 2, 5, 1, 7, 2, 3, 5, 9, 3};
		System.out.println("Before sorting");
		for(int i = 0 ; i <array.length; i++) 
		System.out.printf("%d\t", array[i]);
		System.out.println();
		
		for(int i = 0; i < array.length - 1 ; i++)	{
			for(int j = 0 ; j <  array.length -1 ; j++) {	
					if(array[j] > array[j+1]) {
					int temp = array [j];
					array[j] = array[j+1];
					array[j+1] = temp;	
				}
			}
		}
		System.out.println("After Sorting");
		for(int i = 0 ; i <array.length; i++) System.out.printf("%d\t", array[i]);
}
}









