PermCheck

> [문제링크](https://app.codility.com/programmers/lessons/4-counting_elements/perm_check/)


## 내 풀이(푸는 중)
```
package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
	public static void main(String[] args) {
		int[] arr = new int[] {4, 1, 3, 2};
		Solution ss = new Solution();
		ss.solution(arr);
	}
	
	public int solution(int[] A) {
		int result = -2;
		
		Arrays.sort(A); // 4, 1, 3, 2
		
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0 ; i < A.length ; i++) {
			list.add(A[i]);
		}
		
		for (int i = 0 ; i < list.size() ; i++) {
			System.out.println(i + " : " + list.get(i));
		}
		
		int arrayMaxNum = Collections.max(list);
		
		for (int i = 0 ; i < arrayMaxNum ; i++) {
			if (!(list.get(i) == i+1)) {
				return -1;
			} else {
				return 0;
			}
		}
		
		return result;
    }
}

```