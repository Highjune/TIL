# 내 풀이1
- 이중 for문
- 뒤에서부터 정렬함(앞에서 시작해도 상관없음)
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

# 내 풀이2
- 재귀적으로
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


# 타인 풀이
- 재귀적으로
- https://www.youtube.com/watch?v=YbsQiiubO74

```

```