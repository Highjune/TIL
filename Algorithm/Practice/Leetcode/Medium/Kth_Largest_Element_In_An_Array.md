# Kth_Largest_Element_In_An_Array
- [문제](https://leetcode.com/problems/kth-largest-element-in-an-array/description/)
- 우선순위 큐
- 풀이
    1. 2021.10.29 (성공)

# 내 풀이
- 그런데 아래처럼 풀면 안되려나??
```
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - 1 -(k-1)];
    }
}
```



# 타인 풀이
- https://www.youtube.com/watch?v=ifGUwB_PCt4&list=PL2mzT_U4XxDl8PP-jMk4rt6BPzBtS__pQ&index=19
```

```