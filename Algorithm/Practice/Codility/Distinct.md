Distinct

> [문제링크](https://app.codility.com/programmers/lessons/6-sorting/distinct/)


## 내 풀이. 100%, O(N*log(N)) or O(N)
```
class Solution {
    public int solution(int[] A) {
		int result = -1;
		
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0 ; i < A.length ; i++) {
			set.add(A[i]);
		}
		
		result = set.size();
		
		return result;
    }
}
```