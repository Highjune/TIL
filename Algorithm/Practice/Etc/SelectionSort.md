# 내가 만든 것

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

##