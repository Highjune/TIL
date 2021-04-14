MaxProfit

> [문제링크](https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_profit/)


## 내 풀이
```

public class Solution {
	public static void main(String[] args) {
		int[] arr = new int[] {23171, 21011, 21123, 21366, 21013, 21367};
		Solution s = new Solution();
		System.out.println("===");
		System.out.println(s.solution(arr));
		System.out.println("===");
	}
	
	public int solution(int[] A) {
		int max = 0;
		
		for (int i = 0 ; i < A.length - 1 ; i++) {
			for (int j = i + 1 ; j < A.length ; j++) {
				if (A[j] - A[j-1] > max) {
					max = A[j] - A[j-1];
					System.out.println(max);
				}
			}
		}
		
		return max;
	}
}


``` 