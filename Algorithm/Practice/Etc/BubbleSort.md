# 내 풀이1-1
- 이중 for문
- 뒤에서부터 정렬
```

public class BubbleSort {
	public static void main(String[] args) {
		int[] arr = new int[] {3, 5, 4, 2, 1};
		
		for (int i = 0 ; i < arr.length ; i++) {
			for (int j = arr.length - 1 ; j > i ; j--) {
				if (arr[j] < arr[j-1]) {
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}
			}
		}
		
		for (int k : arr) {
			System.out.println(k);
		}
	}
	
}
```

# 내 풀이1-2
- 이중 for문
- 앞서부터 정렬
```
public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = new int[] {3, 5, 4, 2, 1};
		
		for (int i = 0 ; i < arr.length - 1 ; i++) {
			for (int j = 0 ; j < arr.length - 1 - i ; j++) {
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		for (int k : arr) {
			System.out.println(k);
		}
	}
}
```

# 내 풀이2
- 재귀호출
```

public class BubbleSort {
	
	private static void BubbleSort(int[] arr) {
		BubbleSort(arr, 0);
	}
	
	private static void BubbleSort(int[] arr, int endPoint) {
		if (endPoint < arr.length - 2) {
			for (int i = arr.length - 1 ; i > 0 ; i--) {
				if (arr[i] < arr[i-1]) {
					swap(arr, i);
				}
				endPoint++;
				BubbleSort(arr, endPoint);
			}
		}
	}
	
	
	//swap
	private static void swap(int[] arr, int i) {
		int temp = arr[i];
		arr[i] = arr[i-1];
		arr[i-1] = temp;
	}
	
	//printArray
	private static void printArray(int[] arr) {
		for (int k : arr) {
			System.out.print(k + ",");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {3, 5, 4, 2, 1};
		 printArray(arr);
		 BubbleSort(arr);
		 System.out.println("=======after======");
		 printArray(arr);
	}
	
}
```

# 자바로 배우는 쉬운 자료구조
```
import jdk.swing.interop.SwingInterOpUtils;

public class Sort {
    public void bubbleSort(int a[]) {
        int i, j, temp, size;
        size = a.length;
        for (i = size - 1 ; i > 0 ; i--) {
            System.out.printf("\n버블 정렬 %d 단계 : ", size - i);
            for (j = 0 ; j < i ; j++) {
//                if (a[j] < a[j+1]) { // 반대로 정렬됨
                if (a[j] > a[j+1]) {
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
                System.out.printf("\n\t");
                for (int k = 0 ; k < size ; k++) {
                    System.out.printf("%3d   ", a[k]);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {69, 10, 30, 2, 16, 8, 31, 22};
        Sort s = new Sort();
        System.out.printf("\n정렬할 원소 : ");
        for (int i = 0 ; i < a.length ; i++) {
            System.out.printf(" %d", a[i]);
        System.out.println();
        s.bubbleSort(a);
        }
    }
}
```


# 타인 풀이
- 재귀호출
- https://www.youtube.com/watch?v=YbsQiiubO74

```

// 앞에서부터 정렬함(더 큰 값을 뒤로 보냄)
public class test {
	private static void bubbleSort(int[] arr) {
		bubbleSort(arr, arr.length-1); // 배열 중에서 정렬 안된 부분의 index를 넘김. 처음에는 모든 배열방이 정렬이 안된 상태이므로.
	}
	
	private static void bubbleSort(int[] arr, int last) {
		if (last > 0) {
			for (int i = 1 ; i <= last ; i++) {
				if (arr[i-1] > arr[i]) {
					swap(arr, i-1, i);
				}
			}
			bubbleSort(arr, last - 1); // 마지막 인덱스는 정렬이 되었으므로 제외
		}
	}
	
	private static void swap(int[] arr, int source, int target) {
		int tmp = arr[source];
		arr[source] = arr[target];
		arr[target] = tmp;
	}
	
	private static void printArray(int[] arr) {
		for (int data : arr) {
			System.out.print(data + ",");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] arr = {3, 5, 4, 2, 1};
		printArray(arr);
		bubbleSort(arr);
		printArray(arr);
	}
}
```

