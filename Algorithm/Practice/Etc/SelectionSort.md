# 내 풀이

```
public class SelectionSort {
	
	public int[] Solution(int[] arr) {
		
		for (int i = 0 ; i < arr.length - 1 ; i++) {
			int min = Integer.MAX_VALUE;
			int position = -1;
			for (int j = i ; j < arr.length ; j++) {
				if (arr[j] < min) {
					min = arr[j];
					position = j;
				}
			}
			arr[position] = arr[i];
			arr[i] = min;
		}
		
		return arr;
	}
}

```

# 자바로 배우는 쉬운 자료구조
```
import jdk.swing.interop.SwingInterOpUtils;

public class Sort {
    public void selectionSort(int[] a) {
        int i, j, min;
        for (i = 0 ; i < a.length - 1 ; i++) {
            min = i;
            for (j = i + 1 ; j < a.length ; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            swap(a, min, i);
            System.out.printf("\n선택 정렬 %d 단계 : ", i+1);
            for (j = 0 ; j < a.length ; j++){
                System.out.printf("%3d ", a[j]);
            }
        }
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {69, 10, 30, 2, 16, 8, 31, 22};
        Sort s = new Sort();
        System.out.printf("\n정렬할 원소 : ");
        for(int i = 0 ; i < a.length ; i++) {
            System.out.printf(" %d", a[i]);
        }
        System.out.println();
        s.selectionSort(a);
    }

}
```


# 타인 풀이
- 재귀호출
- https://www.youtube.com/watch?v=uCUu3fF5Dws

```
public class Test {
	private static void selectionSort(int[] arr) {
		selectionSort(arr, 0); // 두번째 파라미터 : 정렬이 안된부분의 시작위치. 처음에는 아무것도 정렬되어 있지 않으므로 첫번째 방(0)에 시작방.
	}
	private static void selectionSort(int[] arr, int start) {
		// 정렬을 시작하는 방이 마지막방 -1 까지 재귀함수 호출
		if (start < arr.length - 1) {
			int min_index = start;
			for (int i = start; i < arr.length ; i++) {
				if (arr[i] < arr[min_index]) min_index = i;
			}	
				swap(arr, start, min_index);
				selectionSort(arr, start + 1);
		}
	}
	
	private static void swap (int[] arr, int index1, int index2) {
		int tmp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = tmp;
	}
	
	private static void printArray(int[] arr) {
		for (int data : arr) {
			System.out.print(data + ",");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] arr = {3, 6, 1, 8, 2, 4};
		printArray(arr);
		selectionSort(arr);
		printArray(arr);
		
	}
}
```